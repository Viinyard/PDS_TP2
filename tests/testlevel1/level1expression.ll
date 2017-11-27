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
	%3 = alloca i32
	%4 = alloca i32
	store i32 4, i32* %2
	store i32 8, i32* %3
	%5 = load i32, i32* %2
	%6 = load i32, i32* %3
	%7 = mul i32 %5, %6
	%8 = add i32 %7, 10
	store i32 %8, i32* %4
	%9 = load i32, i32* %4
	%10 = mul i32 %9, 2
	%11 = sub i32 %10, 42
	store i32 %11, i32* %1
	%12 = load i32, i32* %1
	ret i32 %12
}


