; text > +
; text >  = 
; text > \n
; text > -
; text >  = 
; text > \n
; text > *
; text >  = 
; text > \n
; text > /
; text >  = 
; text > \n
; text > +
; text >  = 
; text > \n
; text > * (
; text > +
; text > ) = 
; text > \n
; text > *  
; text > +
; text >   = 
; text > \n
; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins

@"+1" = global [2 x i8] c"+\00"
@" = 2" = global [4 x i8] c" = \00"
@"\n3" = global [2 x i8] c"\0A\00"
@"-4" = global [2 x i8] c"-\00"
@" = 5" = global [4 x i8] c" = \00"
@"\n6" = global [2 x i8] c"\0A\00"
@"*7" = global [2 x i8] c"*\00"
@" = 8" = global [4 x i8] c" = \00"
@"\n9" = global [2 x i8] c"\0A\00"
@"/10" = global [2 x i8] c"/\00"
@" = 11" = global [4 x i8] c" = \00"
@"\n12" = global [2 x i8] c"\0A\00"
@"+13" = global [2 x i8] c"+\00"
@" = 14" = global [4 x i8] c" = \00"
@"\n15" = global [2 x i8] c"\0A\00"
@"* (16" = global [4 x i8] c"* (\00"
@"+17" = global [2 x i8] c"+\00"
@") = 18" = global [5 x i8] c") = \00"
@"\n19" = global [2 x i8] c"\0A\00"
@"*  20" = global [4 x i8] c"*  \00"
@"+21" = global [2 x i8] c"+\00"
@"  = 22" = global [5 x i8] c"  = \00"
@"\n23" = global [2 x i8] c"\0A\00"


define void @main() {
	%tmp1 = add i32 5, 7
	call i32 (i8*, ...) @printf(i32 5i8 +i32 7i8  = i32 %tmp1i8 \n)
	%tmp2 = sub i32 5, 7
	call i32 (i8*, ...) @printf(i32 5i8 -i32 7i8  = i32 %tmp2i8 \n)
	%tmp3 = mul i32 5, 7
	call i32 (i8*, ...) @printf(i32 5i8 *i32 7i8  = i32 %tmp3i8 \n)
	%tmp4 = udiv i32 5, 7
	call i32 (i8*, ...) @printf(i32 5i8 /i32 7i8  = i32 %tmp4i8 \n)
	%tmp5 = add i32 5, 1
	call i32 (i8*, ...) @printf(i32 5i8 +i32 1i8  = i32 %tmp5i8 \n)
	%tmp6 = add i32 5, 7
	%tmp7 = mul i32 5, %tmp6
	call i32 (i8*, ...) @printf(i32 5i8 * (i32 5i8 +i32 7i8 ) = i32 %tmp7i8 \n)
	%tmp8 = mul i32 5, 5
	%tmp9 = add i32 %tmp8, 7
	call i32 (i8*, ...) @printf(i32 5i8 *  i32 5i8 +i32 7i8   = i32 %tmp9i8 \n)
	ret void 
}


