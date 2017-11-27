; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
; <label>:0
	%1 = alloca i32
	%2 = icmp ne i32 1, 0
	br i1 %2, label %3, label %4
; <label>:3
	store i32 1, i32* %1
	br label %5
; <label>:4
	store i32 0, i32* %1
	br label %5
; <label>:5
	%6 = load i32, i32* %1
	ret i32 %6
}


