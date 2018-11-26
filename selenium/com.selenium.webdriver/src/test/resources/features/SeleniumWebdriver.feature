#Author: ramirezmauricio@hotmail.com

@Regresion
Feature: Selenium WebDriver con Java
  Como automatizar pruebas de paginas web usando Selenium

  @EncontrarElementos
  Scenario: Encuentro los Componentes
    Given Navego a la pagina de internet para pruebas
    When Encuentro los componentes
    And Acciono los elementos
    Then Cierro el navegador
