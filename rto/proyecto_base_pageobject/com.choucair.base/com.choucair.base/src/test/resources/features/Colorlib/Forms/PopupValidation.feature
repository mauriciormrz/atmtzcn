#Author: your.email@your.domain.com
@Regresion
Feature: Formulario Popup Validation
  El usuario debe poder ingresar al formulario los datos requeridos.
  Cada campo del formulario realiza validaciones de obligatoriedad,
  longitud y formato, el sistema debe presentar las validaciones respectivas
  para cada campo a traves un globo informativo.

  @CasoExitoso
  Scenario: Diligenciamiento exitoso del formulario Popup Validation,
    no se presenta ningun mensaje de validacion.

    Given Autentico en colorlib con usuario "demo" y clave "demo"
    And Ingreso a la funcionalidad Forms Validation
    When Diligencio Formulario Popup Validation
    Then Verifico ingreso exitoso