# swiss-wowbagger
Let yourself be insulted in swiss german.

Inspired by kthxbye's [figgdi](http://figgdi.kthxbye.ch/).
Thanks to Franz Hohler's [Totemügerli](https://www.youtube.com/watch?v=DQi0lsUs8J4),
Stiller Has' [grusig](https://www.youtube.com/watch?v=dfL_IRXVLtQ).

**[Huere Siech, säg mou öppis!](https://nidi3.github.io/swiss-wowbagger)**

## Developer's Guide

Prerequisites:
1. JDK 17
2. MBROLA (see [Install MBROLA] for instructions)
3. Optional: [GraalVM CE 21.3+ based on Java 17](https://www.graalvm.org/downloads/) (If you need to re-record native-image config files)

The apps and the docker containers are hosted at Google Cloud. [Schaltstelle](https://www.schaltstelle.ch) Members can add
themselves as _Owner_ of the project to gain access.

- [Cloud Run Overview (instances setup, logs, etc.)](https://console.cloud.google.com/run?project=swiss-wowbagger)
- [Secret Manager (credentials for Twitter/Telegram)](https://console.cloud.google.com/security/secret-manager?project=swiss-wowbagger)
- [Cloud Scheduler (Trigger for daily random Tweet)](https://console.cloud.google.com/cloudscheduler?project=swiss-wowbagger)

Everything is built and deployed automatically on push to master by Github Actions. See [Workflow config file](.github/workflows/main.yml)
for details.

### Overview

The project can be built and tested completely using `mvn clean verify`. The applications get containerized and integration tests
are run against these containers. [Wiremock](http://wiremock.org) is used to mock Twitter and Telegram APIs using recorded responsed.

For production the applications are compiled to native applications using GraalVM. This greatly reduces container startup 
time which is beneficial with Google Cloud Run as there are no instances running all the time.

Switching between native and non-native builds is made by enabling the corresponding profile in Maven: _non-native_ or _native-shade_.
To build locally using native builds run `mvn -P native-shade clean verify`. There's no need to have GraalVM available
locally as the build happens within a Docker container.

*If you make significant code changes you might need to re-record native-image config files.*
See [Record native-image config files] for instructions. If you are in panic you can remove `-Pnative-shade`from the
[Github Actions Workflow config file](.github/workflows/main.yml) and non-native applications are built and deployed.

### How to install MBROLA
The speech synthesis part of Swiss Wowbagger needs [MBROLA](https://github.com/numediart/MBROLA) to be available on your machine.

- Debian/Ubuntu Linux: you can install everything using `apt`. See [MBROLA Dockerfile](mbrola/Dockerfile) for instructions.
- Fedora Linux: MBROLA is not available in common repositories so just copy it from the base docker file using [setup-mbrola-on-fedora.sh](setup-mbrola-on-fedora.sh) 
- Windows or MacOS: copy the binaries from [mbrola-jvm](https://github.com/nidi3/mbrola-jvm) and make them available in PATH

### Auzure Speech synthesis

- https://de.wikipedia.org/wiki/Liste_der_IPA-Zeichen
- http://web.mit.edu/6.mitx/www/24.900%20IPA/IPAapp.html
- https://speech.microsoft.com/portal/af9f421b07ad40c4ac493125e0e1dfdc/audiocontentcreation

Commonly used phonemes:
æ
ɘ
ɪ
œ
øː
ʏ

χ
ʃ
ɡ
ŋ

### How to register Telegram Bot Webhook

See https://core.telegram.org/bots for instructions how to setup a developer account and get the needed credentials.

1. Set the 'telegram-*' secrets in [Secret Manager](https://console.cloud.google.com/security/secret-manager?project=swiss-wowbagger)
2. Register webhook: `curl -F "url=https://swiss-wowbagger-telegram-ultgi7by3q-oa.a.run.app/${WOWBAGGER_BOT_TOKEN}/webhook" https://api.telegram.org/bot${WOWBAGGER_BOT_TOKEN}/setWebhook`

For local testing:
1. create a public tunnel to localhost using `ngrok http 8080`
2. Switch the Telegram Bot registration to your public ngrok HTTPS URL using the curl command above

### Twitter Bot development

You need to have a Developer account with free Premium Account Activity API subscription.

Caveats:
- After creating the app in the Developer Portal make sure that "App permission" are set to "Read and write and Direct message" before creating the access tokens. 
You have to recreate them after changing this setting.
- Twitter sports the most complicated API authentication setup I've ever seen combined with very poor documentation and samples.
Use [twurl](https://github.com/twitter/twurl) to ease the pain.
- But _twurl_ also has its problems: Setting the HTTP Method using `-X POST` didn't work for me as it still used _GET_.
I used `-d 'dummy=dummy'` to make it use POST requests as a workaround.

For local testing:
1. Run `TwitterBot` using the various environment variables
2. Run `ngrok http 8080`
3. Run `twurl -d 'url=https://a9da-2a02-168-a9fe-0-73ba-8f2b-996a-a99f.ngrok.io/webhook' /1.1/account_activity/all/test/webhooks.json`. 
Replacing the ngrok url with your proper one. I couldn't find a way to remove an existing webhook so I just deleted and recreated environments.
4. Run `twurl -d 'dummy=dummy' /1.1/account_activity/all/env1/subscriptions.json`.

### Wiremock

To re-record Wiremock mappings files: 

1. Download [Wiremock Standalone](http://wiremock.org/docs/download-and-installation/)
2. `java -jar wiremock-jre8-standalone-2.31.0.jar --port 9999
3. Open http://localhost:9999/__admin/recorder and set "Target URL" to the Twitter or Telegram API. [More info](http://wiremock.org/docs/record-playback/)
4. Start the application using environment variables to redirect API calls to Wiremock. e. g. `TWITTER_BASE_URL=http://localhost:9999/1.1/`

### Record native-image config files

native-image builds uses static code analysis and  Tree Shaking to only include methods, properties, resources, etc. which are
actually used. This cannot work automatically where Reflection is used. To detect these cases GraalVM provides a JRE agent
which records every call at runtime and generates config files. See [Assisted Configuration with Tracing Agent ](https://www.graalvm.org/reference-manual/native-image/Agent/)
for more information.

For this to work make sure that the integration tests (classes ending in `*IT`) are realistic and cover 100% of use cases
where reflection is involved. This is the case in the Twitter and Telegram API libraries.

Instructions for re-recording:
1. Set JAVA_HOME: `export JAVA_HOME=/home/notizklotz/.jdks/graalvm-ce-java17-21.3.0`
2. Cd into the app's directory.
3. `mvn -Pnative -Dagent=true -DskipTests=true -DskipNativeBuild=true package exec:exec@java-agent`
4. Run the integration tests.
5. Stop the `mvn` process.
6. Copy output from `target/native/agent-output` to `src/main/resources/META-INF/native-image/guru.nidi/swiss-wowbagger-xxx`

### Setup Github Actions

To allow our Github Actions workflow to push docker images and make deployments we added a service account in GCP with
just the right permissions. An authentication key has to be added as Github Secret for this to work.

1. Go to https://console.cloud.google.com/iam-admin/serviceaccounts?project=swiss-wowbagger
2. For the _github-actions_ service account follow these instructions to download the key as JSON: https://cloud.google.com/iam/docs/creating-managing-service-account-keys#creating
3. In Github Repository settings add a Secret named _GCP_SA_KEY_ and past the JSON file's contents as value

### Setup Google Cloud SDK access
Only needed if you want to deploy from localhost.

1. Install Google Cloud SDK https://cloud.google.com/sdk/docs/install
2. Setup Google Cloud SDK https://cloud.google.com/sdk/docs/initializing (Project ID: swiss-wowbagger)
3. Configure authentication for the docker repo: `gcloud auth configure-docker europe-west6-docker.pkg.dev`
