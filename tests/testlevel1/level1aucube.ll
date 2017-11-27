; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
; <label>:0
	%1 = alloca i32
	%2 = alloca i32
	store i32 2, i32* %2
	%3 = load i32, i32* %2
	%4 = load i32, i32* %2
	%5 = mul i32 %3, %4
	store i32 %5, i32* %2
	%6 = load i32, i32* %2
	%7 = load i32, i32* %2
	%8 = mul i32 %6, %7
	store i32 %8, i32* %2
	%9 = load i32, i32* %2
	%10 = mul i32 %9, 2
	store i32 %10, i32* %2
	store i32 256, i32* %1
	%11 = load i32, i32* %1
	ret i32 %11
}


