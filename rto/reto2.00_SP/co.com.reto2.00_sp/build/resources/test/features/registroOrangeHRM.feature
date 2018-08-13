#Author: oramirezr@choucairtesting.com
@tag
Feature: Registro y verificacion de un nuevo empleado en la  pagina OrangeHRM

  @tag1
  Scenario Outline: Registro Orange HRM
    Given que Juan necesita un empleado en el OrangeHRM
    When el realiza el ingreso del registro en la aplicación
      | <FirstName> | <LastName> | <Location> | <Date_Of_Birth> | <Marital_Status> | <Gender> | <Nacionality> | <Blood_Group> | <Hobbies> |
    Then el visualiza el nuevo empleado en el aplicativo

    Examples: 
      | FirstName | LastName | Location | Date_Of_Birth | Marital_Status | Gender | Nacionality | Blood_Group | Hobbies |
      | Mauricio  | Ramirez  | New York | 1969-08-10    | Single         | M      | Colombian   | A           | Movies  |
