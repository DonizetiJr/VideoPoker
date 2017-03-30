# VideoPoker

## Trabalho de implementação – Video Poker

O video poker é um jogo de cartas em que o usuário interage com o computador,
fazendo apostas e tentando conseguir algumas combinações específicas (as mesmas
do poker normal) que lhe dão recompensas, proporcionais ao valor que o jogador
apostou.
O baralho usado é um baralho convencional de 52 cartas, ordenadas de 2 até 10 e
depois J (valete), Q (dama), K (rei) e A (ás). Note que o A não serve como 1. Ou
seja, ele é a maior carta da sequência e não a menor.
Cada jogo inicia com o jogador recebendo uma quantidade fixa de créditos (200
créditos). Cada rodada inicia com o jogador apostando um certo número de créditos,
maior que zero e menor ou igual ao número de créditos que possui. Feito isso, o
jogador recebe cinco cartas e deve tentar fazer uma das combinações que lhe paguem
os prêmios. Para isso, o jogador pode escolher trocar de zero a cinco cartas que
recebeu. Em seguida, pode trocar mais uma vez as cartas para alcançar alguma
combinação.

### As combinações que premiam o jogador, e os respectivos valores são os seguintes:

Combinação Prêmio

- Dois pares Valor da aposta
- Trinca 2 X valor da aposta
- Straight (5 cartas seguidas de naipes diferentes) 5 X valor da aposta
- Flush (5 cartas do mesmo naipe não seguidas) 10 X valor da aposta
- Full hando (uma trinca e um par) 20 X valor da aposta
- Quadra 50 X valor da aposta
- Straight Flush (5 cartas seguidas do mesmo naipe) 100 X valor da aposta
- Royal Straight Flush (5 cartas seguidas do mesmo naipe de 10 até o As) 200 X valor da aposta
