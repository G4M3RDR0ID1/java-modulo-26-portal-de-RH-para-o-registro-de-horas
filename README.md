# Regras do projeto
Você deverá fazer um projeto que realiza a simulação de um portal de RH para o registro de horas de trabalho de funcionários em um dia específico qualquer, onde é possível que o usuário deste portal venha a registrar a data do registro, o horário de entrada e o horário de saída (descontando por padrão 1 hora de almoço) para tipos diferentes de funcionários.

## Regras:
* Dar boas-vindas ao usuário, mostrando-lhe as opções de ação no console, permitindo-lhe criar funcionários de tipos específicos e registrar horários de entrada e saída para cada um deles nos dias que desejar.

* Existem 5 tipos de Funcionários que o usuário do sistema pode criar: gerente, coordenador, analista, assistente e estagiário.

* Caso o usuário opte por realizar o registro de horários para funcionários que são gerentes ou estagiários, o programa deve barrar, alegando que esses 2 tipos de funcionários não batem ponto.

* Cada funcionário deve ter minimamente um nome e um identificador(id). O id deve ser utilizado para realizar a busca de um funcionário, bem como a remoção dele. O usuário também deve ter a possibilidade de listar os dados de todos os registros de horas desse funcionário.
  
* Existem limites para a realização de horas extras, que dependem do tipo de funcionário. Analistas e assistentes podem fazer no máximo até 3 horas extras em um dia, ao passo que coordenadores podem fazer até 5 horas extras em um dia. Caso esses limites não sejam respeitados por parte do usuário, o programa deve impedir o usuário de realizar tal registro. O usuário também deve ser impedido de realizar um registro caso o horário de saída seja anterior ou igual ao horário de entrada; o horário de entrada seja antes das 6:00h da manhã ou quando o registro do horário de saída seja após as 22:00h.

* Para o cálculo de horas trabalhadas no dia, como mencionado, deve ser levada em consideração, por padrão, 1 hora de almoço.

### Que tal praticar?
Agora que definimos e compreendemos as regras de negócio do projeto, você está pronto pra usar os conhecimentos de orientação a objetos que aprendeu recentemente para criar o Portal de Recursos Humanos que permite que os funcionários registrem suas horas.
