; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [2 x i8]c"+\00", align 1
@.str2 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str3 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str24 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str4 = private unnamed_addr constant [2 x i8]c"-\00", align 1
@.str5 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str6 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str25 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str7 = private unnamed_addr constant [2 x i8]c"*\00", align 1
@.str8 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str9 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str26 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str10 = private unnamed_addr constant [2 x i8]c"/\00", align 1
@.str11 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str12 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str27 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str13 = private unnamed_addr constant [2 x i8]c"+\00", align 1
@.str14 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str15 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str28 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str16 = private unnamed_addr constant [4 x i8]c"* (\00", align 1
@.str17 = private unnamed_addr constant [2 x i8]c"+\00", align 1
@.str18 = private unnamed_addr constant [5 x i8]c") = \00", align 1
@.str19 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str29 = private unnamed_addr constant [17 x i8]c"%d%s%d%s%d%s%d%s\00", align 1
@.str20 = private unnamed_addr constant [4 x i8]c"*  \00", align 1
@.str21 = private unnamed_addr constant [2 x i8]c"+\00", align 1
@.str22 = private unnamed_addr constant [5 x i8]c"  = \00", align 1
@.str23 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str30 = private unnamed_addr constant [17 x i8]c"%d%s%d%s%d%s%d%s\00", align 1

define void @main() {
entry:
	call void @expr(i32 1, i32 3)
	call void @expr(i32 5, i32 2)
	ret void 
}

define void @expr(i32, i32) {
entry:
	%2 = alloca i32
	%3 = alloca i32
	store i32 %0, i32* %2
	store i32 %1, i32* %3
	%4 = load i32, i32* %2
	%5 = getelementptr inbounds [2 x i8], [2 x i8]* @.str1, i32 0, i32 0
	%6 = load i32, i32* %3
	%7 = getelementptr inbounds [4 x i8], [4 x i8]* @.str2, i32 0, i32 0
	%8 = load i32, i32* %2
	%9 = load i32, i32* %3
	%10 = add i32 %8, %9
	%11 = getelementptr inbounds [2 x i8], [2 x i8]* @.str3, i32 0, i32 0
	%12 = getelementptr inbounds [13 x i8], [13 x i8]* @.str24, i32 0, i32 0
	%13 = call i32 (i8*, ...) @printf(i8* %12, i32 %4, i8* %5, i32 %6, i8* %7, i32 %10, i8* %11)
	%14 = load i32, i32* %2
	%15 = getelementptr inbounds [2 x i8], [2 x i8]* @.str4, i32 0, i32 0
	%16 = load i32, i32* %3
	%17 = getelementptr inbounds [4 x i8], [4 x i8]* @.str5, i32 0, i32 0
	%18 = load i32, i32* %2
	%19 = load i32, i32* %3
	%20 = sub i32 %18, %19
	%21 = getelementptr inbounds [2 x i8], [2 x i8]* @.str6, i32 0, i32 0
	%22 = getelementptr inbounds [13 x i8], [13 x i8]* @.str25, i32 0, i32 0
	%23 = call i32 (i8*, ...) @printf(i8* %22, i32 %14, i8* %15, i32 %16, i8* %17, i32 %20, i8* %21)
	%24 = load i32, i32* %2
	%25 = getelementptr inbounds [2 x i8], [2 x i8]* @.str7, i32 0, i32 0
	%26 = load i32, i32* %3
	%27 = getelementptr inbounds [4 x i8], [4 x i8]* @.str8, i32 0, i32 0
	%28 = load i32, i32* %2
	%29 = load i32, i32* %3
	%30 = mul i32 %28, %29
	%31 = getelementptr inbounds [2 x i8], [2 x i8]* @.str9, i32 0, i32 0
	%32 = getelementptr inbounds [13 x i8], [13 x i8]* @.str26, i32 0, i32 0
	%33 = call i32 (i8*, ...) @printf(i8* %32, i32 %24, i8* %25, i32 %26, i8* %27, i32 %30, i8* %31)
	%34 = load i32, i32* %2
	%35 = getelementptr inbounds [2 x i8], [2 x i8]* @.str10, i32 0, i32 0
	%36 = load i32, i32* %3
	%37 = getelementptr inbounds [4 x i8], [4 x i8]* @.str11, i32 0, i32 0
	%38 = load i32, i32* %2
	%39 = load i32, i32* %3
	%40 = udiv i32 %38, %39
	%41 = getelementptr inbounds [2 x i8], [2 x i8]* @.str12, i32 0, i32 0
	%42 = getelementptr inbounds [13 x i8], [13 x i8]* @.str27, i32 0, i32 0
	%43 = call i32 (i8*, ...) @printf(i8* %42, i32 %34, i8* %35, i32 %36, i8* %37, i32 %40, i8* %41)
	%44 = load i32, i32* %2
	%45 = getelementptr inbounds [2 x i8], [2 x i8]* @.str13, i32 0, i32 0
	%46 = getelementptr inbounds [4 x i8], [4 x i8]* @.str14, i32 0, i32 0
	%47 = load i32, i32* %2
	%48 = add i32 %47, 1
	%49 = getelementptr inbounds [2 x i8], [2 x i8]* @.str15, i32 0, i32 0
	%50 = getelementptr inbounds [13 x i8], [13 x i8]* @.str28, i32 0, i32 0
	%51 = call i32 (i8*, ...) @printf(i8* %50, i32 %44, i8* %45, i32 1, i8* %46, i32 %48, i8* %49)
	%52 = load i32, i32* %2
	%53 = getelementptr inbounds [4 x i8], [4 x i8]* @.str16, i32 0, i32 0
	%54 = load i32, i32* %2
	%55 = getelementptr inbounds [2 x i8], [2 x i8]* @.str17, i32 0, i32 0
	%56 = load i32, i32* %3
	%57 = getelementptr inbounds [5 x i8], [5 x i8]* @.str18, i32 0, i32 0
	%58 = load i32, i32* %2
	%59 = load i32, i32* %2
	%60 = load i32, i32* %3
	%61 = add i32 %59, %60
	%62 = mul i32 %58, %61
	%63 = getelementptr inbounds [2 x i8], [2 x i8]* @.str19, i32 0, i32 0
	%64 = getelementptr inbounds [17 x i8], [17 x i8]* @.str29, i32 0, i32 0
	%65 = call i32 (i8*, ...) @printf(i8* %64, i32 %52, i8* %53, i32 %54, i8* %55, i32 %56, i8* %57, i32 %62, i8* %63)
	%66 = load i32, i32* %2
	%67 = getelementptr inbounds [4 x i8], [4 x i8]* @.str20, i32 0, i32 0
	%68 = load i32, i32* %2
	%69 = getelementptr inbounds [2 x i8], [2 x i8]* @.str21, i32 0, i32 0
	%70 = load i32, i32* %3
	%71 = getelementptr inbounds [5 x i8], [5 x i8]* @.str22, i32 0, i32 0
	%72 = load i32, i32* %2
	%73 = load i32, i32* %2
	%74 = mul i32 %72, %73
	%75 = load i32, i32* %3
	%76 = add i32 %74, %75
	%77 = getelementptr inbounds [2 x i8], [2 x i8]* @.str23, i32 0, i32 0
	%78 = getelementptr inbounds [17 x i8], [17 x i8]* @.str30, i32 0, i32 0
	%79 = call i32 (i8*, ...) @printf(i8* %78, i32 %66, i8* %67, i32 %68, i8* %69, i32 %70, i8* %71, i32 %76, i8* %77)
	ret void 
}


