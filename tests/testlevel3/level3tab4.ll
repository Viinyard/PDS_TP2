; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str2 = private unnamed_addr constant [19 x i8]c"Tableau de taille \00", align 1
@.str3 = private unnamed_addr constant [5 x i8]c" = [\00", align 1
@.str4 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str5 = private unnamed_addr constant [2 x i8]c",\00", align 1
@.str6 = private unnamed_addr constant [3 x i8]c"%s\00", align 1
@.str7 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str8 = private unnamed_addr constant [3 x i8]c"]\0A\00", align 1
@.str9 = private unnamed_addr constant [3 x i8]c"%s\00", align 1

define void @main() {
; <label>:0
	%1 = alloca i32
	%2 = alloca [8 x i32]
	%3 = alloca i32
	store i32 0, i32* %1
	br label %4
; <label>:4
	%5 = load i32, i32* %1
	%6 = sub i32 8, %5
	%7 = icmp ne i32 %6, 0
	br i1 %7, label %8, label %16
; <label>:8
	%9 = getelementptr inbounds [3 x i8], [3 x i8]* @.str1, i32 0, i32 0
	%10 = call i32 (i8*, ...) @scanf(i8* %9, i32* %3)
	%11 = load i32, i32* %3
	%12 = load i32, i32* %1
	%13 = getelementptr inbounds [8 x i32], [8 x i32]* %2, i32 0, i32 %12
	store i32 %11, i32* %13
	%14 = load i32, i32* %1
	%15 = add i32 %14, 1
	store i32 %15, i32* %1
	br label %4
; <label>:16
	%17 = getelementptr inbounds [8 x i32], [8 x i32]* %2, i32 0, i32 0
	call void @printtab(i32 8, i32* %17)
	ret void 
}

define void @printtab(i32, i32*) {
; <label>:2
	%3 = alloca i32
	%4 = alloca i32*
	%5 = alloca i32
	store i32 %0, i32* %3
	store i32* %1, i32** %4
	%6 = getelementptr inbounds [19 x i8], [19 x i8]* @.str2, i32 0, i32 0
	%7 = load i32, i32* %3
	%8 = getelementptr inbounds [5 x i8], [5 x i8]* @.str3, i32 0, i32 0
	%9 = getelementptr inbounds [7 x i8], [7 x i8]* @.str4, i32 0, i32 0
	%10 = call i32 (i8*, ...) @printf(i8* %9, i8* %6, i32 %7, i8* %8)
	store i32 0, i32* %5
	br label %11
; <label>:11
	%12 = load i32, i32* %3
	%13 = load i32, i32* %5
	%14 = sub i32 %12, %13
	%15 = icmp ne i32 %14, 0
	br i1 %15, label %16, label %32
; <label>:16
	%17 = load i32, i32* %5
	%18 = icmp ne i32 %17, 0
	br i1 %18, label %19, label %23
; <label>:19
	%20 = getelementptr inbounds [2 x i8], [2 x i8]* @.str5, i32 0, i32 0
	%21 = getelementptr inbounds [3 x i8], [3 x i8]* @.str6, i32 0, i32 0
	%22 = call i32 (i8*, ...) @printf(i8* %21, i8* %20)
	br label %23
; <label>:23
	%24 = load i32, i32* %5
	%25 = load i32*, i32** %4
	%26 = getelementptr inbounds i32, i32* %25, i32 %24
	%27 = load i32, i32* %26
	%28 = getelementptr inbounds [3 x i8], [3 x i8]* @.str7, i32 0, i32 0
	%29 = call i32 (i8*, ...) @printf(i8* %28, i32 %27)
	%30 = load i32, i32* %5
	%31 = add i32 %30, 1
	store i32 %31, i32* %5
	br label %11
; <label>:32
	%33 = getelementptr inbounds [3 x i8], [3 x i8]* @.str8, i32 0, i32 0
	%34 = getelementptr inbounds [3 x i8], [3 x i8]* @.str9, i32 0, i32 0
	%35 = call i32 (i8*, ...) @printf(i8* %34, i8* %33)
	ret void 
}


