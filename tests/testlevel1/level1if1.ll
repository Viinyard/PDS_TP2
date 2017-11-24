; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
entry:
	%0 = alloca i32
	%1 = icmp ne i32 1, 0
	br i1 %1, label %then1, label %fi2
then1:
	store i32 1, i32* %0
	br label %fi2
fi2:
	%2 = load i32, i32* %0
	ret i32 %2
	ret i32 0
}


