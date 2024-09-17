
  #As i system user , i would like to see if the book service function run with seamless or not

  Feature: Books

    Scenario: UserAddBook
      When Generate token the user who has "USER_1" username and "PPPassword120+/*-.,-" password
      And Add book the user who has "f5e630d0-d304-45bf-8d6c-b172427fed7e" id and "9781593277574" isbn
      Then Validate the result of response