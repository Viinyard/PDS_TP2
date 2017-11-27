; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [25 x i8]c"Main: Tableau de taille \00", align 1
@.str2 = private unnamed_addr constant [5 x i8]c" = [\00", align 1
@.str3 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str4 = private unnamed_addr constant [2 x i8]c",\00", align 1
@.str5 = private unnamed_addr constant [3 x i8]c"%s\00", align 1
@.str6 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str7 = private unnamed_addr constant [3 x i8]c"]\0A\00", align 1
@.str8 = private unnamed_addr constant [3 x i8]c"%s\00", align 1
@.str9 = private unnamed_addr constant [5 x i8]c"Fini\00", align 1
@.str10 = private unnamed_addr constant [3 x i8]c"%s\00", align 1
@.str11 = private unnamed_addr constant [11 x i8]c"entrezno :\00", align 1
@.str12 = private unnamed_addr constant [3 x i8]c"  \00", align 1
@.str13 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str14 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str15 = private unnamed_addr constant [19 x i8]c"Tableau de taille \00", align 1
@.str16 = private unnamed_addr constant [5 x i8]c" = [\00", align 1
@.str17 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str18 = private unnamed_addr constant [2 x i8]c",\00", align 1
@.str19 = private unnamed_addr constant [3 x i8]c"%s\00", align 1
@.str20 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str21 = private unnamed_addr constant [3 x i8]c"]\0A\00", align 1
@.str22 = private unnamed_addr constant [3 x i8]c"%s\00", align 1

define void @main() {
; <label>:0
	%1 = alloca i32
	%2 = alloca i32
	%3 = alloca [2 x i32]
	store i32 2, i32* %2
	%4 = load i32, i32* %2
	%5 = getelementptr inbounds [2 x i32], [2 x i32]* %3, i32 0, i32 0
	call void @readprinttab(i32 %4, i32* %5)
	%6 = getelementptr inbounds [25 x i8], [25 x i8]* @.str1, i32 0, i32 0
	%7 = load i32, i32* %2
	%8 = getelementptr inbounds [5 x i8], [5 x i8]* @.str2, i32 0, i32 0
	%9 = getelementptr inbounds [7 x i8], [7 x i8]* @.str3, i32 0, i32 0
	%10 = call i32 (i8*, ...) @printf(i8* %9, i8* %6, i32 %7, i8* %8)
	store i32 0, i32* %1
	br label %11
; <label>:11
	%12 = load i32, i32* %2
	%13 = load i32, i32* %1
	%14 = sub i32 %12, %13
	%15 = icmp ne i32 %14, 0
	br i1 %15, label %16, label %31
; <label>:16
	%17 = load i32, i32* %1
	%18 = icmp ne i32 %17, 0
	br i1 %18, label %19, label %23
; <label>:19
	%20 = getelementptr inbounds [2 x i8], [2 x i8]* @.str4, i32 0, i32 0
	%21 = getelementptr inbounds [3 x i8], [3 x i8]* @.str5, i32 0, i32 0
	%22 = call i32 (i8*, ...) @printf(i8* %21, i8* %20)
	br label %23
; <label>:23
	%24 = load i32, i32* %1
	%25 = getelementptr inbounds [2 x i32], [2 x i32]* %3, i32 0, i32 %24
	%26 = load i32, i32* %25
	%27 = getelementptr inbounds [3 x i8], [3 x i8]* @.str6, i32 0, i32 0
	%28 = call i32 (i8*, ...) @printf(i8* %27, i32 %26)
	%29 = load i32, i32* %1
	%30 = add i32 %29, 1
	store i32 %30, i32* %1
	br label %11
; <label>:31
	%32 = getelementptr inbounds [3 x i8], [3 x i8]* @.str7, i32 0, i32 0
	%33 = getelementptr inbounds [3 x i8], [3 x i8]* @.str8, i32 0, i32 0
	%34 = call i32 (i8*, ...) @printf(i8* %33, i8* %32)
	%35 = getelementptr inbounds [5 x i8], [5 x i8]* @.str9, i32 0, i32 0
	%36 = getelementptr inbounds [3 x i8], [3 x i8]* @.str10, i32 0, i32 0
	%37 = call i32 (i8*, ...) @printf(i8* %36, i8* %35)
	ret void 
}

