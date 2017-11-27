; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [3 x i8]c"%d\00", align 1

define void @main(i32) {
; <label>:1
	%2 = alloca i32
	%3 = alloca i32
	store i32 %0, i32* %2
	store i32 100, i32* %3
	%4 = load i32, i32* %3
	%5 = getelementptr inbounds [3 x i8], [3 x i8]* @.str1, i32 0, i32 0
	%6 = call i32 (i8*, ...) @printf(i8* %5, i32 %4)
	ret void 
}


