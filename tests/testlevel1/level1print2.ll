; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [3 x i8]c"%d\00", align 1

define void @main() {
entry:
	%0 = getelementptr inbounds [3 x i8], [3 x i8]* @.str1, i32 0, i32 0
	%1 = call i32 (i8*, ...) @printf(i8* %0, i32 1)
	ret void 
}


