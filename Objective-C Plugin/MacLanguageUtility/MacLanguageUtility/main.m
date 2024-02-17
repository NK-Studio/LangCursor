#import <Carbon/Carbon.h>

int main(int argc, const char * argv[]) {
    
    @autoreleasepool {
        TISInputSourceRef soruce = TISCopyCurrentKeyboardInputSource();
        CFStringRef sourceID = TISGetInputSourceProperty(soruce, kTISPropertyInputSourceID);
        printf("%s",CFStringGetCStringPtr(sourceID, kCFStringEncodingUTF8));
        CFRelease(soruce);
    }

    return 0;
}
