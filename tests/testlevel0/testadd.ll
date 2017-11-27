; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
; <label>:0
	%1 = alloca i32
	%2 = add i32 2, 8
	%3 = add i32 %2, 10
	%4 = add i32 %3, 20
	%5 = add i32 %4, 2
	store i32 %5, i32* %1
	%6 = load i32, i32* %1
	ret i32 %6
}


