; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
entry1:
	%tmp1 = icmp ne i32 1, 0
	br i1 %tmp1, label %do2, label %done3
do2:
	ret i32 0
	br label %entry1
done3:
	ret i32 0
}


