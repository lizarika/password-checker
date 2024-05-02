


| N    | Case                                      | Type             | Status |
|------|-------------------------------------------|------------------|--------|
| 1    | ComplexPasswordWithDigitsAndSpecialChars  | "Password123!"   | Passed |
| ---- |-------------------------------------------| ---------------- |--------|
| 2    | ComplexPasswordWithDigitsAndSpecialChars2 | "Password12!"    | Passed |
| ---- |-------------------------------------------| ---------------- |--------|
| 3a   | FalseForShortPassword                     | "Pass!"          | Passed |
| 3b   | FalseForShortPassword                     | "qwerty1231"     | Passed |
| ---- |-------------------------------------------| ---------------- |--------|
| 4a   | FalseForNonComplexPassword                | "abcdefjklp"     | Passed |
| 4b   | FalseForNonComplexPassword                | "1234567890"     | Passed |
| 4c   | FalseForNonComplexPassword                | "abcd1234"       | Passed |
| 4d   | FalseForNonComplexPassword                | "1234,./="       | Passed |
| 4e   | FalseForNonComplexPassword                | "asdf,./="       | Passed |
| 4f   | FalseForNonComplexPassword                | "!?#,<;:-(*()"   | Passed |
| 4g   | FalseForNonComplexPassword                | " "              | Passed |
| 4h   | FalseForNonComplexPassword                | ""               | Passed |
