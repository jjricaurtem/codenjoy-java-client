call 0-settings.bat

echo off
echo        [44;93m+--------------------------------------------+[0m
echo        [44;93m!     Now we are starting java tests...      ![0m
echo        [44;93m+--------------------------------------------+[0m
echo on

call %MVNW% clean test

call lib.bat :ask