#Author: Mauricio Ramirez
@Regresion
Feature: Formulario Simulacion Ahorro Inversion.
  El usuario debe poder ingresar los datos necesarios para la simulacion de ahorro e inversion
  y obtener los valores que se deben ahorrar mensualmente .
  Se deben realizar los pasos 1,2 y 3.  Verificar los valores capturados y presentar
  ahorro mensual.

  @CasoExitoso
  Scenario: Diligenciamiento de los pasos 1,2 y 3
    Given Navegacion Portal Personas
    When Se Construye tu Plan de Ahorro Inversion Paso Uno
      | Para_que | Meses | Producto             | Cuanto_dinero |
      | Viaje    | 12    | Cuenta Ahorrador     | 1000000       |
    And Se Aceptan las Disposiciones Legales Paso Dos
    Then Se Presenta Ahorro Mensual por consola Paso Tres
