; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
; <label>:0
	%1 = alloca i32
	%2 = add i32 3, 1
	%3 = sub i32 %2, 12
	%4 = add i32 %3, 50
	store i32 %4, i32* %1
	%5 = load i32, i32* %1
	ret i32 %5
}


