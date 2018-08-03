#Author: oramirezr@choucairtesting.com
@tag
Feature: Reto 1.00 - Automatizacion Web

  @tag1
  Scenario Outline: Registro Web Automation Demo Site
    Given que Carlos quiere acceder a la Web Automation Demo Site
    When el realiza el registro en la pagina
      | <FirstName> | <LastName> | < Address> | <Email> | <Phone> | <Gender> | < Hobbie > | <Languages> |
    Then el verifica que se carga la pantalla con texto Double Click on Edit Icon to EDIT the Table Row

    Examples: 
      | FirstName | LastName | Address   | Email                       | Phone      | Gender | Hobbie | Languages |
      | Mauricio  | Ramirez  | Calle 27D | ramirezmauricio@hotmail.com | 3003206240 | Male   | Movies | Español   |
