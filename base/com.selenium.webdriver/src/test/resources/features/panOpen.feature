#Author: ramirezmauricio@hotmail.com

@Regresion
Feature: Quiz panOpen
  The goal of this assignment is to gauge your ability to quickly prototype a useful test case 
  for a realistic scenario in panOpen using cucumber and automation tools.

  @FacultySide
  Scenario Outline: My Classes page
    Given User logs in as faculty with email "automation+1@panopen.com" and pass "123123123"
    When User clicks create a class
    And Users fills the form
    | <Class Name> | <Start Date> | <End Date>    | <M> | <T> | <W> | <TH> | <F>  | <S> | <SU> | <Start Time> | <End Time> |
    Then Class should be properly saved

    Examples: 
      | Class Name | Start Date | End Date    | M | T | W | TH | F  | S | SU | Start Time | End Time |
      | Quiz       | 11/14/2018 | 11/14/2019  | 1 | 0 | 1 | 0  | 1  | 0 | 0  | 7:00 am    | 8:45 am  |

