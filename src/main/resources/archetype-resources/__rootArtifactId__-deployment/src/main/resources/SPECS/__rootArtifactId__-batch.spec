# Build-Verzeichnis fuer RPM angeben
%define _topdir @rpm.build.dir@


# Definition der Installations- und Source-Pfade
%define target_dir /opt/%{name}
%define config_dir /etc/%{name}
%define config_src_dir	%{target_dir}/classes/config
%define log_dir	/var/log/%{name}

# Benutzer und Gruppe fuer Dateien
%define user_id batch
%define group_id batch

%define fullname %{name}-%{version}
%define WarVersion @war.version@

# Benutze Kompressionsverfahren gzip (Kompatibilitaet mit aelteren BS)
%define _source_payload w9.gzdio
%define _binary_payload w9.gzdio

# Paket-Informationen
Name: @project.name@
Version: @rpm.version@
Release: @build.number@
License: Commercial
BuildArch: noarch
#URL: http://

# Der Name des Quell-Pakets, aus dem das RPM gebaut wird
Source: ${rootArtifactId}-batch-%{WarVersion}.jar

# Pr�fix um RPM bei Bedarf mit relocate an andere Stelle zu installieren
Prefix: %{target_dir}
Prefix: %{config_dir}
Prefix: %{log_dir}

# Verzeichnis in dem das WAR entpackt wird
BuildRoot : %{_tmppath}/%{fullname}-build

# Abh�ngigkeiten nicht automatisch ermitteln
AutoReqProv: no

# Zusammenfassende Beschreibung der Anwendung
Summary: PLIS-Anwendung

# Umfassende Beschreibung der Anwendung
%description
Dieses Paket enthaelt die ${rootArtifactId}-Anwendung...

# === PREP-Bereich, wird als erstes ausgef�hrt ===
%prep
# Auspacken des Quell-Pakets
%setup -q -c %{fullname}

# === BUILD-Bereich, bleibt leer, da nicht durch RPM gebaut wird ===
%build

# === INSTALL-Bereich, bereitet Paketbau vor ===
%install

# Dateien ins RPM-Build-Verzeichnis kopieren
%{__mkdir_p} $RPM_BUILD_ROOT/%{target_dir}
%{__cp} -a * $RPM_BUILD_ROOT/%{target_dir}

# Konfigs aus Webapps-Verzeichnis (config_src_dir) verschieben und im Ziel config_dir ablegen
%{__mkdir_p} $RPM_BUILD_ROOT/%{config_dir}
%{__mv} $RPM_BUILD_ROOT/%{config_src_dir}/* $RPM_BUILD_ROOT/%{config_dir}
%{__rm} -r $RPM_BUILD_ROOT/%{config_src_dir}
%{__ln_s} %{config_dir} $RPM_BUILD_ROOT/%{config_src_dir}

# Webapp-Log4j-Konfig loeschen
%{__rm} $RPM_BUILD_ROOT/%{config_dir}/log4j.properties

# Log-Verzeichnis anlegen
%{__mkdir_p} $RPM_BUILD_ROOT/%{log_dir}

# Symbolische Links fuer bequemen Zugriff auf Config- und Log-Verzeichnis
%{__ln_s} %{config_dir} $RPM_BUILD_ROOT/%{target_dir}/etc
%{__ln_s} %{log_dir} $RPM_BUILD_ROOT/%{target_dir}/log

# Allgemeine Rechte setzen
%{__chmod} u=rX,g=rX,o= -R $RPM_BUILD_ROOT/%{target_dir}

# Rechte fuer Skripte setzen
%{__chmod} u=rx,g=rx,o= -R $RPM_BUILD_ROOT/%{target_dir}/bin

# Rechte fuer Konfigs setzen
%{__chmod} u=rwX,g=rwX,o= -R $RPM_BUILD_ROOT/%{config_dir}

# Rechte fuer Log-Verzeichnis setzen
%{__chmod} u=rwX,g=rwX,o= $RPM_BUILD_ROOT/%{log_dir}


# === CLEAN-Bereich, l�scht Zwischenergebnisse === 
%clean
%{__chmod} a=rwX -R $RPM_BUILD_ROOT
%{__rm} -rf $RPM_BUILD_ROOT

# === Das Post-Skript wird nach der RPM-Installation ausgef�hrt ===
%post

# === FILE-Bereich, bestimmt Inhalte des RPMs ===
%files

# Standard-Dateiattribute festlegen
%defattr(-, %{user_id}, %{group_id}, -)

# Hauptverzeichnis des Batch ins RPM aufnehmen
%{target_dir}

# Log-Verzeichnis ins RPM aufnehmen
%dir %{log_dir}

# Config-Dateien in RPM aufnehmen, durch die Angabe %config(noreplace)
# werden die Dateien beim Update nicht �berschrieben und manuelle �nderungen
# an den Konfigs bleiben erhalten.
%config(noreplace) %{config_dir}