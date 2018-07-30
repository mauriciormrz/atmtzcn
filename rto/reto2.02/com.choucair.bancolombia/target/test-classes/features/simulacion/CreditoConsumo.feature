#Author: oramirezr@choucairtesting.com
@Regresion
Feature: Simular la cuota para un credito libre inversion con tasa
  variable, con plazos  (36, 48 y 60 meses) por un valor de
  10 millones

  @CasoExitoso
  Scenario: Verificar el funcionamiento de la pantalla de simulacion de creditos expuesta por el grupo
    Bancolombia, en cuanto a la presentacion de los valores calculados.

    Given Navegar en el portal para presentar formulario
    When Calcular el valor de la cuota
      | que_desea_simular | fecha_nacimiento | tasa          | producto                   | ingresos_mensuales | plazo | valor_prestamo |
      | Simula tu Cuota   | 1969-08-10       | Tasa Variable | Crédito de Libre Inversión |            1000000 |    36 |       10000000 |
    Then Verificar el resultado de la simulacion
    And Presentar por consola plan de pagos mensual
 
