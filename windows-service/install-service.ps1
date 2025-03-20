$serviceHome = $PSScriptRoot

if (-not $env:JAVA_HOME) {
    echo 'JAVA_HOME must be defined.'
    exit 1
}

$jvmPath = "$env:JAVA_HOME\bin\server\jvm.dll"

& .\prunsrv.exe install "Example Service" `
    --Description="Example Service" `
    --Startup=manual `
    --LogPath=$serviceHome `
    --JavaHome=$env:JAVA_HOME `
    --Jvm=$jvmPath `
    --JvmOptions="-Xrs;-Duser.dir=$serviceHome" `
    --Classpath=jars\* `
    --StartMode=jvm --StartClass=org.example.ServiceApplication --StartMethod=startService `
    --StopMode=jvm --StopClass=org.example.ServiceApplication --StopMethod=stopService `
    --LogLevel Trace
