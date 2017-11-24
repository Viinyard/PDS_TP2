; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
entry:
	%0 = alloca i32
	br label %entry1
entry1:
	%1 = icmp ne i32 1, 0
	br i1 %1, label %do2, label %done3
do2:
	store i32 0, i32* %0
	br label %entry1
done3:
	%2 = load i32, i32* %0
	ret i32 %2
	ret i32 0
}


