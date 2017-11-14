; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
	%tmp1 = icmp ne i32 1, 0
	br i1 %tmp1, label %then1, label %else2
then1:
	ret i32 1
	br label %fi3
else2:
	ret i32 0
	br label %fi3
fi3:
	ret i32 0
}


