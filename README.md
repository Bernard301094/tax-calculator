# Sistema de Cálculo de Impostos 💰

Um programa Java que demonstra conceitos de **Herança**, **Polimorfismo** e **Classes Abstratas** através de um sistema de cálculo de impostos para pessoas físicas e jurídicas.

## 📋 Descrição do Problema

O sistema permite cadastrar N contribuintes (número fornecido pelo usuário), que podem ser:
- **Pessoa Física**: possui nome, renda anual e gastos com saúde
- **Pessoa Jurídica**: possui nome, renda anual e número de funcionários

Após o cadastro, o programa calcula e exibe o imposto pago por cada contribuinte, além do total de impostos arrecadados.

## 🧮 Regras de Cálculo

### Pessoa Física
- **Renda < $ 20.000,00**: 15% de imposto
- **Renda ≥ $ 20.000,00**: 25% de imposto
- **Dedução**: 50% dos gastos com saúde são abatidos do imposto

**Exemplo**:
- Renda: $ 50.000,00
- Gastos com saúde: $ 2.000,00
- Cálculo: (50.000 × 25%) - (2.000 × 50%) = $ 11.500,00

### Pessoa Jurídica
- **Padrão**: 16% de imposto
- **Mais de 10 funcionários**: 14% de imposto

**Exemplo**:
- Renda: $ 400.000,00
- Funcionários: 25
- Cálculo: 400.000 × 14% = $ 56.000,00

## 🏗️ Estrutura do Projeto

```
src/
├── application/
│   └── Program.java          # Classe principal com menu e lógica
├── entities/
│   ├── TaxPayer.java        # Classe abstrata base
│   ├── Individual.java      # Pessoa física
│   └── Company.java         # Pessoa jurídica
```

## 🎯 Conceitos de POO Demonstrados

### Herança
- `Individual` e `Company` herdam de `TaxPayer`
- Reutilização de código (nome, renda anual)
- Especialização através de atributos específicos

### Polimorfismo
- Lista de `TaxPayer` armazena diferentes tipos
- Método `tax()` implementado de forma específica em cada subclasse
- Comportamento dinâmico em tempo de execução

### Classes Abstratas
- `TaxPayer` é abstrata (não pode ser instanciada)
- Força implementação do método `tax()` nas subclasses
- Garante estrutura comum para todos os contribuintes

## 💻 Como Executar

1. **Compilar o projeto:**
   ```bash
   javac -d bin src/application/*.java src/entities/*.java
   ```

2. **Executar:**
   ```bash
   java -cp bin application.Program
   ```

## 📝 Exemplo de Execução

```
Enter the number of tax payers: 3

Tax payer #1 data:
Individual or company (i/c)? i
Name: Alex
Anual income: 50000.00
Health expenditures: 2000.00

Tax payer #2 data:
Individual or company (i/c)? c
Name: SoftTech
Anual income: 400000.00
Number of employees: 25

Tax payer #3 data:
Individual or company (i/c)? i
Name: Bob
Anual income: 120000.00
Health expenditures: 1000.00

TAXES PAID:
Alex: $ 11500.00
SoftTech: $ 56000.00
Bob: $ 29500.00

TOTAL TAXES: $ 97000.00
```

## 📚 Referências

Este exercício faz parte do curso **"Programação Orientada a Objetos com Java"** do Prof. Dr. Nelio Alves, focando no capítulo de **Herança e Polimorfismo**.

## 🎓 Aprendizados

- Implementação prática de herança em Java
- Uso de classes abstratas para definir contratos
- Polimorfismo para comportamentos específicos
- Organização de código em pacotes
- Boas práticas de nomenclatura e estruturação