; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
; <label>:0
	%1 = alloca i32
	%2 = mul i32 10, 2
	%3 = udiv i32 %2, 4
	%4 = mul i32 %3, 1
	%5 = mul i32 3, 2
	%6 = udiv i32 %5, 2
	%7 = mul i32 %6, 7
	%8 = add i32 %4, %7
	%9 = sub i32 %8, 1
	%10 = udiv i32 8, 4
	%11 = add i32 %9, %10
	%12 = add i32 %11, 3
	%13 = add i32 %12, 5
	%14 = sub i32 %13, 1
	store i32 %14, i32* %1
	%15 = load i32, i32* %1
	ret i32 %15
}


