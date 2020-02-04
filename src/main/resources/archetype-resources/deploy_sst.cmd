rem Deployed die HTTPInvoker-Schnittstelle.

rem Cleanup auf alle Projekte
call mvn clean

rem Deployed das Parent-Projekt
cd %dp0%
call mvn -N deploy

rem Iteriert über alle Schnittstellenprojekte
@for /F %%f in ('dir /b ${rootArtifactId}-httpinvoker-sst*') do call :deploy %%f
@pause
@goto :eof

rem Unterfunktion: Deployed das Schnittstellenprojekt
:deploy
cd %1
call mvn deploy
cd ..

:eof
