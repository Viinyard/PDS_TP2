; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [19 x i8]c" est different de \00", align 1
@.str2 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str5 = private unnamed_addr constant [9 x i8]c"%d%s%d%s\00", align 1
@.str3 = private unnamed_addr constant [13 x i8]c" est egal a \00", align 1
@.str4 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str6 = private unnamed_addr constant [9 x i8]c"%d%s%d%s\00", align 1

define void @main() {
entry:
	call void @compare(i32 2, i32 1)
	call void @compare(i32 1, i32 2)
	call void @compare(i32 1, i32 1)
	ret void 
}

define void @compare(i32, i32) {
entry:
	%2 = alloca i32
	%3 = alloca i32
	store i32 %0, i32* %2
	store i32 %1, i32* %3
	%4 = load i32, i32* %2
	%5 = load i32, i32* %3
	%6 = sub i32 %4, %5
	%7 = icmp ne i32 %6, 0
	br i1 %7, label %then1, label %else2
then1:
	%8 = load i32, i32* %2
	%9 = getelementptr inbounds [19 x i8], [19 x i8]* @.str1, i32 0, i32 0
	%10 = load i32, i32* %3
	%11 = getelementptr inbounds [2 x i8], [2 x i8]* @.str2, i32 0, i32 0
	%12 = getelementptr inbounds [9 x i8], [9 x i8]* @.str5, i32 0, i32 0
	%13 = call i32 (i8*, ...) @printf(i8* %12, i32 %8, i8* %9, i32 %10, i8* %11)
	br label %fi3
else2:
	%14 = load i32, i32* %2
	%15 = getelementptr inbounds [13 x i8], [13 x i8]* @.str3, i32 0, i32 0
	%16 = load i32, i32* %3
	%17 = getelementptr inbounds [2 x i8], [2 x i8]* @.str4, i32 0, i32 0
	%18 = getelementptr inbounds [9 x i8], [9 x i8]* @.str6, i32 0, i32 0
	%19 = call i32 (i8*, ...) @printf(i8* %18, i32 %14, i8* %15, i32 %16, i8* %17)
	br label %fi3
fi3:
	ret void 
}