define void @readprinttab(i32, i32*) {
; <label>:2
	%3 = alloca i32
	%4 = alloca i32*
	%5 = alloca i32
	store i32 %0, i32* %3
	store i32* %1, i32** %4
	store i32 0, i32* %5
	br label %6
; <label>:6
	%7 = load i32, i32* %3
	%8 = load i32, i32* %5
	%9 = sub i32 %7, %8
	%10 = icmp ne i32 %9, 0
	br i1 %10, label %11, label %24
; <label>:11
	%12 = getelementptr inbounds [11 x i8], [11 x i8]* @.str11, i32 0, i32 0
	%13 = load i32, i32* %5
	%14 = getelementptr inbounds [3 x i8], [3 x i8]* @.str12, i32 0, i32 0
	%15 = getelementptr inbounds [7 x i8], [7 x i8]* @.str13, i32 0, i32 0
	%16 = call i32 (i8*, ...) @printf(i8* %15, i8* %12, i32 %13, i8* %14)
	%17 = load i32, i32* %5
	%18 = load i32*, i32** %4
	%19 = getelementptr inbounds i32, i32* %18, i32 %17
	%20 = getelementptr inbounds [3 x i8], [3 x i8]* @.str14, i32 0, i32 0
	%21 = call i32 (i8*, ...) @scanf(i8* %20, i32* %19)
	%22 = load i32, i32* %5
	%23 = add i32 %22, 1
	store i32 %23, i32* %5
	br label %6
; <label>:24
	%25 = getelementptr inbounds [19 x i8], [19 x i8]* @.str15, i32 0, i32 0
	%26 = load i32, i32* %3
	%27 = getelementptr inbounds [5 x i8], [5 x i8]* @.str16, i32 0, i32 0
	%28 = getelementptr inbounds [7 x i8], [7 x i8]* @.str17, i32 0, i32 0
	%29 = call i32 (i8*, ...) @printf(i8* %28, i8* %25, i32 %26, i8* %27)
	store i32 0, i32* %5
	br label %30
; <label>:30
	%31 = load i32, i32* %3
	%32 = load i32, i32* %5
	%33 = sub i32 %31, %32
	%34 = icmp ne i32 %33, 0
	br i1 %34, label %35, label %51
; <label>:35
	%36 = load i32, i32* %5
	%37 = icmp ne i32 %36, 0
	br i1 %37, label %38, label %42
; <label>:38
	%39 = getelementptr inbounds [2 x i8], [2 x i8]* @.str18, i32 0, i32 0
	%40 = getelementptr inbounds [3 x i8], [3 x i8]* @.str19, i32 0, i32 0
	%41 = call i32 (i8*, ...) @printf(i8* %40, i8* %39)
	br label %42
; <label>:42
	%43 = load i32, i32* %5
	%44 = load i32*, i32** %4
	%45 = getelementptr inbounds i32, i32* %44, i32 %43
	%46 = load i32, i32* %45
	%47 = getelementptr inbounds [3 x i8], [3 x i8]* @.str20, i32 0, i32 0
	%48 = call i32 (i8*, ...) @printf(i8* %47, i32 %46)
	%49 = load i32, i32* %5
	%50 = add i32 %49, 1
	store i32 %50, i32* %5
	br label %30
; <label>:51
	%52 = getelementptr inbounds [3 x i8], [3 x i8]* @.str21, i32 0, i32 0
	%53 = getelementptr inbounds [3 x i8], [3 x i8]* @.str22, i32 0, i32 0
	%54 = call i32 (i8*, ...) @printf(i8* %53, i8* %52)
	ret void 
}


