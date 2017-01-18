#!/usr/bin/env bash

TEMP_OUTPUT="output.tmp"
INPUT_FILE=$1
OUTPUT_FILE=$2
PARAMETER_FILE=$(basename $3)
ASSIGNMENT_FILE=${PARAMETER_FILE:-"Solution.java"}
ASSIGNMENT_CLASS="${ASSIGNMENT_FILE%.*}"

function silentlyCleanOutput {
  rm -rf *.class *.tmp 2> /dev/null
}

silentlyCleanOutput

echo "Compiling $ASSIGNMENT_FILE ..."
echo "----------------------------------------"
javac $ASSIGNMENT_FILE

STATUS=$?
if [ $STATUS -ne 0 ]; then
  echo "Error compiling the source code."
  exit $STATUS
else
  echo "Code compiled!"
fi

echo
echo "Running $ASSIGNMENT_CLASS ..."
echo "----------------------------------------"
time cat $INPUT_FILE | java -cp . $ASSIGNMENT_CLASS | tee $TEMP_OUTPUT

echo
echo "Checking output ..."
echo "----------------------------------------"
diff $TEMP_OUTPUT <(cat $OUTPUT_FILE)

silentlyCleanOutput

STATUS=$?
if [ $STATUS -ne 0 ]; then
  echo "Test failed! Please check the diff output." >&2
  exit $STATUS
else
  echo "Test passed!"
  exit 0
fi
