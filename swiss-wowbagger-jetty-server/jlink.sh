rm -rf target/dist
$JAVA_HOME/bin/jlink -v --module-path target/modules:target/dependency:$JAVA_HOME/jmods --add-modules swiss.wowbagger.server --launcher wowbagger=swiss.wowbagger.server/guru.nidi.wowbagger.server.WowbaggerServer --output target/dist
#--strip-debug --compress 2 --no-header-files --no-man-pages