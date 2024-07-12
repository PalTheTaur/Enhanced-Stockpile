# Enhanced threshold switch!!

I have had some situations where I wanted to have a somewhat self contained way to handle the angle of a mechanical bearing. Redstone contacts have to be placed on the outside to get a more accurate reading, so they can be unreliable. I saw that the bearings do store their angle inside the NBT, so I just had to mark them as observable and give it a value. 

Thats not the only change I made though, it also increases the update rate of the threshold switch when connected to a mechanical bearing, going from once every 10 ticks, to every tick, this is to allow it to pretty closeley represent the position, and not require you to lower the speed to unusable speeds to get any sort of positon. 

At about 128 rpm is where the update rate for the speed gets choppy, past that expect skipped connections for ranges under 25%


I do plan to update this to support mechanical pistons and other things. 


_This is my first mod, please understand the code in here is likely of poor quality and has mistakes, I am not experinced with this._

most of the things still say stockpile, I forgor it was renamed.
