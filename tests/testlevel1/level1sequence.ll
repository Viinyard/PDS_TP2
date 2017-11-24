; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [5 x i8]c"toto\00", align 1
@.str3 = private unnamed_addr constant [3 x i8]c"%s\00", align 1
@.str2 = private unnamed_addr constant [5 x i8]c"titi\00", align 1
@.str4 = private unnamed_addr constant [3 x i8]c"%s\00", align 1

define void @main() {
entry:
	%0 = getelementptr inbounds [5 x i8], [5 x i8]* @.str1, i32 0, i32 0
	%1 = getelementptr inbounds [3 x i8], [3 x i8]* @.str3, i32 0, i32 0
	%2 = call i32 (i8*, ...) @printf(i8* %1, i8* %0)
	%3 = getelementptr inbounds [5 x i8], [5 x i8]* @.str2, i32 0, i32 0
	%4 = getelementptr inbounds [3 x i8], [3 x i8]* @.str4, i32 0, i32 0
	%5 = call i32 (i8*, ...) @printf(i8* %4, i8* %3)
	ret void 
}


