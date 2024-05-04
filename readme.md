


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


9th homework. RestApiMocked test cases from swagger

| N | Case                                                | Expected | Status |
|---|-----------------------------------------------------|---------|--------|
| 1 | getOrderByIdAndCheckResponseCodeIsOk                | 200     | Passed |
| 2 | getOrderByInvalidIdAndCheckResponseCodeIsBadRequest | 400     | Passed |
| 3 | getAllOrdersAndCheckResponseCodeIsOk                | 200     | Passed |
| 4 | deleteOrderByIdAndCheckResponseCodeIsOk             | 204     | Passed |
| 5 | deleteOrderByIdAndCheckResponseCodeIsBadRequest     | 400     | Passed |


10th homework. Parametrized test

| N | Case                               | Expected | Status |
|---|------------------------------------|---------|--------|
| 1 | testWithCsvSource                  | 200     | Passed |