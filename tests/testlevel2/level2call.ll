; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [9 x i8]c"one() = \00", align 1
@.str2 = private unnamed_addr constant [5 x i8]c"%s%d\00", align 1

define void @main() {
entry:
	%0 = getelementptr inbounds [9 x i8], [9 x i8]* @.str1, i32 0, i32 0
	%1 = call i32 @one()
	%2 = getelementptr inbounds [5 x i8], [5 x i8]* @.str2, i32 0, i32 0
	%3 = call i32 (i8*, ...) @printf(i8* %2, i8* %0, i32 %1)
	ret void 
}

define i32 @one() {
entry:
	%0 = alloca i32
	store i32 1, i32* %0
	%1 = load i32, i32* %0
	ret i32 %1
}


