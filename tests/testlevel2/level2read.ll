; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str2 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str1 = private unnamed_addr constant [18 x i8]c"Le nombre lu est \00", align 1
@.str3 = private unnamed_addr constant [5 x i8]c"%s%d\00", align 1

define void @main() {
entry:
	%0 = alloca i32
	%1 = getelementptr inbounds [3 x i8], [3 x i8]* @.str2, i32 0, i32 0
	%2 = call i32 (i8*, ...) @scanf(i8* %1, i32* %0)
	%3 = getelementptr inbounds [18 x i8], [18 x i8]* @.str1, i32 0, i32 0
	%4 = load i32, i32* %0
	%5 = getelementptr inbounds [5 x i8], [5 x i8]* @.str3, i32 0, i32 0
	%6 = call i32 (i8*, ...) @printf(i8* %5, i8* %3, i32 %4)
	ret void 
}


