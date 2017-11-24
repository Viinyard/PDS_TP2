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
	store i32 2, i32* %1
	%2 = load i32, i32* %1
	%3 = load i32, i32* %1
	%4 = mul i32 %2, %3
	store i32 %4, i32* %1
	%5 = load i32, i32* %1
	%6 = load i32, i32* %1
	%7 = mul i32 %5, %6
	store i32 %7, i32* %1
	%8 = load i32, i32* %1
	%9 = mul i32 %8, 2
	store i32 %9, i32* %1
	store i32 256, i32* %0
	%10 = load i32, i32* %0
	ret i32 %10
	ret i32 0
}


