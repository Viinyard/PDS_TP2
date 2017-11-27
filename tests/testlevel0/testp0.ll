; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
; <label>:0
	%1 = alloca i32
	%2 = add i32 1, 1
	%3 = mul i32 %2, 2
	%4 = mul i32 4, 20
	%5 = udiv i32 60, 2
	%6 = sub i32 %4, %5
	%7 = mul i32 %3, %6
	%8 = add i32 2, 4
	%9 = mul i32 1, %8
	%10 = sub i32 10, %9
	%11 = add i32 %7, %10
	%12 = add i32 2, 2
	%13 = udiv i32 %11, %12
	%14 = sub i32 9, 0
	%15 = mul i32 1, %14
	%16 = sub i32 %13, %15
	store i32 %16, i32* %1
	%17 = load i32, i32* %1
	ret i32 %17
}


