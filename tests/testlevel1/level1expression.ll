; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
entry:
	%0 = alloca i32
	%1 = alloca i32
	%2 = alloca i32
	%3 = alloca i32
	store i32 4, i32* %1
	store i32 8, i32* %2
	%4 = load i32, i32* %1
	%5 = load i32, i32* %2
	%6 = mul i32 %4, %5
	%7 = add i32 %6, 10
	store i32 %7, i32* %3
	%8 = load i32, i32* %3
	%9 = mul i32 %8, 2
	%10 = sub i32 %9, 42
	store i32 %10, i32* %0
	%11 = load i32, i32* %0
	ret i32 %11
	ret i32 0
}


