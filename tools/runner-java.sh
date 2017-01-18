#!/usr/bin/env bash

TEMP_OUTPUT="output.tmp"
INPUT_FILE=$1
OUTPUT_FILE=$2
ASSIGNMENT_CLASS="Solution"

echo "Cleaning ..."
echo "----------------------------------------"
rm -rf $ASSIGNMENT_CLASS.class $TEMP_OUTPUT 2> /dev/null
echo "Cleaned!"

echo
echo "Compiling ..."
echo "----------------------------------------"
javac $ASSIGNMENT_CLASS.java

STATUS=$?
if [ $STATUS -ne 0 ]; then
  echo "Error compiling the source code."
  exit $STATUS
else
  echo "Code compiled!"
fi

echo
echo "Running ..."
echo "----------------------------------------"
cat $INPUT_FILE | java -cp . $ASSIGNMENT_CLASS | tee $TEMP_OUTPUT

echo
echo "Checking output ..."
echo "----------------------------------------"
diff $TEMP_OUTPUT <(cat $OUTPUT_FILE)

STATUS=$?
if [ $STATUS -ne 0 ]; then
  echo "Test failed! Please check the diff output." >&2
  exit $STATUS
else
  echo "Test passed!"
  exit 0
fi
