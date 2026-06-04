algoritmo "Cadastro_Clientes_SimboraViagens"

// Simbora - Agência de Viagens

var

   nomes: vetor[0..4] de caractere
   cpf: vetor[0..4] de inteiro
   destino: vetor[0..4] de caractere
   opcao, nome: caractere
   i, j, s: inteiro


procedimento inicializa()

inicio

   enquanto opcao <> "3" faca

      escreval("-- Cadastro de clientes | Simbora Viagens --")
      escreval()
      escreval("--------------------------------------------")
      escreval("------------------- MENU -------------------")
      escreval("------- Escolha uma das opções abaixo ------")
      escreval("--------------------------------------------")
      escreval()
      escreval("(1) Cadastrar cliente")
      escreval("(2) Buscar cliente")
      escreval("(3) Sair")
      escreval()

      escreva("Opção: ")
      leia(opcao)

      se opcao="1" entao
         limpatela

         se s=10 entao

            escreval("Esgotou o limite de cadastros/vagas!")

         senao

            cadastrar_cliente()
         fimse
      fimse


      se opcao="2" entao
         limpatela

         buscar_cliente()
      fimse



      se opcao="3" entao

         para i de 0 ate 4 faca
            nomes[i] <- "x"
         fimpara
         limpatela

         escreval("-- A Simbora Viagens agradece pela preferência! --")
         escreval("                 Volte sempre!                  ")

      fimse
   fimenquanto

fimprocedimento

procedimento cadastrar_cliente()

inicio

   para i de 0 ate 4 faca

      se (nomes[i]="") entao

         escreval("DIGITE OS DADOS DO CLIENTE")
         escreval()

         escreva("-> Nome: ")
         leia(nomes[i])


         escreva("-> CPF (APENAS NÚMEROS): ")
         leia(cpf[i])

         escreva("-> Destino: ")
         leia(destino[i])

         escreval()

         voltar_menu()

         s <- s + 1

         limpatela
      fimse
   fimpara

   escreval(" -> Esgotou o limite de cadastros/vagas! <-")
   escreval()

fimprocedimento

procedimento voltar_menu()

inicio

   escreva("Voltar para o menu (s/n - letra minúscula)? ") // Resposta: letra minuscula
   leia(opcao)

   se opcao="s" entao

      i <- i + 1

      limpatela

      inicializa()

   senao
      limpatela

      cadastrar_cliente()
   fimse
fimprocedimento


procedimento buscar_cliente()

inicio

   j <- 0

   escreval("PARA BUSCAR UM CADASTRO...")
   escreval()

   escreva("Informe o nome do(a) cliente: ")
   leia(nome)
   escreval()

   para i de 0 ate 4 faca

      se (nome=nomes[i]) entao

         escreval("-> Nome: ", nomes[i])
         escreval("-> CPF: ", cpf[i])
         escreval("-> Destino: ", destino[i])
         escreval()

         j <- j + 1

      fimse
   fimpara

   se (j = 0) entao

      escreval("Ops... Cliente não cadastrado!")
      escreval()

   fimse

   Voltar_menu2()

   limpatela

fimprocedimento

procedimento voltar_menu2()

inicio

   Escreva("Voltar para o MENU (s/n - letra minúscula)? ") // Resposta: letra minuscula
   leia(opcao)


   se opcao="s" entao
      limpatela

      inicializa()

   senao
      limpatela
      buscar_cliente()
   fimse
fimprocedimento

inicio

   inicializa()

fimalgoritmo
