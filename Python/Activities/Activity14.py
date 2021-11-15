def fibonacciseries(number):
    if number <= 1:
        return number
    else:
        return(fibonacciseries(number-1) + fibonacciseries(number-2))

num = int(input("Enter a number: "))

if num <= 0:
    print("Please enter a positive number")
else:
    print("Fibonacci Sequence: ")
    for i in range(num):
        print(fibonacciseries(i))