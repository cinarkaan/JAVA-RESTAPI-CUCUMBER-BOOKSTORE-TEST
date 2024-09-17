@USER

  #https://bookstore.toolsqa.com/swagger/#/

  # As i system user , i would like to see test if the users are to added as properly or not

  #REGULATIONS

  # Passwords must have at least one non alphanumeric character,
  # one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'),
  # one special character and Password must be eight characters or longer.

  Feature:User

    #The user will be fetched
    Scenario: FetchUser
      When Generate token the user who has "USER_1" username and "PPPassword120+/*-.,-" password
      Then Get the user who has "f5e630d0-d304-45bf-8d6c-b172427fed7e" userid , "USER_1" username and "PPPassword120+/*-.,-" password

  #The user will be added seamless
    Scenario:AddUserWithPositive
      When The user who has "User16" email and "PPPassword120+/*-.,-" password will be added
      Then Response will be confirmed as 200 code ok

#The password must be contain at least one digit 0 - 9
    Scenario:AddUserWithNegativeWithoutDigit
      When The user who has "User5" email and "PPPassword+/*-," password will be added
      Then Response will be confirmed as 400 code ok

#The password must be contain at least one SpecialChar
    Scenario: AddUserWithNegativeWithoutSpecialChar
      When The user who has "User6" email and "PPPassword1230" password will be added
      Then Response will be confirmed as 400 code ok

#The password must be contain at least one UpperCase
    Scenario: AddUserWithNegativeWithoutUpperCase
      When  The user who has "User7" email and "password123+/*-.," password will be added
      Then  Response will be confirmed as 400 code ok

#The password must be consist eight characters or longer
    Scenario: AddUserWithNegativeLessThenEightChars
      When The user who has "User8" email and "Pa1+/*" password will be added
      Then Response will be confirmed as 400 code ok

#The password must be have at least one alphanumeric character
    Scenario: AddUserWithNegativeNonAlphanumericChar
      When The user who has "User9" email and "Password123" password will be added
      Then Response will be confirmed as 400 code ok


