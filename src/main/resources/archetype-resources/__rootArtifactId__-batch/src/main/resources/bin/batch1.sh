#! /bin/bash

BATCHDIR="${0%/*}"
"$BATCHDIR"/batch-ausfuehren.sh -start -cfg /resources/batch/batch-1-config.properties -Batchrahmen.Ergebnisdatei /batch-1_out.xml
