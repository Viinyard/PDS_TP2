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
	store i32 1, i32* %2
	%3 = load i32, i32* %2
	store i32 %3, i32* %1
	%4 = load i32, i32* %1
	ret i32 %4
}


