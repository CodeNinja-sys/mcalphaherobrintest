/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.StateTracker;

public final class GL11 {
    public static final int GL_ACCUM = 256;
    public static final int GL_LOAD = 257;
    public static final int GL_RETURN = 258;
    public static final int GL_MULT = 259;
    public static final int GL_ADD = 260;
    public static final int GL_NEVER = 512;
    public static final int GL_LESS = 513;
    public static final int GL_EQUAL = 514;
    public static final int GL_LEQUAL = 515;
    public static final int GL_GREATER = 516;
    public static final int GL_NOTEQUAL = 517;
    public static final int GL_GEQUAL = 518;
    public static final int GL_ALWAYS = 519;
    public static final int GL_CURRENT_BIT = 1;
    public static final int GL_POINT_BIT = 2;
    public static final int GL_LINE_BIT = 4;
    public static final int GL_POLYGON_BIT = 8;
    public static final int GL_POLYGON_STIPPLE_BIT = 16;
    public static final int GL_PIXEL_MODE_BIT = 32;
    public static final int GL_LIGHTING_BIT = 64;
    public static final int GL_FOG_BIT = 128;
    public static final int GL_DEPTH_BUFFER_BIT = 256;
    public static final int GL_ACCUM_BUFFER_BIT = 512;
    public static final int GL_STENCIL_BUFFER_BIT = 1024;
    public static final int GL_VIEWPORT_BIT = 2048;
    public static final int GL_TRANSFORM_BIT = 4096;
    public static final int GL_ENABLE_BIT = 8192;
    public static final int GL_COLOR_BUFFER_BIT = 16384;
    public static final int GL_HINT_BIT = 32768;
    public static final int GL_EVAL_BIT = 65536;
    public static final int GL_LIST_BIT = 131072;
    public static final int GL_TEXTURE_BIT = 262144;
    public static final int GL_SCISSOR_BIT = 524288;
    public static final int GL_ALL_ATTRIB_BITS = 1048575;
    public static final int GL_POINTS = 0;
    public static final int GL_LINES = 1;
    public static final int GL_LINE_LOOP = 2;
    public static final int GL_LINE_STRIP = 3;
    public static final int GL_TRIANGLES = 4;
    public static final int GL_TRIANGLE_STRIP = 5;
    public static final int GL_TRIANGLE_FAN = 6;
    public static final int GL_QUADS = 7;
    public static final int GL_QUAD_STRIP = 8;
    public static final int GL_POLYGON = 9;
    public static final int GL_ZERO = 0;
    public static final int GL_ONE = 1;
    public static final int GL_SRC_COLOR = 768;
    public static final int GL_ONE_MINUS_SRC_COLOR = 769;
    public static final int GL_SRC_ALPHA = 770;
    public static final int GL_ONE_MINUS_SRC_ALPHA = 771;
    public static final int GL_DST_ALPHA = 772;
    public static final int GL_ONE_MINUS_DST_ALPHA = 773;
    public static final int GL_DST_COLOR = 774;
    public static final int GL_ONE_MINUS_DST_COLOR = 775;
    public static final int GL_SRC_ALPHA_SATURATE = 776;
    public static final int GL_CONSTANT_COLOR = 32769;
    public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770;
    public static final int GL_CONSTANT_ALPHA = 32771;
    public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772;
    public static final int GL_TRUE = 1;
    public static final int GL_FALSE = 0;
    public static final int GL_CLIP_PLANE0 = 12288;
    public static final int GL_CLIP_PLANE1 = 12289;
    public static final int GL_CLIP_PLANE2 = 12290;
    public static final int GL_CLIP_PLANE3 = 12291;
    public static final int GL_CLIP_PLANE4 = 12292;
    public static final int GL_CLIP_PLANE5 = 12293;
    public static final int GL_BYTE = 5120;
    public static final int GL_UNSIGNED_BYTE = 5121;
    public static final int GL_SHORT = 5122;
    public static final int GL_UNSIGNED_SHORT = 5123;
    public static final int GL_INT = 5124;
    public static final int GL_UNSIGNED_INT = 5125;
    public static final int GL_FLOAT = 5126;
    public static final int GL_2_BYTES = 5127;
    public static final int GL_3_BYTES = 5128;
    public static final int GL_4_BYTES = 5129;
    public static final int GL_DOUBLE = 5130;
    public static final int GL_NONE = 0;
    public static final int GL_FRONT_LEFT = 1024;
    public static final int GL_FRONT_RIGHT = 1025;
    public static final int GL_BACK_LEFT = 1026;
    public static final int GL_BACK_RIGHT = 1027;
    public static final int GL_FRONT = 1028;
    public static final int GL_BACK = 1029;
    public static final int GL_LEFT = 1030;
    public static final int GL_RIGHT = 1031;
    public static final int GL_FRONT_AND_BACK = 1032;
    public static final int GL_AUX0 = 1033;
    public static final int GL_AUX1 = 1034;
    public static final int GL_AUX2 = 1035;
    public static final int GL_AUX3 = 1036;
    public static final int GL_NO_ERROR = 0;
    public static final int GL_INVALID_ENUM = 1280;
    public static final int GL_INVALID_VALUE = 1281;
    public static final int GL_INVALID_OPERATION = 1282;
    public static final int GL_STACK_OVERFLOW = 1283;
    public static final int GL_STACK_UNDERFLOW = 1284;
    public static final int GL_OUT_OF_MEMORY = 1285;
    public static final int GL_2D = 1536;
    public static final int GL_3D = 1537;
    public static final int GL_3D_COLOR = 1538;
    public static final int GL_3D_COLOR_TEXTURE = 1539;
    public static final int GL_4D_COLOR_TEXTURE = 1540;
    public static final int GL_PASS_THROUGH_TOKEN = 1792;
    public static final int GL_POINT_TOKEN = 1793;
    public static final int GL_LINE_TOKEN = 1794;
    public static final int GL_POLYGON_TOKEN = 1795;
    public static final int GL_BITMAP_TOKEN = 1796;
    public static final int GL_DRAW_PIXEL_TOKEN = 1797;
    public static final int GL_COPY_PIXEL_TOKEN = 1798;
    public static final int GL_LINE_RESET_TOKEN = 1799;
    public static final int GL_EXP = 2048;
    public static final int GL_EXP2 = 2049;
    public static final int GL_CW = 2304;
    public static final int GL_CCW = 2305;
    public static final int GL_COEFF = 2560;
    public static final int GL_ORDER = 2561;
    public static final int GL_DOMAIN = 2562;
    public static final int GL_CURRENT_COLOR = 2816;
    public static final int GL_CURRENT_INDEX = 2817;
    public static final int GL_CURRENT_NORMAL = 2818;
    public static final int GL_CURRENT_TEXTURE_COORDS = 2819;
    public static final int GL_CURRENT_RASTER_COLOR = 2820;
    public static final int GL_CURRENT_RASTER_INDEX = 2821;
    public static final int GL_CURRENT_RASTER_TEXTURE_COORDS = 2822;
    public static final int GL_CURRENT_RASTER_POSITION = 2823;
    public static final int GL_CURRENT_RASTER_POSITION_VALID = 2824;
    public static final int GL_CURRENT_RASTER_DISTANCE = 2825;
    public static final int GL_POINT_SMOOTH = 2832;
    public static final int GL_POINT_SIZE = 2833;
    public static final int GL_POINT_SIZE_RANGE = 2834;
    public static final int GL_POINT_SIZE_GRANULARITY = 2835;
    public static final int GL_LINE_SMOOTH = 2848;
    public static final int GL_LINE_WIDTH = 2849;
    public static final int GL_LINE_WIDTH_RANGE = 2850;
    public static final int GL_LINE_WIDTH_GRANULARITY = 2851;
    public static final int GL_LINE_STIPPLE = 2852;
    public static final int GL_LINE_STIPPLE_PATTERN = 2853;
    public static final int GL_LINE_STIPPLE_REPEAT = 2854;
    public static final int GL_LIST_MODE = 2864;
    public static final int GL_MAX_LIST_NESTING = 2865;
    public static final int GL_LIST_BASE = 2866;
    public static final int GL_LIST_INDEX = 2867;
    public static final int GL_POLYGON_MODE = 2880;
    public static final int GL_POLYGON_SMOOTH = 2881;
    public static final int GL_POLYGON_STIPPLE = 2882;
    public static final int GL_EDGE_FLAG = 2883;
    public static final int GL_CULL_FACE = 2884;
    public static final int GL_CULL_FACE_MODE = 2885;
    public static final int GL_FRONT_FACE = 2886;
    public static final int GL_LIGHTING = 2896;
    public static final int GL_LIGHT_MODEL_LOCAL_VIEWER = 2897;
    public static final int GL_LIGHT_MODEL_TWO_SIDE = 2898;
    public static final int GL_LIGHT_MODEL_AMBIENT = 2899;
    public static final int GL_SHADE_MODEL = 2900;
    public static final int GL_COLOR_MATERIAL_FACE = 2901;
    public static final int GL_COLOR_MATERIAL_PARAMETER = 2902;
    public static final int GL_COLOR_MATERIAL = 2903;
    public static final int GL_FOG = 2912;
    public static final int GL_FOG_INDEX = 2913;
    public static final int GL_FOG_DENSITY = 2914;
    public static final int GL_FOG_START = 2915;
    public static final int GL_FOG_END = 2916;
    public static final int GL_FOG_MODE = 2917;
    public static final int GL_FOG_COLOR = 2918;
    public static final int GL_DEPTH_RANGE = 2928;
    public static final int GL_DEPTH_TEST = 2929;
    public static final int GL_DEPTH_WRITEMASK = 2930;
    public static final int GL_DEPTH_CLEAR_VALUE = 2931;
    public static final int GL_DEPTH_FUNC = 2932;
    public static final int GL_ACCUM_CLEAR_VALUE = 2944;
    public static final int GL_STENCIL_TEST = 2960;
    public static final int GL_STENCIL_CLEAR_VALUE = 2961;
    public static final int GL_STENCIL_FUNC = 2962;
    public static final int GL_STENCIL_VALUE_MASK = 2963;
    public static final int GL_STENCIL_FAIL = 2964;
    public static final int GL_STENCIL_PASS_DEPTH_FAIL = 2965;
    public static final int GL_STENCIL_PASS_DEPTH_PASS = 2966;
    public static final int GL_STENCIL_REF = 2967;
    public static final int GL_STENCIL_WRITEMASK = 2968;
    public static final int GL_MATRIX_MODE = 2976;
    public static final int GL_NORMALIZE = 2977;
    public static final int GL_VIEWPORT = 2978;
    public static final int GL_MODELVIEW_STACK_DEPTH = 2979;
    public static final int GL_PROJECTION_STACK_DEPTH = 2980;
    public static final int GL_TEXTURE_STACK_DEPTH = 2981;
    public static final int GL_MODELVIEW_MATRIX = 2982;
    public static final int GL_PROJECTION_MATRIX = 2983;
    public static final int GL_TEXTURE_MATRIX = 2984;
    public static final int GL_ATTRIB_STACK_DEPTH = 2992;
    public static final int GL_CLIENT_ATTRIB_STACK_DEPTH = 2993;
    public static final int GL_ALPHA_TEST = 3008;
    public static final int GL_ALPHA_TEST_FUNC = 3009;
    public static final int GL_ALPHA_TEST_REF = 3010;
    public static final int GL_DITHER = 3024;
    public static final int GL_BLEND_DST = 3040;
    public static final int GL_BLEND_SRC = 3041;
    public static final int GL_BLEND = 3042;
    public static final int GL_LOGIC_OP_MODE = 3056;
    public static final int GL_INDEX_LOGIC_OP = 3057;
    public static final int GL_COLOR_LOGIC_OP = 3058;
    public static final int GL_AUX_BUFFERS = 3072;
    public static final int GL_DRAW_BUFFER = 3073;
    public static final int GL_READ_BUFFER = 3074;
    public static final int GL_SCISSOR_BOX = 3088;
    public static final int GL_SCISSOR_TEST = 3089;
    public static final int GL_INDEX_CLEAR_VALUE = 3104;
    public static final int GL_INDEX_WRITEMASK = 3105;
    public static final int GL_COLOR_CLEAR_VALUE = 3106;
    public static final int GL_COLOR_WRITEMASK = 3107;
    public static final int GL_INDEX_MODE = 3120;
    public static final int GL_RGBA_MODE = 3121;
    public static final int GL_DOUBLEBUFFER = 3122;
    public static final int GL_STEREO = 3123;
    public static final int GL_RENDER_MODE = 3136;
    public static final int GL_PERSPECTIVE_CORRECTION_HINT = 3152;
    public static final int GL_POINT_SMOOTH_HINT = 3153;
    public static final int GL_LINE_SMOOTH_HINT = 3154;
    public static final int GL_POLYGON_SMOOTH_HINT = 3155;
    public static final int GL_FOG_HINT = 3156;
    public static final int GL_TEXTURE_GEN_S = 3168;
    public static final int GL_TEXTURE_GEN_T = 3169;
    public static final int GL_TEXTURE_GEN_R = 3170;
    public static final int GL_TEXTURE_GEN_Q = 3171;
    public static final int GL_PIXEL_MAP_I_TO_I = 3184;
    public static final int GL_PIXEL_MAP_S_TO_S = 3185;
    public static final int GL_PIXEL_MAP_I_TO_R = 3186;
    public static final int GL_PIXEL_MAP_I_TO_G = 3187;
    public static final int GL_PIXEL_MAP_I_TO_B = 3188;
    public static final int GL_PIXEL_MAP_I_TO_A = 3189;
    public static final int GL_PIXEL_MAP_R_TO_R = 3190;
    public static final int GL_PIXEL_MAP_G_TO_G = 3191;
    public static final int GL_PIXEL_MAP_B_TO_B = 3192;
    public static final int GL_PIXEL_MAP_A_TO_A = 3193;
    public static final int GL_PIXEL_MAP_I_TO_I_SIZE = 3248;
    public static final int GL_PIXEL_MAP_S_TO_S_SIZE = 3249;
    public static final int GL_PIXEL_MAP_I_TO_R_SIZE = 3250;
    public static final int GL_PIXEL_MAP_I_TO_G_SIZE = 3251;
    public static final int GL_PIXEL_MAP_I_TO_B_SIZE = 3252;
    public static final int GL_PIXEL_MAP_I_TO_A_SIZE = 3253;
    public static final int GL_PIXEL_MAP_R_TO_R_SIZE = 3254;
    public static final int GL_PIXEL_MAP_G_TO_G_SIZE = 3255;
    public static final int GL_PIXEL_MAP_B_TO_B_SIZE = 3256;
    public static final int GL_PIXEL_MAP_A_TO_A_SIZE = 3257;
    public static final int GL_UNPACK_SWAP_BYTES = 3312;
    public static final int GL_UNPACK_LSB_FIRST = 3313;
    public static final int GL_UNPACK_ROW_LENGTH = 3314;
    public static final int GL_UNPACK_SKIP_ROWS = 3315;
    public static final int GL_UNPACK_SKIP_PIXELS = 3316;
    public static final int GL_UNPACK_ALIGNMENT = 3317;
    public static final int GL_PACK_SWAP_BYTES = 3328;
    public static final int GL_PACK_LSB_FIRST = 3329;
    public static final int GL_PACK_ROW_LENGTH = 3330;
    public static final int GL_PACK_SKIP_ROWS = 3331;
    public static final int GL_PACK_SKIP_PIXELS = 3332;
    public static final int GL_PACK_ALIGNMENT = 3333;
    public static final int GL_MAP_COLOR = 3344;
    public static final int GL_MAP_STENCIL = 3345;
    public static final int GL_INDEX_SHIFT = 3346;
    public static final int GL_INDEX_OFFSET = 3347;
    public static final int GL_RED_SCALE = 3348;
    public static final int GL_RED_BIAS = 3349;
    public static final int GL_ZOOM_X = 3350;
    public static final int GL_ZOOM_Y = 3351;
    public static final int GL_GREEN_SCALE = 3352;
    public static final int GL_GREEN_BIAS = 3353;
    public static final int GL_BLUE_SCALE = 3354;
    public static final int GL_BLUE_BIAS = 3355;
    public static final int GL_ALPHA_SCALE = 3356;
    public static final int GL_ALPHA_BIAS = 3357;
    public static final int GL_DEPTH_SCALE = 3358;
    public static final int GL_DEPTH_BIAS = 3359;
    public static final int GL_MAX_EVAL_ORDER = 3376;
    public static final int GL_MAX_LIGHTS = 3377;
    public static final int GL_MAX_CLIP_PLANES = 3378;
    public static final int GL_MAX_TEXTURE_SIZE = 3379;
    public static final int GL_MAX_PIXEL_MAP_TABLE = 3380;
    public static final int GL_MAX_ATTRIB_STACK_DEPTH = 3381;
    public static final int GL_MAX_MODELVIEW_STACK_DEPTH = 3382;
    public static final int GL_MAX_NAME_STACK_DEPTH = 3383;
    public static final int GL_MAX_PROJECTION_STACK_DEPTH = 3384;
    public static final int GL_MAX_TEXTURE_STACK_DEPTH = 3385;
    public static final int GL_MAX_VIEWPORT_DIMS = 3386;
    public static final int GL_MAX_CLIENT_ATTRIB_STACK_DEPTH = 3387;
    public static final int GL_SUBPIXEL_BITS = 3408;
    public static final int GL_INDEX_BITS = 3409;
    public static final int GL_RED_BITS = 3410;
    public static final int GL_GREEN_BITS = 3411;
    public static final int GL_BLUE_BITS = 3412;
    public static final int GL_ALPHA_BITS = 3413;
    public static final int GL_DEPTH_BITS = 3414;
    public static final int GL_STENCIL_BITS = 3415;
    public static final int GL_ACCUM_RED_BITS = 3416;
    public static final int GL_ACCUM_GREEN_BITS = 3417;
    public static final int GL_ACCUM_BLUE_BITS = 3418;
    public static final int GL_ACCUM_ALPHA_BITS = 3419;
    public static final int GL_NAME_STACK_DEPTH = 3440;
    public static final int GL_AUTO_NORMAL = 3456;
    public static final int GL_MAP1_COLOR_4 = 3472;
    public static final int GL_MAP1_INDEX = 3473;
    public static final int GL_MAP1_NORMAL = 3474;
    public static final int GL_MAP1_TEXTURE_COORD_1 = 3475;
    public static final int GL_MAP1_TEXTURE_COORD_2 = 3476;
    public static final int GL_MAP1_TEXTURE_COORD_3 = 3477;
    public static final int GL_MAP1_TEXTURE_COORD_4 = 3478;
    public static final int GL_MAP1_VERTEX_3 = 3479;
    public static final int GL_MAP1_VERTEX_4 = 3480;
    public static final int GL_MAP2_COLOR_4 = 3504;
    public static final int GL_MAP2_INDEX = 3505;
    public static final int GL_MAP2_NORMAL = 3506;
    public static final int GL_MAP2_TEXTURE_COORD_1 = 3507;
    public static final int GL_MAP2_TEXTURE_COORD_2 = 3508;
    public static final int GL_MAP2_TEXTURE_COORD_3 = 3509;
    public static final int GL_MAP2_TEXTURE_COORD_4 = 3510;
    public static final int GL_MAP2_VERTEX_3 = 3511;
    public static final int GL_MAP2_VERTEX_4 = 3512;
    public static final int GL_MAP1_GRID_DOMAIN = 3536;
    public static final int GL_MAP1_GRID_SEGMENTS = 3537;
    public static final int GL_MAP2_GRID_DOMAIN = 3538;
    public static final int GL_MAP2_GRID_SEGMENTS = 3539;
    public static final int GL_TEXTURE_1D = 3552;
    public static final int GL_TEXTURE_2D = 3553;
    public static final int GL_FEEDBACK_BUFFER_POINTER = 3568;
    public static final int GL_FEEDBACK_BUFFER_SIZE = 3569;
    public static final int GL_FEEDBACK_BUFFER_TYPE = 3570;
    public static final int GL_SELECTION_BUFFER_POINTER = 3571;
    public static final int GL_SELECTION_BUFFER_SIZE = 3572;
    public static final int GL_TEXTURE_WIDTH = 4096;
    public static final int GL_TEXTURE_HEIGHT = 4097;
    public static final int GL_TEXTURE_INTERNAL_FORMAT = 4099;
    public static final int GL_TEXTURE_BORDER_COLOR = 4100;
    public static final int GL_TEXTURE_BORDER = 4101;
    public static final int GL_DONT_CARE = 4352;
    public static final int GL_FASTEST = 4353;
    public static final int GL_NICEST = 4354;
    public static final int GL_LIGHT0 = 16384;
    public static final int GL_LIGHT1 = 16385;
    public static final int GL_LIGHT2 = 16386;
    public static final int GL_LIGHT3 = 16387;
    public static final int GL_LIGHT4 = 16388;
    public static final int GL_LIGHT5 = 16389;
    public static final int GL_LIGHT6 = 16390;
    public static final int GL_LIGHT7 = 16391;
    public static final int GL_AMBIENT = 4608;
    public static final int GL_DIFFUSE = 4609;
    public static final int GL_SPECULAR = 4610;
    public static final int GL_POSITION = 4611;
    public static final int GL_SPOT_DIRECTION = 4612;
    public static final int GL_SPOT_EXPONENT = 4613;
    public static final int GL_SPOT_CUTOFF = 4614;
    public static final int GL_CONSTANT_ATTENUATION = 4615;
    public static final int GL_LINEAR_ATTENUATION = 4616;
    public static final int GL_QUADRATIC_ATTENUATION = 4617;
    public static final int GL_COMPILE = 4864;
    public static final int GL_COMPILE_AND_EXECUTE = 4865;
    public static final int GL_CLEAR = 5376;
    public static final int GL_AND = 5377;
    public static final int GL_AND_REVERSE = 5378;
    public static final int GL_COPY = 5379;
    public static final int GL_AND_INVERTED = 5380;
    public static final int GL_NOOP = 5381;
    public static final int GL_XOR = 5382;
    public static final int GL_OR = 5383;
    public static final int GL_NOR = 5384;
    public static final int GL_EQUIV = 5385;
    public static final int GL_INVERT = 5386;
    public static final int GL_OR_REVERSE = 5387;
    public static final int GL_COPY_INVERTED = 5388;
    public static final int GL_OR_INVERTED = 5389;
    public static final int GL_NAND = 5390;
    public static final int GL_SET = 5391;
    public static final int GL_EMISSION = 5632;
    public static final int GL_SHININESS = 5633;
    public static final int GL_AMBIENT_AND_DIFFUSE = 5634;
    public static final int GL_COLOR_INDEXES = 5635;
    public static final int GL_MODELVIEW = 5888;
    public static final int GL_PROJECTION = 5889;
    public static final int GL_TEXTURE = 5890;
    public static final int GL_COLOR = 6144;
    public static final int GL_DEPTH = 6145;
    public static final int GL_STENCIL = 6146;
    public static final int GL_COLOR_INDEX = 6400;
    public static final int GL_STENCIL_INDEX = 6401;
    public static final int GL_DEPTH_COMPONENT = 6402;
    public static final int GL_RED = 6403;
    public static final int GL_GREEN = 6404;
    public static final int GL_BLUE = 6405;
    public static final int GL_ALPHA = 6406;
    public static final int GL_RGB = 6407;
    public static final int GL_RGBA = 6408;
    public static final int GL_LUMINANCE = 6409;
    public static final int GL_LUMINANCE_ALPHA = 6410;
    public static final int GL_BITMAP = 6656;
    public static final int GL_POINT = 6912;
    public static final int GL_LINE = 6913;
    public static final int GL_FILL = 6914;
    public static final int GL_RENDER = 7168;
    public static final int GL_FEEDBACK = 7169;
    public static final int GL_SELECT = 7170;
    public static final int GL_FLAT = 7424;
    public static final int GL_SMOOTH = 7425;
    public static final int GL_KEEP = 7680;
    public static final int GL_REPLACE = 7681;
    public static final int GL_INCR = 7682;
    public static final int GL_DECR = 7683;
    public static final int GL_VENDOR = 7936;
    public static final int GL_RENDERER = 7937;
    public static final int GL_VERSION = 7938;
    public static final int GL_EXTENSIONS = 7939;
    public static final int GL_S = 8192;
    public static final int GL_T = 8193;
    public static final int GL_R = 8194;
    public static final int GL_Q = 8195;
    public static final int GL_MODULATE = 8448;
    public static final int GL_DECAL = 8449;
    public static final int GL_TEXTURE_ENV_MODE = 8704;
    public static final int GL_TEXTURE_ENV_COLOR = 8705;
    public static final int GL_TEXTURE_ENV = 8960;
    public static final int GL_EYE_LINEAR = 9216;
    public static final int GL_OBJECT_LINEAR = 9217;
    public static final int GL_SPHERE_MAP = 9218;
    public static final int GL_TEXTURE_GEN_MODE = 9472;
    public static final int GL_OBJECT_PLANE = 9473;
    public static final int GL_EYE_PLANE = 9474;
    public static final int GL_NEAREST = 9728;
    public static final int GL_LINEAR = 9729;
    public static final int GL_NEAREST_MIPMAP_NEAREST = 9984;
    public static final int GL_LINEAR_MIPMAP_NEAREST = 9985;
    public static final int GL_NEAREST_MIPMAP_LINEAR = 9986;
    public static final int GL_LINEAR_MIPMAP_LINEAR = 9987;
    public static final int GL_TEXTURE_MAG_FILTER = 10240;
    public static final int GL_TEXTURE_MIN_FILTER = 10241;
    public static final int GL_TEXTURE_WRAP_S = 10242;
    public static final int GL_TEXTURE_WRAP_T = 10243;
    public static final int GL_CLAMP = 10496;
    public static final int GL_REPEAT = 10497;
    public static final int GL_CLIENT_PIXEL_STORE_BIT = 1;
    public static final int GL_CLIENT_VERTEX_ARRAY_BIT = 2;
    public static final int GL_ALL_CLIENT_ATTRIB_BITS = -1;
    public static final int GL_POLYGON_OFFSET_FACTOR = 32824;
    public static final int GL_POLYGON_OFFSET_UNITS = 10752;
    public static final int GL_POLYGON_OFFSET_POINT = 10753;
    public static final int GL_POLYGON_OFFSET_LINE = 10754;
    public static final int GL_POLYGON_OFFSET_FILL = 32823;
    public static final int GL_ALPHA4 = 32827;
    public static final int GL_ALPHA8 = 32828;
    public static final int GL_ALPHA12 = 32829;
    public static final int GL_ALPHA16 = 32830;
    public static final int GL_LUMINANCE4 = 32831;
    public static final int GL_LUMINANCE8 = 32832;
    public static final int GL_LUMINANCE12 = 32833;
    public static final int GL_LUMINANCE16 = 32834;
    public static final int GL_LUMINANCE4_ALPHA4 = 32835;
    public static final int GL_LUMINANCE6_ALPHA2 = 32836;
    public static final int GL_LUMINANCE8_ALPHA8 = 32837;
    public static final int GL_LUMINANCE12_ALPHA4 = 32838;
    public static final int GL_LUMINANCE12_ALPHA12 = 32839;
    public static final int GL_LUMINANCE16_ALPHA16 = 32840;
    public static final int GL_INTENSITY = 32841;
    public static final int GL_INTENSITY4 = 32842;
    public static final int GL_INTENSITY8 = 32843;
    public static final int GL_INTENSITY12 = 32844;
    public static final int GL_INTENSITY16 = 32845;
    public static final int GL_R3_G3_B2 = 10768;
    public static final int GL_RGB4 = 32847;
    public static final int GL_RGB5 = 32848;
    public static final int GL_RGB8 = 32849;
    public static final int GL_RGB10 = 32850;
    public static final int GL_RGB12 = 32851;
    public static final int GL_RGB16 = 32852;
    public static final int GL_RGBA2 = 32853;
    public static final int GL_RGBA4 = 32854;
    public static final int GL_RGB5_A1 = 32855;
    public static final int GL_RGBA8 = 32856;
    public static final int GL_RGB10_A2 = 32857;
    public static final int GL_RGBA12 = 32858;
    public static final int GL_RGBA16 = 32859;
    public static final int GL_TEXTURE_RED_SIZE = 32860;
    public static final int GL_TEXTURE_GREEN_SIZE = 32861;
    public static final int GL_TEXTURE_BLUE_SIZE = 32862;
    public static final int GL_TEXTURE_ALPHA_SIZE = 32863;
    public static final int GL_TEXTURE_LUMINANCE_SIZE = 32864;
    public static final int GL_TEXTURE_INTENSITY_SIZE = 32865;
    public static final int GL_PROXY_TEXTURE_1D = 32867;
    public static final int GL_PROXY_TEXTURE_2D = 32868;
    public static final int GL_TEXTURE_PRIORITY = 32870;
    public static final int GL_TEXTURE_RESIDENT = 32871;
    public static final int GL_TEXTURE_BINDING_1D = 32872;
    public static final int GL_TEXTURE_BINDING_2D = 32873;
    public static final int GL_VERTEX_ARRAY = 32884;
    public static final int GL_NORMAL_ARRAY = 32885;
    public static final int GL_COLOR_ARRAY = 32886;
    public static final int GL_INDEX_ARRAY = 32887;
    public static final int GL_TEXTURE_COORD_ARRAY = 32888;
    public static final int GL_EDGE_FLAG_ARRAY = 32889;
    public static final int GL_VERTEX_ARRAY_SIZE = 32890;
    public static final int GL_VERTEX_ARRAY_TYPE = 32891;
    public static final int GL_VERTEX_ARRAY_STRIDE = 32892;
    public static final int GL_NORMAL_ARRAY_TYPE = 32894;
    public static final int GL_NORMAL_ARRAY_STRIDE = 32895;
    public static final int GL_COLOR_ARRAY_SIZE = 32897;
    public static final int GL_COLOR_ARRAY_TYPE = 32898;
    public static final int GL_COLOR_ARRAY_STRIDE = 32899;
    public static final int GL_INDEX_ARRAY_TYPE = 32901;
    public static final int GL_INDEX_ARRAY_STRIDE = 32902;
    public static final int GL_TEXTURE_COORD_ARRAY_SIZE = 32904;
    public static final int GL_TEXTURE_COORD_ARRAY_TYPE = 32905;
    public static final int GL_TEXTURE_COORD_ARRAY_STRIDE = 32906;
    public static final int GL_EDGE_FLAG_ARRAY_STRIDE = 32908;
    public static final int GL_VERTEX_ARRAY_POINTER = 32910;
    public static final int GL_NORMAL_ARRAY_POINTER = 32911;
    public static final int GL_COLOR_ARRAY_POINTER = 32912;
    public static final int GL_INDEX_ARRAY_POINTER = 32913;
    public static final int GL_TEXTURE_COORD_ARRAY_POINTER = 32914;
    public static final int GL_EDGE_FLAG_ARRAY_POINTER = 32915;
    public static final int GL_V2F = 10784;
    public static final int GL_V3F = 10785;
    public static final int GL_C4UB_V2F = 10786;
    public static final int GL_C4UB_V3F = 10787;
    public static final int GL_C3F_V3F = 10788;
    public static final int GL_N3F_V3F = 10789;
    public static final int GL_C4F_N3F_V3F = 10790;
    public static final int GL_T2F_V3F = 10791;
    public static final int GL_T4F_V4F = 10792;
    public static final int GL_T2F_C4UB_V3F = 10793;
    public static final int GL_T2F_C3F_V3F = 10794;
    public static final int GL_T2F_N3F_V3F = 10795;
    public static final int GL_T2F_C4F_N3F_V3F = 10796;
    public static final int GL_T4F_C4F_N3F_V4F = 10797;
    public static final int GL_LOGIC_OP = 3057;
    public static final int GL_TEXTURE_COMPONENTS = 4099;

    private GL11() {
    }

    public static void glAccum(int op2, float value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glAccum_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglAccum(op2, value, function_pointer);
    }

    private static native void nglAccum(int var0, float var1, long var2);

    public static void glAlphaFunc(int func, float ref) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glAlphaFunc_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglAlphaFunc(func, ref, function_pointer);
    }

    private static native void nglAlphaFunc(int var0, float var1, long var2);

    public static void glClearColor(float red, float green, float blue, float alpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glClearColor_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglClearColor(red, green, blue, alpha, function_pointer);
    }

    private static native void nglClearColor(float var0, float var1, float var2, float var3, long var4);

    public static void glClearAccum(float red, float green, float blue, float alpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glClearAccum_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglClearAccum(red, green, blue, alpha, function_pointer);
    }

    private static native void nglClearAccum(float var0, float var1, float var2, float var3, long var4);

    public static void glClear(int mask) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glClear_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglClear(mask, function_pointer);
    }

    private static native void nglClear(int var0, long var1);

    public static void glCallLists(ByteBuffer lists) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glCallLists_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(lists);
        GL11.nglCallLists(lists.remaining(), 5121, lists, lists.position(), function_pointer);
    }

    public static void glCallLists(IntBuffer lists) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glCallLists_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(lists);
        GL11.nglCallLists(lists.remaining(), 5125, lists, lists.position() << 2, function_pointer);
    }

    public static void glCallLists(ShortBuffer lists) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glCallLists_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(lists);
        GL11.nglCallLists(lists.remaining(), 5123, lists, lists.position() << 1, function_pointer);
    }

    private static native void nglCallLists(int var0, int var1, Buffer var2, int var3, long var4);

    public static void glCallList(int list) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glCallList_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglCallList(list, function_pointer);
    }

    private static native void nglCallList(int var0, long var1);

    public static void glBlendFunc(int sfactor, int dfactor) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glBlendFunc_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglBlendFunc(sfactor, dfactor, function_pointer);
    }

    private static native void nglBlendFunc(int var0, int var1, long var2);

    public static void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, ByteBuffer bitmap) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glBitmap_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(bitmap, (width + 7) / 8 * height);
        GL11.nglBitmap(width, height, xorig, yorig, xmove, ymove, bitmap, bitmap.position(), function_pointer);
    }

    private static native void nglBitmap(int var0, int var1, float var2, float var3, float var4, float var5, ByteBuffer var6, int var7, long var8);

    public static void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, long bitmap_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glBitmap_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOenabled(caps);
        GL11.nglBitmapBO(width, height, xorig, yorig, xmove, ymove, bitmap_buffer_offset, function_pointer);
    }

    private static native void nglBitmapBO(int var0, int var1, float var2, float var3, float var4, float var5, long var6, long var8);

    public static void glBindTexture(int target, int texture) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glBindTexture_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglBindTexture(target, texture, function_pointer);
    }

    private static native void nglBindTexture(int var0, int var1, long var2);

    public static void glPrioritizeTextures(IntBuffer textures, FloatBuffer priorities) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPrioritizeTextures_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(textures);
        BufferChecks.checkBuffer(priorities, textures.remaining());
        GL11.nglPrioritizeTextures(textures.remaining(), textures, textures.position(), priorities, priorities.position(), function_pointer);
    }

    private static native void nglPrioritizeTextures(int var0, IntBuffer var1, int var2, FloatBuffer var3, int var4, long var5);

    public static boolean glAreTexturesResident(IntBuffer textures, ByteBuffer residences) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glAreTexturesResident_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(textures);
        BufferChecks.checkBuffer(residences, textures.remaining());
        boolean __result = GL11.nglAreTexturesResident(textures.remaining(), textures, textures.position(), residences, residences.position(), function_pointer);
        return __result;
    }

    private static native boolean nglAreTexturesResident(int var0, IntBuffer var1, int var2, ByteBuffer var3, int var4, long var5);

    public static void glBegin(int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glBegin_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglBegin(mode, function_pointer);
    }

    private static native void nglBegin(int var0, long var1);

    public static void glEnd() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEnd_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglEnd(function_pointer);
    }

    private static native void nglEnd(long var0);

    public static void glArrayElement(int i2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glArrayElement_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglArrayElement(i2, function_pointer);
    }

    private static native void nglArrayElement(int var0, long var1);

    public static void glClearDepth(double depth) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glClearDepth_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglClearDepth(depth, function_pointer);
    }

    private static native void nglClearDepth(double var0, long var2);

    public static void glDeleteLists(int list, int range) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDeleteLists_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglDeleteLists(list, range, function_pointer);
    }

    private static native void nglDeleteLists(int var0, int var1, long var2);

    public static void glDeleteTextures(IntBuffer textures) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDeleteTextures_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(textures);
        GL11.nglDeleteTextures(textures.remaining(), textures, textures.position(), function_pointer);
    }

    private static native void nglDeleteTextures(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteTextures(int texture) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDeleteTextures_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglDeleteTextures(1, APIUtils.getBufferInt().put(0, texture), 0, function_pointer);
    }

    public static void glCullFace(int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glCullFace_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglCullFace(mode, function_pointer);
    }

    private static native void nglCullFace(int var0, long var1);

    public static void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x2, int y2, int width, int height) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glCopyTexSubImage2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglCopyTexSubImage2D(target, level, xoffset, yoffset, x2, y2, width, height, function_pointer);
    }

    private static native void nglCopyTexSubImage2D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glCopyTexSubImage1D(int target, int level, int xoffset, int x2, int y2, int width) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glCopyTexSubImage1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglCopyTexSubImage1D(target, level, xoffset, x2, y2, width, function_pointer);
    }

    private static native void nglCopyTexSubImage1D(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glCopyTexImage2D(int target, int level, int internalFormat, int x2, int y2, int width, int height, int border) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glCopyTexImage2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglCopyTexImage2D(target, level, internalFormat, x2, y2, width, height, border, function_pointer);
    }

    private static native void nglCopyTexImage2D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glCopyTexImage1D(int target, int level, int internalFormat, int x2, int y2, int width, int border) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glCopyTexImage1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglCopyTexImage1D(target, level, internalFormat, x2, y2, width, border, function_pointer);
    }

    private static native void nglCopyTexImage1D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glCopyPixels(int x2, int y2, int width, int height, int type) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glCopyPixels_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglCopyPixels(x2, y2, width, height, type, function_pointer);
    }

    private static native void nglCopyPixels(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glColorPointer(int size, int stride, DoubleBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glColorPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).GL11_glColorPointer_pointer = pointer;
        GL11.nglColorPointer(size, 5130, stride, pointer, pointer.position() << 3, function_pointer);
    }

    public static void glColorPointer(int size, int stride, FloatBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glColorPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).GL11_glColorPointer_pointer = pointer;
        GL11.nglColorPointer(size, 5126, stride, pointer, pointer.position() << 2, function_pointer);
    }

    public static void glColorPointer(int size, boolean unsigned, int stride, ByteBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glColorPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).GL11_glColorPointer_pointer = pointer;
        GL11.nglColorPointer(size, unsigned ? 5121 : 5120, stride, pointer, pointer.position(), function_pointer);
    }

    private static native void nglColorPointer(int var0, int var1, int var2, Buffer var3, int var4, long var5);

    public static void glColorPointer(int size, int type, int stride, long pointer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glColorPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        GL11.nglColorPointerBO(size, type, stride, pointer_buffer_offset, function_pointer);
    }

    private static native void nglColorPointerBO(int var0, int var1, int var2, long var3, long var5);

    public static void glColorMaterial(int face, int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glColorMaterial_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglColorMaterial(face, mode, function_pointer);
    }

    private static native void nglColorMaterial(int var0, int var1, long var2);

    public static void glColorMask(boolean red, boolean green, boolean blue, boolean alpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glColorMask_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglColorMask(red, green, blue, alpha, function_pointer);
    }

    private static native void nglColorMask(boolean var0, boolean var1, boolean var2, boolean var3, long var4);

    public static void glColor3b(byte red, byte green, byte blue) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glColor3b_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglColor3b(red, green, blue, function_pointer);
    }

    private static native void nglColor3b(byte var0, byte var1, byte var2, long var3);

    public static void glColor3f(float red, float green, float blue) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glColor3f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglColor3f(red, green, blue, function_pointer);
    }

    private static native void nglColor3f(float var0, float var1, float var2, long var3);

    public static void glColor3d(double red, double green, double blue) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glColor3d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglColor3d(red, green, blue, function_pointer);
    }

    private static native void nglColor3d(double var0, double var2, double var4, long var6);

    public static void glColor3ub(byte red, byte green, byte blue) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glColor3ub_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglColor3ub(red, green, blue, function_pointer);
    }

    private static native void nglColor3ub(byte var0, byte var1, byte var2, long var3);

    public static void glColor4b(byte red, byte green, byte blue, byte alpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glColor4b_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglColor4b(red, green, blue, alpha, function_pointer);
    }

    private static native void nglColor4b(byte var0, byte var1, byte var2, byte var3, long var4);

    public static void glColor4f(float red, float green, float blue, float alpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glColor4f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglColor4f(red, green, blue, alpha, function_pointer);
    }

    private static native void nglColor4f(float var0, float var1, float var2, float var3, long var4);

    public static void glColor4d(double red, double green, double blue, double alpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glColor4d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglColor4d(red, green, blue, alpha, function_pointer);
    }

    private static native void nglColor4d(double var0, double var2, double var4, double var6, long var8);

    public static void glColor4ub(byte red, byte green, byte blue, byte alpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glColor4ub_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglColor4ub(red, green, blue, alpha, function_pointer);
    }

    private static native void nglColor4ub(byte var0, byte var1, byte var2, byte var3, long var4);

    public static void glClipPlane(int plane, DoubleBuffer equation) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glClipPlane_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(equation, 4);
        GL11.nglClipPlane(plane, equation, equation.position(), function_pointer);
    }

    private static native void nglClipPlane(int var0, DoubleBuffer var1, int var2, long var3);

    public static void glClearStencil(int s2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glClearStencil_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglClearStencil(s2, function_pointer);
    }

    private static native void nglClearStencil(int var0, long var1);

    public static void glEvalPoint1(int i2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEvalPoint1_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglEvalPoint1(i2, function_pointer);
    }

    private static native void nglEvalPoint1(int var0, long var1);

    public static void glEvalPoint2(int i2, int j2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEvalPoint2_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglEvalPoint2(i2, j2, function_pointer);
    }

    private static native void nglEvalPoint2(int var0, int var1, long var2);

    public static void glEvalMesh1(int mode, int i1, int i2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEvalMesh1_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglEvalMesh1(mode, i1, i2, function_pointer);
    }

    private static native void nglEvalMesh1(int var0, int var1, int var2, long var3);

    public static void glEvalMesh2(int mode, int i1, int i2, int j1, int j2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEvalMesh2_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglEvalMesh2(mode, i1, i2, j1, j2, function_pointer);
    }

    private static native void nglEvalMesh2(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glEvalCoord1f(float u2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEvalCoord1f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglEvalCoord1f(u2, function_pointer);
    }

    private static native void nglEvalCoord1f(float var0, long var1);

    public static void glEvalCoord1d(double u2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEvalCoord1d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglEvalCoord1d(u2, function_pointer);
    }

    private static native void nglEvalCoord1d(double var0, long var2);

    public static void glEvalCoord2f(float u2, float v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEvalCoord2f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglEvalCoord2f(u2, v2, function_pointer);
    }

    private static native void nglEvalCoord2f(float var0, float var1, long var2);

    public static void glEvalCoord2d(double u2, double v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEvalCoord2d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglEvalCoord2d(u2, v2, function_pointer);
    }

    private static native void nglEvalCoord2d(double var0, double var2, long var4);

    public static void glEnableClientState(int cap) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEnableClientState_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglEnableClientState(cap, function_pointer);
    }

    private static native void nglEnableClientState(int var0, long var1);

    public static void glDisableClientState(int cap) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDisableClientState_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglDisableClientState(cap, function_pointer);
    }

    private static native void nglDisableClientState(int var0, long var1);

    public static void glEnable(int cap) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEnable_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglEnable(cap, function_pointer);
    }

    private static native void nglEnable(int var0, long var1);

    public static void glDisable(int cap) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDisable_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglDisable(cap, function_pointer);
    }

    private static native void nglDisable(int var0, long var1);

    public static void glEdgeFlagPointer(int stride, ByteBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEdgeFlagPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).GL11_glEdgeFlagPointer_pointer = pointer;
        GL11.nglEdgeFlagPointer(stride, pointer, pointer.position(), function_pointer);
    }

    private static native void nglEdgeFlagPointer(int var0, Buffer var1, int var2, long var3);

    public static void glEdgeFlagPointer(int stride, long pointer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEdgeFlagPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        GL11.nglEdgeFlagPointerBO(stride, pointer_buffer_offset, function_pointer);
    }

    private static native void nglEdgeFlagPointerBO(int var0, long var1, long var3);

    public static void glEdgeFlag(boolean flag) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEdgeFlag_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglEdgeFlag(flag, function_pointer);
    }

    private static native void nglEdgeFlag(boolean var0, long var1);

    public static void glDrawPixels(int width, int height, int format, int type, ByteBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDrawPixels_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, height, 1));
        GL11.nglDrawPixels(width, height, format, type, pixels, pixels.position(), function_pointer);
    }

    public static void glDrawPixels(int width, int height, int format, int type, IntBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDrawPixels_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, height, 1));
        GL11.nglDrawPixels(width, height, format, type, pixels, pixels.position() << 2, function_pointer);
    }

    public static void glDrawPixels(int width, int height, int format, int type, ShortBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDrawPixels_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, height, 1));
        GL11.nglDrawPixels(width, height, format, type, pixels, pixels.position() << 1, function_pointer);
    }

    private static native void nglDrawPixels(int var0, int var1, int var2, int var3, Buffer var4, int var5, long var6);

    public static void glDrawPixels(int width, int height, int format, int type, long pixels_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDrawPixels_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOenabled(caps);
        GL11.nglDrawPixelsBO(width, height, format, type, pixels_buffer_offset, function_pointer);
    }

    private static native void nglDrawPixelsBO(int var0, int var1, int var2, int var3, long var4, long var6);

    public static void glDrawElements(int mode, ByteBuffer indices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDrawElements_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        GL11.nglDrawElements(mode, indices.remaining(), 5121, indices, indices.position(), function_pointer);
    }

    public static void glDrawElements(int mode, IntBuffer indices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDrawElements_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        GL11.nglDrawElements(mode, indices.remaining(), 5125, indices, indices.position() << 2, function_pointer);
    }

    public static void glDrawElements(int mode, ShortBuffer indices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDrawElements_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        GL11.nglDrawElements(mode, indices.remaining(), 5123, indices, indices.position() << 1, function_pointer);
    }

    private static native void nglDrawElements(int var0, int var1, int var2, Buffer var3, int var4, long var5);

    public static void glDrawElements(int mode, int count, int type, long indices_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDrawElements_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOenabled(caps);
        GL11.nglDrawElementsBO(mode, count, type, indices_buffer_offset, function_pointer);
    }

    private static native void nglDrawElementsBO(int var0, int var1, int var2, long var3, long var5);

    public static void glDrawBuffer(int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDrawBuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglDrawBuffer(mode, function_pointer);
    }

    private static native void nglDrawBuffer(int var0, long var1);

    public static void glDrawArrays(int mode, int first, int count) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDrawArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglDrawArrays(mode, first, count, function_pointer);
    }

    private static native void nglDrawArrays(int var0, int var1, int var2, long var3);

    public static void glDepthRange(double zNear, double zFar) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDepthRange_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglDepthRange(zNear, zFar, function_pointer);
    }

    private static native void nglDepthRange(double var0, double var2, long var4);

    public static void glDepthMask(boolean flag) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDepthMask_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglDepthMask(flag, function_pointer);
    }

    private static native void nglDepthMask(boolean var0, long var1);

    public static void glDepthFunc(int func) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glDepthFunc_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglDepthFunc(func, function_pointer);
    }

    private static native void nglDepthFunc(int var0, long var1);

    public static void glFeedbackBuffer(int type, FloatBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glFeedbackBuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(buffer);
        GL11.nglFeedbackBuffer(buffer.remaining(), type, buffer, buffer.position(), function_pointer);
    }

    private static native void nglFeedbackBuffer(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glGetPixelMap(int map, FloatBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetPixelMapfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOdisabled(caps);
        BufferChecks.checkBuffer(values, 256);
        GL11.nglGetPixelMapfv(map, values, values.position(), function_pointer);
    }

    private static native void nglGetPixelMapfv(int var0, FloatBuffer var1, int var2, long var3);

    public static void glGetPixelMapfv(int map, long values_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetPixelMapfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOenabled(caps);
        GL11.nglGetPixelMapfvBO(map, values_buffer_offset, function_pointer);
    }

    private static native void nglGetPixelMapfvBO(int var0, long var1, long var3);

    public static void glGetPixelMapu(int map, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetPixelMapuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOdisabled(caps);
        BufferChecks.checkBuffer(values, 256);
        GL11.nglGetPixelMapuiv(map, values, values.position(), function_pointer);
    }

    private static native void nglGetPixelMapuiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glGetPixelMapuiv(int map, long values_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetPixelMapuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOenabled(caps);
        GL11.nglGetPixelMapuivBO(map, values_buffer_offset, function_pointer);
    }

    private static native void nglGetPixelMapuivBO(int var0, long var1, long var3);

    public static void glGetPixelMapu(int map, ShortBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetPixelMapusv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOdisabled(caps);
        BufferChecks.checkBuffer(values, 256);
        GL11.nglGetPixelMapusv(map, values, values.position(), function_pointer);
    }

    private static native void nglGetPixelMapusv(int var0, ShortBuffer var1, int var2, long var3);

    public static void glGetPixelMapusv(int map, long values_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetPixelMapusv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOenabled(caps);
        GL11.nglGetPixelMapusvBO(map, values_buffer_offset, function_pointer);
    }

    private static native void nglGetPixelMapusvBO(int var0, long var1, long var3);

    public static void glGetMaterial(int face, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetMaterialfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglGetMaterialfv(face, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetMaterialfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glGetMaterial(int face, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetMaterialiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglGetMaterialiv(face, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetMaterialiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetMap(int target, int query, FloatBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetMapfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 256);
        GL11.nglGetMapfv(target, query, v2, v2.position(), function_pointer);
    }

    private static native void nglGetMapfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glGetMap(int target, int query, DoubleBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetMapdv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 256);
        GL11.nglGetMapdv(target, query, v2, v2.position(), function_pointer);
    }

    private static native void nglGetMapdv(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glGetMap(int target, int query, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetMapiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 256);
        GL11.nglGetMapiv(target, query, v2, v2.position(), function_pointer);
    }

    private static native void nglGetMapiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetLight(int light, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetLightfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglGetLightfv(light, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetLightfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glGetLight(int light, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetLightiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglGetLightiv(light, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetLightiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetError() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetError_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = GL11.nglGetError(function_pointer);
        return __result;
    }

    private static native int nglGetError(long var0);

    public static void glGetClipPlane(int plane, DoubleBuffer equation) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetClipPlane_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(equation, 4);
        GL11.nglGetClipPlane(plane, equation, equation.position(), function_pointer);
    }

    private static native void nglGetClipPlane(int var0, DoubleBuffer var1, int var2, long var3);

    public static void glGetBoolean(int pname, ByteBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetBooleanv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 16);
        GL11.nglGetBooleanv(pname, params, params.position(), function_pointer);
    }

    private static native void nglGetBooleanv(int var0, ByteBuffer var1, int var2, long var3);

    public static boolean glGetBoolean(int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetBooleanv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ByteBuffer params = APIUtils.getBufferByte(1);
        GL11.nglGetBooleanv(pname, params, params.position(), function_pointer);
        return params.get(0) == 1;
    }

    public static void glGetDouble(int pname, DoubleBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetDoublev_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 16);
        GL11.nglGetDoublev(pname, params, params.position(), function_pointer);
    }

    private static native void nglGetDoublev(int var0, DoubleBuffer var1, int var2, long var3);

    public static double glGetDouble(int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetDoublev_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        DoubleBuffer params = APIUtils.getBufferDouble();
        GL11.nglGetDoublev(pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetFloat(int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetFloatv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 16);
        GL11.nglGetFloatv(pname, params, params.position(), function_pointer);
    }

    private static native void nglGetFloatv(int var0, FloatBuffer var1, int var2, long var3);

    public static float glGetFloat(int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetFloatv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        FloatBuffer params = APIUtils.getBufferFloat();
        GL11.nglGetFloatv(pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetInteger(int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetIntegerv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 16);
        GL11.nglGetIntegerv(pname, params, params.position(), function_pointer);
    }

    private static native void nglGetIntegerv(int var0, IntBuffer var1, int var2, long var3);

    public static int glGetInteger(int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetIntegerv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL11.nglGetIntegerv(pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGenTextures(IntBuffer textures) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGenTextures_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(textures);
        GL11.nglGenTextures(textures.remaining(), textures, textures.position(), function_pointer);
    }

    private static native void nglGenTextures(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenTextures() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGenTextures_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer textures = APIUtils.getBufferInt();
        GL11.nglGenTextures(1, textures, textures.position(), function_pointer);
        return textures.get(0);
    }

    public static int glGenLists(int range) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGenLists_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = GL11.nglGenLists(range, function_pointer);
        return __result;
    }

    private static native int nglGenLists(int var0, long var1);

    public static void glFrustum(double left, double right, double bottom, double top, double zNear, double zFar) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glFrustum_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglFrustum(left, right, bottom, top, zNear, zFar, function_pointer);
    }

    private static native void nglFrustum(double var0, double var2, double var4, double var6, double var8, double var10, long var12);

    public static void glFrontFace(int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glFrontFace_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglFrontFace(mode, function_pointer);
    }

    private static native void nglFrontFace(int var0, long var1);

    public static void glFogf(int pname, float param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glFogf_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglFogf(pname, param, function_pointer);
    }

    private static native void nglFogf(int var0, float var1, long var2);

    public static void glFogi(int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glFogi_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglFogi(pname, param, function_pointer);
    }

    private static native void nglFogi(int var0, int var1, long var2);

    public static void glFog(int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glFogfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglFogfv(pname, params, params.position(), function_pointer);
    }

    private static native void nglFogfv(int var0, FloatBuffer var1, int var2, long var3);

    public static void glFog(int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glFogiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglFogiv(pname, params, params.position(), function_pointer);
    }

    private static native void nglFogiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glFlush() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glFlush_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglFlush(function_pointer);
    }

    private static native void nglFlush(long var0);

    public static void glFinish() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glFinish_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglFinish(function_pointer);
    }

    private static native void nglFinish(long var0);

    public static ByteBuffer glGetPointer(int pname, long result_size) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetPointerv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ByteBuffer __result = GL11.nglGetPointerv(pname, result_size, function_pointer);
        return __result;
    }

    private static native ByteBuffer nglGetPointerv(int var0, long var1, long var3);

    public static boolean glIsEnabled(int cap) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glIsEnabled_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = GL11.nglIsEnabled(cap, function_pointer);
        return __result;
    }

    private static native boolean nglIsEnabled(int var0, long var1);

    public static void glInterleavedArrays(int format, int stride, ByteBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glInterleavedArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GL11.nglInterleavedArrays(format, stride, pointer, pointer.position(), function_pointer);
    }

    public static void glInterleavedArrays(int format, int stride, DoubleBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glInterleavedArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GL11.nglInterleavedArrays(format, stride, pointer, pointer.position() << 3, function_pointer);
    }

    public static void glInterleavedArrays(int format, int stride, FloatBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glInterleavedArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GL11.nglInterleavedArrays(format, stride, pointer, pointer.position() << 2, function_pointer);
    }

    public static void glInterleavedArrays(int format, int stride, IntBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glInterleavedArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GL11.nglInterleavedArrays(format, stride, pointer, pointer.position() << 2, function_pointer);
    }

    public static void glInterleavedArrays(int format, int stride, ShortBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glInterleavedArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GL11.nglInterleavedArrays(format, stride, pointer, pointer.position() << 1, function_pointer);
    }

    private static native void nglInterleavedArrays(int var0, int var1, Buffer var2, int var3, long var4);

    public static void glInterleavedArrays(int format, int stride, long pointer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glInterleavedArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        GL11.nglInterleavedArraysBO(format, stride, pointer_buffer_offset, function_pointer);
    }

    private static native void nglInterleavedArraysBO(int var0, int var1, long var2, long var4);

    public static void glInitNames() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glInitNames_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglInitNames(function_pointer);
    }

    private static native void nglInitNames(long var0);

    public static void glHint(int target, int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glHint_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglHint(target, mode, function_pointer);
    }

    private static native void nglHint(int var0, int var1, long var2);

    public static void glGetTexParameter(int target, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexParameterfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglGetTexParameterfv(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetTexParameterfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static float glGetTexParameterf(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexParameterfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        FloatBuffer params = APIUtils.getBufferFloat();
        GL11.nglGetTexParameterfv(target, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetTexParameter(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglGetTexParameteriv(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetTexParameteriv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetTexParameteri(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL11.nglGetTexParameteriv(target, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetTexLevelParameter(int target, int level, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexLevelParameterfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglGetTexLevelParameterfv(target, level, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetTexLevelParameterfv(int var0, int var1, int var2, FloatBuffer var3, int var4, long var5);

    public static float glGetTexLevelParameterf(int target, int level, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexLevelParameterfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        FloatBuffer params = APIUtils.getBufferFloat();
        GL11.nglGetTexLevelParameterfv(target, level, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetTexLevelParameter(int target, int level, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexLevelParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglGetTexLevelParameteriv(target, level, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetTexLevelParameteriv(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static int glGetTexLevelParameteri(int target, int level, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexLevelParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL11.nglGetTexLevelParameteriv(target, level, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetTexImage(int target, int level, int format, int type, ByteBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexImage_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, 1, 1, 1));
        GL11.nglGetTexImage(target, level, format, type, pixels, pixels.position(), function_pointer);
    }

    public static void glGetTexImage(int target, int level, int format, int type, DoubleBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexImage_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, 1, 1, 1));
        GL11.nglGetTexImage(target, level, format, type, pixels, pixels.position() << 3, function_pointer);
    }

    public static void glGetTexImage(int target, int level, int format, int type, FloatBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexImage_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, 1, 1, 1));
        GL11.nglGetTexImage(target, level, format, type, pixels, pixels.position() << 2, function_pointer);
    }

    public static void glGetTexImage(int target, int level, int format, int type, IntBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexImage_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, 1, 1, 1));
        GL11.nglGetTexImage(target, level, format, type, pixels, pixels.position() << 2, function_pointer);
    }

    public static void glGetTexImage(int target, int level, int format, int type, ShortBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexImage_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, 1, 1, 1));
        GL11.nglGetTexImage(target, level, format, type, pixels, pixels.position() << 1, function_pointer);
    }

    private static native void nglGetTexImage(int var0, int var1, int var2, int var3, Buffer var4, int var5, long var6);

    public static void glGetTexImage(int target, int level, int format, int type, long pixels_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexImage_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOenabled(caps);
        GL11.nglGetTexImageBO(target, level, format, type, pixels_buffer_offset, function_pointer);
    }

    private static native void nglGetTexImageBO(int var0, int var1, int var2, int var3, long var4, long var6);

    public static void glGetTexGen(int coord, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexGeniv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglGetTexGeniv(coord, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetTexGeniv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetTexGeni(int coord, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexGeniv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL11.nglGetTexGeniv(coord, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetTexGen(int coord, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexGenfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglGetTexGenfv(coord, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetTexGenfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static float glGetTexGenf(int coord, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexGenfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        FloatBuffer params = APIUtils.getBufferFloat();
        GL11.nglGetTexGenfv(coord, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetTexGen(int coord, int pname, DoubleBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexGendv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglGetTexGendv(coord, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetTexGendv(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static double glGetTexGend(int coord, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexGendv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        DoubleBuffer params = APIUtils.getBufferDouble();
        GL11.nglGetTexGendv(coord, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetTexEnv(int coord, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexEnviv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglGetTexEnviv(coord, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetTexEnviv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetTexEnvi(int coord, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexEnviv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL11.nglGetTexEnviv(coord, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetTexEnv(int coord, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexEnvfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglGetTexEnvfv(coord, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetTexEnvfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static float glGetTexEnvf(int coord, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetTexEnvfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        FloatBuffer params = APIUtils.getBufferFloat();
        GL11.nglGetTexEnvfv(coord, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static String glGetString(int name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetString_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        String __result = GL11.nglGetString(name, function_pointer);
        return __result;
    }

    private static native String nglGetString(int var0, long var1);

    public static void glGetPolygonStipple(ByteBuffer mask) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetPolygonStipple_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOdisabled(caps);
        BufferChecks.checkBuffer(mask, 1024);
        GL11.nglGetPolygonStipple(mask, mask.position(), function_pointer);
    }

    private static native void nglGetPolygonStipple(ByteBuffer var0, int var1, long var2);

    public static void glGetPolygonStipple(long mask_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glGetPolygonStipple_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOenabled(caps);
        GL11.nglGetPolygonStippleBO(mask_buffer_offset, function_pointer);
    }

    private static native void nglGetPolygonStippleBO(long var0, long var2);

    public static boolean glIsList(int list) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glIsList_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = GL11.nglIsList(list, function_pointer);
        return __result;
    }

    private static native boolean nglIsList(int var0, long var1);

    public static void glMaterialf(int face, int pname, float param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMaterialf_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglMaterialf(face, pname, param, function_pointer);
    }

    private static native void nglMaterialf(int var0, int var1, float var2, long var3);

    public static void glMateriali(int face, int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMateriali_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglMateriali(face, pname, param, function_pointer);
    }

    private static native void nglMateriali(int var0, int var1, int var2, long var3);

    public static void glMaterial(int face, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMaterialfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglMaterialfv(face, pname, params, params.position(), function_pointer);
    }

    private static native void nglMaterialfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glMaterial(int face, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMaterialiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglMaterialiv(face, pname, params, params.position(), function_pointer);
    }

    private static native void nglMaterialiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glMapGrid1f(int un, float u1, float u2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMapGrid1f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglMapGrid1f(un, u1, u2, function_pointer);
    }

    private static native void nglMapGrid1f(int var0, float var1, float var2, long var3);

    public static void glMapGrid1d(int un, double u1, double u2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMapGrid1d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglMapGrid1d(un, u1, u2, function_pointer);
    }

    private static native void nglMapGrid1d(int var0, double var1, double var3, long var5);

    public static void glMapGrid2f(int un, float u1, float u2, int vn, float v1, float v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMapGrid2f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglMapGrid2f(un, u1, u2, vn, v1, v2, function_pointer);
    }

    private static native void nglMapGrid2f(int var0, float var1, float var2, int var3, float var4, float var5, long var6);

    public static void glMapGrid2d(int un, double u1, double u2, int vn, double v1, double v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMapGrid2d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglMapGrid2d(un, u1, u2, vn, v1, v2, function_pointer);
    }

    private static native void nglMapGrid2d(int var0, double var1, double var3, int var5, double var6, double var8, long var10);

    public static void glMap2f(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, FloatBuffer points) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMap2f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(points);
        GL11.nglMap2f(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, points.position(), function_pointer);
    }

    private static native void nglMap2f(int var0, float var1, float var2, int var3, int var4, float var5, float var6, int var7, int var8, FloatBuffer var9, int var10, long var11);

    public static void glMap2d(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, DoubleBuffer points) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMap2d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(points);
        GL11.nglMap2d(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, points.position(), function_pointer);
    }

    private static native void nglMap2d(int var0, double var1, double var3, int var5, int var6, double var7, double var9, int var11, int var12, DoubleBuffer var13, int var14, long var15);

    public static void glMap1f(int target, float u1, float u2, int stride, int order, FloatBuffer points) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMap1f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(points);
        GL11.nglMap1f(target, u1, u2, stride, order, points, points.position(), function_pointer);
    }

    private static native void nglMap1f(int var0, float var1, float var2, int var3, int var4, FloatBuffer var5, int var6, long var7);

    public static void glMap1d(int target, double u1, double u2, int stride, int order, DoubleBuffer points) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMap1d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(points);
        GL11.nglMap1d(target, u1, u2, stride, order, points, points.position(), function_pointer);
    }

    private static native void nglMap1d(int var0, double var1, double var3, int var5, int var6, DoubleBuffer var7, int var8, long var9);

    public static void glLogicOp(int opcode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLogicOp_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglLogicOp(opcode, function_pointer);
    }

    private static native void nglLogicOp(int var0, long var1);

    public static void glLoadName(int name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLoadName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglLoadName(name, function_pointer);
    }

    private static native void nglLoadName(int var0, long var1);

    public static void glLoadMatrix(FloatBuffer m2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLoadMatrixf_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(m2, 16);
        GL11.nglLoadMatrixf(m2, m2.position(), function_pointer);
    }

    private static native void nglLoadMatrixf(FloatBuffer var0, int var1, long var2);

    public static void glLoadMatrix(DoubleBuffer m2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLoadMatrixd_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(m2, 16);
        GL11.nglLoadMatrixd(m2, m2.position(), function_pointer);
    }

    private static native void nglLoadMatrixd(DoubleBuffer var0, int var1, long var2);

    public static void glLoadIdentity() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLoadIdentity_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglLoadIdentity(function_pointer);
    }

    private static native void nglLoadIdentity(long var0);

    public static void glListBase(int base) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glListBase_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglListBase(base, function_pointer);
    }

    private static native void nglListBase(int var0, long var1);

    public static void glLineWidth(float width) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLineWidth_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglLineWidth(width, function_pointer);
    }

    private static native void nglLineWidth(float var0, long var1);

    public static void glLineStipple(int factor, short pattern) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLineStipple_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglLineStipple(factor, pattern, function_pointer);
    }

    private static native void nglLineStipple(int var0, short var1, long var2);

    public static void glLightModelf(int pname, float param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLightModelf_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglLightModelf(pname, param, function_pointer);
    }

    private static native void nglLightModelf(int var0, float var1, long var2);

    public static void glLightModeli(int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLightModeli_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglLightModeli(pname, param, function_pointer);
    }

    private static native void nglLightModeli(int var0, int var1, long var2);

    public static void glLightModel(int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLightModelfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglLightModelfv(pname, params, params.position(), function_pointer);
    }

    private static native void nglLightModelfv(int var0, FloatBuffer var1, int var2, long var3);

    public static void glLightModel(int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLightModeliv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglLightModeliv(pname, params, params.position(), function_pointer);
    }

    private static native void nglLightModeliv(int var0, IntBuffer var1, int var2, long var3);

    public static void glLightf(int light, int pname, float param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLightf_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglLightf(light, pname, param, function_pointer);
    }

    private static native void nglLightf(int var0, int var1, float var2, long var3);

    public static void glLighti(int light, int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLighti_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglLighti(light, pname, param, function_pointer);
    }

    private static native void nglLighti(int var0, int var1, int var2, long var3);

    public static void glLight(int light, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLightfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglLightfv(light, pname, params, params.position(), function_pointer);
    }

    private static native void nglLightfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glLight(int light, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glLightiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglLightiv(light, pname, params, params.position(), function_pointer);
    }

    private static native void nglLightiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static boolean glIsTexture(int texture) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glIsTexture_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = GL11.nglIsTexture(texture, function_pointer);
        return __result;
    }

    private static native boolean nglIsTexture(int var0, long var1);

    public static void glMatrixMode(int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMatrixMode_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglMatrixMode(mode, function_pointer);
    }

    private static native void nglMatrixMode(int var0, long var1);

    public static void glPolygonStipple(ByteBuffer mask) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPolygonStipple_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(mask, 1024);
        GL11.nglPolygonStipple(mask, mask.position(), function_pointer);
    }

    private static native void nglPolygonStipple(ByteBuffer var0, int var1, long var2);

    public static void glPolygonStipple(long mask_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPolygonStipple_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOenabled(caps);
        GL11.nglPolygonStippleBO(mask_buffer_offset, function_pointer);
    }

    private static native void nglPolygonStippleBO(long var0, long var2);

    public static void glPolygonOffset(float factor, float units) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPolygonOffset_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPolygonOffset(factor, units, function_pointer);
    }

    private static native void nglPolygonOffset(float var0, float var1, long var2);

    public static void glPolygonMode(int face, int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPolygonMode_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPolygonMode(face, mode, function_pointer);
    }

    private static native void nglPolygonMode(int var0, int var1, long var2);

    public static void glPointSize(float size) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPointSize_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPointSize(size, function_pointer);
    }

    private static native void nglPointSize(float var0, long var1);

    public static void glPixelZoom(float xfactor, float yfactor) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPixelZoom_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPixelZoom(xfactor, yfactor, function_pointer);
    }

    private static native void nglPixelZoom(float var0, float var1, long var2);

    public static void glPixelTransferf(int pname, float param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPixelTransferf_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPixelTransferf(pname, param, function_pointer);
    }

    private static native void nglPixelTransferf(int var0, float var1, long var2);

    public static void glPixelTransferi(int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPixelTransferi_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPixelTransferi(pname, param, function_pointer);
    }

    private static native void nglPixelTransferi(int var0, int var1, long var2);

    public static void glPixelStoref(int pname, float param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPixelStoref_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPixelStoref(pname, param, function_pointer);
    }

    private static native void nglPixelStoref(int var0, float var1, long var2);

    public static void glPixelStorei(int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPixelStorei_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPixelStorei(pname, param, function_pointer);
    }

    private static native void nglPixelStorei(int var0, int var1, long var2);

    public static void glPixelMap(int map, FloatBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPixelMapfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkDirect(values);
        GL11.nglPixelMapfv(map, values.remaining(), values, values.position(), function_pointer);
    }

    private static native void nglPixelMapfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glPixelMapfv(int map, int mapsize, long values_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPixelMapfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOenabled(caps);
        GL11.nglPixelMapfvBO(map, mapsize, values_buffer_offset, function_pointer);
    }

    private static native void nglPixelMapfvBO(int var0, int var1, long var2, long var4);

    public static void glPixelMapu(int map, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPixelMapuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkDirect(values);
        GL11.nglPixelMapuiv(map, values.remaining(), values, values.position(), function_pointer);
    }

    private static native void nglPixelMapuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glPixelMapuiv(int map, int mapsize, long values_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPixelMapuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOenabled(caps);
        GL11.nglPixelMapuivBO(map, mapsize, values_buffer_offset, function_pointer);
    }

    private static native void nglPixelMapuivBO(int var0, int var1, long var2, long var4);

    public static void glPixelMapu(int map, ShortBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPixelMapusv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkDirect(values);
        GL11.nglPixelMapusv(map, values.remaining(), values, values.position(), function_pointer);
    }

    private static native void nglPixelMapusv(int var0, int var1, ShortBuffer var2, int var3, long var4);

    public static void glPixelMapusv(int map, int mapsize, long values_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPixelMapusv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOenabled(caps);
        GL11.nglPixelMapusvBO(map, mapsize, values_buffer_offset, function_pointer);
    }

    private static native void nglPixelMapusvBO(int var0, int var1, long var2, long var4);

    public static void glPassThrough(float token) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPassThrough_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPassThrough(token, function_pointer);
    }

    private static native void nglPassThrough(float var0, long var1);

    public static void glOrtho(double left, double right, double bottom, double top, double zNear, double zFar) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glOrtho_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglOrtho(left, right, bottom, top, zNear, zFar, function_pointer);
    }

    private static native void nglOrtho(double var0, double var2, double var4, double var6, double var8, double var10, long var12);

    public static void glNormalPointer(int stride, ByteBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glNormalPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).GL11_glNormalPointer_pointer = pointer;
        GL11.nglNormalPointer(5120, stride, pointer, pointer.position(), function_pointer);
    }

    public static void glNormalPointer(int stride, DoubleBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glNormalPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).GL11_glNormalPointer_pointer = pointer;
        GL11.nglNormalPointer(5130, stride, pointer, pointer.position() << 3, function_pointer);
    }

    public static void glNormalPointer(int stride, FloatBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glNormalPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).GL11_glNormalPointer_pointer = pointer;
        GL11.nglNormalPointer(5126, stride, pointer, pointer.position() << 2, function_pointer);
    }

    public static void glNormalPointer(int stride, IntBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glNormalPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).GL11_glNormalPointer_pointer = pointer;
        GL11.nglNormalPointer(5124, stride, pointer, pointer.position() << 2, function_pointer);
    }

    private static native void nglNormalPointer(int var0, int var1, Buffer var2, int var3, long var4);

    public static void glNormalPointer(int type, int stride, long pointer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glNormalPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        GL11.nglNormalPointerBO(type, stride, pointer_buffer_offset, function_pointer);
    }

    private static native void nglNormalPointerBO(int var0, int var1, long var2, long var4);

    public static void glNormal3b(byte nx2, byte ny2, byte nz2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glNormal3b_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglNormal3b(nx2, ny2, nz2, function_pointer);
    }

    private static native void nglNormal3b(byte var0, byte var1, byte var2, long var3);

    public static void glNormal3f(float nx2, float ny2, float nz2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glNormal3f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglNormal3f(nx2, ny2, nz2, function_pointer);
    }

    private static native void nglNormal3f(float var0, float var1, float var2, long var3);

    public static void glNormal3d(double nx2, double ny2, double nz2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glNormal3d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglNormal3d(nx2, ny2, nz2, function_pointer);
    }

    private static native void nglNormal3d(double var0, double var2, double var4, long var6);

    public static void glNormal3i(int nx2, int ny2, int nz2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glNormal3i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglNormal3i(nx2, ny2, nz2, function_pointer);
    }

    private static native void nglNormal3i(int var0, int var1, int var2, long var3);

    public static void glNewList(int list, int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glNewList_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglNewList(list, mode, function_pointer);
    }

    private static native void nglNewList(int var0, int var1, long var2);

    public static void glEndList() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glEndList_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglEndList(function_pointer);
    }

    private static native void nglEndList(long var0);

    public static void glMultMatrix(FloatBuffer m2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMultMatrixf_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(m2, 16);
        GL11.nglMultMatrixf(m2, m2.position(), function_pointer);
    }

    private static native void nglMultMatrixf(FloatBuffer var0, int var1, long var2);

    public static void glMultMatrix(DoubleBuffer m2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glMultMatrixd_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(m2, 16);
        GL11.nglMultMatrixd(m2, m2.position(), function_pointer);
    }

    private static native void nglMultMatrixd(DoubleBuffer var0, int var1, long var2);

    public static void glShadeModel(int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glShadeModel_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglShadeModel(mode, function_pointer);
    }

    private static native void nglShadeModel(int var0, long var1);

    public static void glSelectBuffer(IntBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glSelectBuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(buffer);
        GL11.nglSelectBuffer(buffer.remaining(), buffer, buffer.position(), function_pointer);
    }

    private static native void nglSelectBuffer(int var0, IntBuffer var1, int var2, long var3);

    public static void glScissor(int x2, int y2, int width, int height) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glScissor_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglScissor(x2, y2, width, height, function_pointer);
    }

    private static native void nglScissor(int var0, int var1, int var2, int var3, long var4);

    public static void glScalef(float x2, float y2, float z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glScalef_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglScalef(x2, y2, z2, function_pointer);
    }

    private static native void nglScalef(float var0, float var1, float var2, long var3);

    public static void glScaled(double x2, double y2, double z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glScaled_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglScaled(x2, y2, z2, function_pointer);
    }

    private static native void nglScaled(double var0, double var2, double var4, long var6);

    public static void glRotatef(float angle, float x2, float y2, float z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glRotatef_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglRotatef(angle, x2, y2, z2, function_pointer);
    }

    private static native void nglRotatef(float var0, float var1, float var2, float var3, long var4);

    public static int glRenderMode(int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glRenderMode_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = GL11.nglRenderMode(mode, function_pointer);
        return __result;
    }

    private static native int nglRenderMode(int var0, long var1);

    public static void glRectf(float x1, float y1, float x2, float y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glRectf_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglRectf(x1, y1, x2, y2, function_pointer);
    }

    private static native void nglRectf(float var0, float var1, float var2, float var3, long var4);

    public static void glRectd(double x1, double y1, double x2, double y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glRectd_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglRectd(x1, y1, x2, y2, function_pointer);
    }

    private static native void nglRectd(double var0, double var2, double var4, double var6, long var8);

    public static void glRecti(int x1, int y1, int x2, int y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glRecti_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglRecti(x1, y1, x2, y2, function_pointer);
    }

    private static native void nglRecti(int var0, int var1, int var2, int var3, long var4);

    public static void glReadPixels(int x2, int y2, int width, int height, int format, int type, ByteBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glReadPixels_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, height, 1));
        GL11.nglReadPixels(x2, y2, width, height, format, type, pixels, pixels.position(), function_pointer);
    }

    public static void glReadPixels(int x2, int y2, int width, int height, int format, int type, DoubleBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glReadPixels_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, height, 1));
        GL11.nglReadPixels(x2, y2, width, height, format, type, pixels, pixels.position() << 3, function_pointer);
    }

    public static void glReadPixels(int x2, int y2, int width, int height, int format, int type, FloatBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glReadPixels_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, height, 1));
        GL11.nglReadPixels(x2, y2, width, height, format, type, pixels, pixels.position() << 2, function_pointer);
    }

    public static void glReadPixels(int x2, int y2, int width, int height, int format, int type, IntBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glReadPixels_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, height, 1));
        GL11.nglReadPixels(x2, y2, width, height, format, type, pixels, pixels.position() << 2, function_pointer);
    }

    public static void glReadPixels(int x2, int y2, int width, int height, int format, int type, ShortBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glReadPixels_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, height, 1));
        GL11.nglReadPixels(x2, y2, width, height, format, type, pixels, pixels.position() << 1, function_pointer);
    }

    private static native void nglReadPixels(int var0, int var1, int var2, int var3, int var4, int var5, Buffer var6, int var7, long var8);

    public static void glReadPixels(int x2, int y2, int width, int height, int format, int type, long pixels_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glReadPixels_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensurePackPBOenabled(caps);
        GL11.nglReadPixelsBO(x2, y2, width, height, format, type, pixels_buffer_offset, function_pointer);
    }

    private static native void nglReadPixelsBO(int var0, int var1, int var2, int var3, int var4, int var5, long var6, long var8);

    public static void glReadBuffer(int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glReadBuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglReadBuffer(mode, function_pointer);
    }

    private static native void nglReadBuffer(int var0, long var1);

    public static void glRasterPos2f(float x2, float y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glRasterPos2f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglRasterPos2f(x2, y2, function_pointer);
    }

    private static native void nglRasterPos2f(float var0, float var1, long var2);

    public static void glRasterPos2d(double x2, double y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glRasterPos2d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglRasterPos2d(x2, y2, function_pointer);
    }

    private static native void nglRasterPos2d(double var0, double var2, long var4);

    public static void glRasterPos2i(int x2, int y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glRasterPos2i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglRasterPos2i(x2, y2, function_pointer);
    }

    private static native void nglRasterPos2i(int var0, int var1, long var2);

    public static void glRasterPos3f(float x2, float y2, float z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glRasterPos3f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglRasterPos3f(x2, y2, z2, function_pointer);
    }

    private static native void nglRasterPos3f(float var0, float var1, float var2, long var3);

    public static void glRasterPos3d(double x2, double y2, double z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glRasterPos3d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglRasterPos3d(x2, y2, z2, function_pointer);
    }

    private static native void nglRasterPos3d(double var0, double var2, double var4, long var6);

    public static void glRasterPos3i(int x2, int y2, int z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glRasterPos3i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglRasterPos3i(x2, y2, z2, function_pointer);
    }

    private static native void nglRasterPos3i(int var0, int var1, int var2, long var3);

    public static void glRasterPos4f(float x2, float y2, float z2, float w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glRasterPos4f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglRasterPos4f(x2, y2, z2, w2, function_pointer);
    }

    private static native void nglRasterPos4f(float var0, float var1, float var2, float var3, long var4);

    public static void glRasterPos4d(double x2, double y2, double z2, double w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glRasterPos4d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglRasterPos4d(x2, y2, z2, w2, function_pointer);
    }

    private static native void nglRasterPos4d(double var0, double var2, double var4, double var6, long var8);

    public static void glRasterPos4i(int x2, int y2, int z2, int w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glRasterPos4i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglRasterPos4i(x2, y2, z2, w2, function_pointer);
    }

    private static native void nglRasterPos4i(int var0, int var1, int var2, int var3, long var4);

    public static void glPushName(int name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPushName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPushName(name, function_pointer);
    }

    private static native void nglPushName(int var0, long var1);

    public static void glPopName() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPopName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPopName(function_pointer);
    }

    private static native void nglPopName(long var0);

    public static void glPushMatrix() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPushMatrix_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPushMatrix(function_pointer);
    }

    private static native void nglPushMatrix(long var0);

    public static void glPopMatrix() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPopMatrix_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPopMatrix(function_pointer);
    }

    private static native void nglPopMatrix(long var0);

    public static void glPushClientAttrib(int mask) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPushClientAttrib_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        StateTracker.pushAttrib(caps, mask);
        GL11.nglPushClientAttrib(mask, function_pointer);
    }

    private static native void nglPushClientAttrib(int var0, long var1);

    public static void glPopClientAttrib() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPopClientAttrib_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        StateTracker.popAttrib(caps);
        GL11.nglPopClientAttrib(function_pointer);
    }

    private static native void nglPopClientAttrib(long var0);

    public static void glPushAttrib(int mask) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPushAttrib_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPushAttrib(mask, function_pointer);
    }

    private static native void nglPushAttrib(int var0, long var1);

    public static void glPopAttrib() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glPopAttrib_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglPopAttrib(function_pointer);
    }

    private static native void nglPopAttrib(long var0);

    public static void glStencilFunc(int func, int ref, int mask) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glStencilFunc_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglStencilFunc(func, ref, mask, function_pointer);
    }

    private static native void nglStencilFunc(int var0, int var1, int var2, long var3);

    public static void glVertexPointer(int size, int stride, DoubleBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glVertexPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).GL11_glVertexPointer_pointer = pointer;
        GL11.nglVertexPointer(size, 5130, stride, pointer, pointer.position() << 3, function_pointer);
    }

    public static void glVertexPointer(int size, int stride, FloatBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glVertexPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).GL11_glVertexPointer_pointer = pointer;
        GL11.nglVertexPointer(size, 5126, stride, pointer, pointer.position() << 2, function_pointer);
    }

    public static void glVertexPointer(int size, int stride, IntBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glVertexPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).GL11_glVertexPointer_pointer = pointer;
        GL11.nglVertexPointer(size, 5124, stride, pointer, pointer.position() << 2, function_pointer);
    }

    public static void glVertexPointer(int size, int stride, ShortBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glVertexPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).GL11_glVertexPointer_pointer = pointer;
        GL11.nglVertexPointer(size, 5122, stride, pointer, pointer.position() << 1, function_pointer);
    }

    private static native void nglVertexPointer(int var0, int var1, int var2, Buffer var3, int var4, long var5);

    public static void glVertexPointer(int size, int type, int stride, long pointer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glVertexPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        GL11.nglVertexPointerBO(size, type, stride, pointer_buffer_offset, function_pointer);
    }

    private static native void nglVertexPointerBO(int var0, int var1, int var2, long var3, long var5);

    public static void glVertex2f(float x2, float y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glVertex2f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglVertex2f(x2, y2, function_pointer);
    }

    private static native void nglVertex2f(float var0, float var1, long var2);

    public static void glVertex2d(double x2, double y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glVertex2d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglVertex2d(x2, y2, function_pointer);
    }

    private static native void nglVertex2d(double var0, double var2, long var4);

    public static void glVertex2i(int x2, int y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glVertex2i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglVertex2i(x2, y2, function_pointer);
    }

    private static native void nglVertex2i(int var0, int var1, long var2);

    public static void glVertex3f(float x2, float y2, float z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glVertex3f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglVertex3f(x2, y2, z2, function_pointer);
    }

    private static native void nglVertex3f(float var0, float var1, float var2, long var3);

    public static void glVertex3d(double x2, double y2, double z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glVertex3d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglVertex3d(x2, y2, z2, function_pointer);
    }

    private static native void nglVertex3d(double var0, double var2, double var4, long var6);

    public static void glVertex3i(int x2, int y2, int z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glVertex3i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglVertex3i(x2, y2, z2, function_pointer);
    }

    private static native void nglVertex3i(int var0, int var1, int var2, long var3);

    public static void glVertex4f(float x2, float y2, float z2, float w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glVertex4f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglVertex4f(x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertex4f(float var0, float var1, float var2, float var3, long var4);

    public static void glVertex4d(double x2, double y2, double z2, double w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glVertex4d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglVertex4d(x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertex4d(double var0, double var2, double var4, double var6, long var8);

    public static void glVertex4i(int x2, int y2, int z2, int w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glVertex4i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglVertex4i(x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertex4i(int var0, int var1, int var2, int var3, long var4);

    public static void glTranslatef(float x2, float y2, float z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTranslatef_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTranslatef(x2, y2, z2, function_pointer);
    }

    private static native void nglTranslatef(float var0, float var1, float var2, long var3);

    public static void glTranslated(double x2, double y2, double z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTranslated_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTranslated(x2, y2, z2, function_pointer);
    }

    private static native void nglTranslated(double var0, double var2, double var4, long var6);

    public static void glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, ByteBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexImage1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        if (pixels != null) {
            BufferChecks.checkBuffer(pixels, GLChecks.calculateTexImage1DStorage(pixels, format, type, width));
        }
        GL11.nglTexImage1D(target, level, internalformat, width, border, format, type, pixels, pixels != null ? pixels.position() : 0, function_pointer);
    }

    public static void glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, DoubleBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexImage1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        if (pixels != null) {
            BufferChecks.checkBuffer(pixels, GLChecks.calculateTexImage1DStorage(pixels, format, type, width));
        }
        GL11.nglTexImage1D(target, level, internalformat, width, border, format, type, pixels, pixels != null ? pixels.position() << 3 : 0, function_pointer);
    }

    public static void glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, FloatBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexImage1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        if (pixels != null) {
            BufferChecks.checkBuffer(pixels, GLChecks.calculateTexImage1DStorage(pixels, format, type, width));
        }
        GL11.nglTexImage1D(target, level, internalformat, width, border, format, type, pixels, pixels != null ? pixels.position() << 2 : 0, function_pointer);
    }

    public static void glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, IntBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexImage1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        if (pixels != null) {
            BufferChecks.checkBuffer(pixels, GLChecks.calculateTexImage1DStorage(pixels, format, type, width));
        }
        GL11.nglTexImage1D(target, level, internalformat, width, border, format, type, pixels, pixels != null ? pixels.position() << 2 : 0, function_pointer);
    }

    public static void glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, ShortBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexImage1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        if (pixels != null) {
            BufferChecks.checkBuffer(pixels, GLChecks.calculateTexImage1DStorage(pixels, format, type, width));
        }
        GL11.nglTexImage1D(target, level, internalformat, width, border, format, type, pixels, pixels != null ? pixels.position() << 1 : 0, function_pointer);
    }

    private static native void nglTexImage1D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Buffer var7, int var8, long var9);

    public static void glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, long pixels_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexImage1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOenabled(caps);
        GL11.nglTexImage1DBO(target, level, internalformat, width, border, format, type, pixels_buffer_offset, function_pointer);
    }

    private static native void nglTexImage1DBO(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7, long var9);

    public static void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, ByteBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexImage2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        if (pixels != null) {
            BufferChecks.checkBuffer(pixels, GLChecks.calculateTexImage2DStorage(pixels, format, type, width, height));
        }
        GL11.nglTexImage2D(target, level, internalformat, width, height, border, format, type, pixels, pixels != null ? pixels.position() : 0, function_pointer);
    }

    public static void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, DoubleBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexImage2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        if (pixels != null) {
            BufferChecks.checkBuffer(pixels, GLChecks.calculateTexImage2DStorage(pixels, format, type, width, height));
        }
        GL11.nglTexImage2D(target, level, internalformat, width, height, border, format, type, pixels, pixels != null ? pixels.position() << 3 : 0, function_pointer);
    }

    public static void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, FloatBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexImage2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        if (pixels != null) {
            BufferChecks.checkBuffer(pixels, GLChecks.calculateTexImage2DStorage(pixels, format, type, width, height));
        }
        GL11.nglTexImage2D(target, level, internalformat, width, height, border, format, type, pixels, pixels != null ? pixels.position() << 2 : 0, function_pointer);
    }

    public static void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, IntBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexImage2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        if (pixels != null) {
            BufferChecks.checkBuffer(pixels, GLChecks.calculateTexImage2DStorage(pixels, format, type, width, height));
        }
        GL11.nglTexImage2D(target, level, internalformat, width, height, border, format, type, pixels, pixels != null ? pixels.position() << 2 : 0, function_pointer);
    }

    public static void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, ShortBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexImage2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        if (pixels != null) {
            BufferChecks.checkBuffer(pixels, GLChecks.calculateTexImage2DStorage(pixels, format, type, width, height));
        }
        GL11.nglTexImage2D(target, level, internalformat, width, height, border, format, type, pixels, pixels != null ? pixels.position() << 1 : 0, function_pointer);
    }

    private static native void nglTexImage2D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Buffer var8, int var9, long var10);

    public static void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, long pixels_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexImage2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOenabled(caps);
        GL11.nglTexImage2DBO(target, level, internalformat, width, height, border, format, type, pixels_buffer_offset, function_pointer);
    }

    private static native void nglTexImage2DBO(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8, long var10);

    public static void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, ByteBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexSubImage1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, 1, 1));
        GL11.nglTexSubImage1D(target, level, xoffset, width, format, type, pixels, pixels.position(), function_pointer);
    }

    public static void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, DoubleBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexSubImage1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, 1, 1));
        GL11.nglTexSubImage1D(target, level, xoffset, width, format, type, pixels, pixels.position() << 3, function_pointer);
    }

    public static void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, FloatBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexSubImage1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, 1, 1));
        GL11.nglTexSubImage1D(target, level, xoffset, width, format, type, pixels, pixels.position() << 2, function_pointer);
    }

    public static void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, IntBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexSubImage1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, 1, 1));
        GL11.nglTexSubImage1D(target, level, xoffset, width, format, type, pixels, pixels.position() << 2, function_pointer);
    }

    public static void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, ShortBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexSubImage1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, 1, 1));
        GL11.nglTexSubImage1D(target, level, xoffset, width, format, type, pixels, pixels.position() << 1, function_pointer);
    }

    private static native void nglTexSubImage1D(int var0, int var1, int var2, int var3, int var4, int var5, Buffer var6, int var7, long var8);

    public static void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, long pixels_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexSubImage1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOenabled(caps);
        GL11.nglTexSubImage1DBO(target, level, xoffset, width, format, type, pixels_buffer_offset, function_pointer);
    }

    private static native void nglTexSubImage1DBO(int var0, int var1, int var2, int var3, int var4, int var5, long var6, long var8);

    public static void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, ByteBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexSubImage2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, height, 1));
        GL11.nglTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels, pixels.position(), function_pointer);
    }

    public static void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, DoubleBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexSubImage2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, height, 1));
        GL11.nglTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels, pixels.position() << 3, function_pointer);
    }

    public static void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, FloatBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexSubImage2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, height, 1));
        GL11.nglTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels, pixels.position() << 2, function_pointer);
    }

    public static void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, IntBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexSubImage2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, height, 1));
        GL11.nglTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels, pixels.position() << 2, function_pointer);
    }

    public static void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, ShortBuffer pixels) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexSubImage2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOdisabled(caps);
        BufferChecks.checkBuffer(pixels, GLChecks.calculateImageStorage(pixels, format, type, width, height, 1));
        GL11.nglTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels, pixels.position() << 1, function_pointer);
    }

    private static native void nglTexSubImage2D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Buffer var8, int var9, long var10);

    public static void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, long pixels_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexSubImage2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureUnpackPBOenabled(caps);
        GL11.nglTexSubImage2DBO(target, level, xoffset, yoffset, width, height, format, type, pixels_buffer_offset, function_pointer);
    }

    private static native void nglTexSubImage2DBO(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8, long var10);

    public static void glTexParameterf(int target, int pname, float param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexParameterf_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexParameterf(target, pname, param, function_pointer);
    }

    private static native void nglTexParameterf(int var0, int var1, float var2, long var3);

    public static void glTexParameteri(int target, int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexParameteri_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexParameteri(target, pname, param, function_pointer);
    }

    private static native void nglTexParameteri(int var0, int var1, int var2, long var3);

    public static void glTexParameter(int target, int pname, FloatBuffer param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexParameterfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(param, 4);
        GL11.nglTexParameterfv(target, pname, param, param.position(), function_pointer);
    }

    private static native void nglTexParameterfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glTexParameter(int target, int pname, IntBuffer param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(param, 4);
        GL11.nglTexParameteriv(target, pname, param, param.position(), function_pointer);
    }

    private static native void nglTexParameteriv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glTexGenf(int coord, int pname, float param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexGenf_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexGenf(coord, pname, param, function_pointer);
    }

    private static native void nglTexGenf(int var0, int var1, float var2, long var3);

    public static void glTexGend(int coord, int pname, double param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexGend_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexGend(coord, pname, param, function_pointer);
    }

    private static native void nglTexGend(int var0, int var1, double var2, long var4);

    public static void glTexGen(int coord, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexGenfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglTexGenfv(coord, pname, params, params.position(), function_pointer);
    }

    private static native void nglTexGenfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glTexGen(int coord, int pname, DoubleBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexGendv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglTexGendv(coord, pname, params, params.position(), function_pointer);
    }

    private static native void nglTexGendv(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glTexGeni(int coord, int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexGeni_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexGeni(coord, pname, param, function_pointer);
    }

    private static native void nglTexGeni(int var0, int var1, int var2, long var3);

    public static void glTexGen(int coord, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexGeniv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglTexGeniv(coord, pname, params, params.position(), function_pointer);
    }

    private static native void nglTexGeniv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glTexEnvf(int target, int pname, float param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexEnvf_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexEnvf(target, pname, param, function_pointer);
    }

    private static native void nglTexEnvf(int var0, int var1, float var2, long var3);

    public static void glTexEnvi(int target, int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexEnvi_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexEnvi(target, pname, param, function_pointer);
    }

    private static native void nglTexEnvi(int var0, int var1, int var2, long var3);

    public static void glTexEnv(int target, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexEnvfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglTexEnvfv(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglTexEnvfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glTexEnv(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexEnviv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL11.nglTexEnviv(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglTexEnviv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glTexCoordPointer(int size, int stride, DoubleBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexCoordPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).glTexCoordPointer_buffer[GLChecks.getReferences((ContextCapabilities)caps).glClientActiveTexture] = pointer;
        GL11.nglTexCoordPointer(size, 5130, stride, pointer, pointer.position() << 3, function_pointer);
    }

    public static void glTexCoordPointer(int size, int stride, FloatBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexCoordPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).glTexCoordPointer_buffer[GLChecks.getReferences((ContextCapabilities)caps).glClientActiveTexture] = pointer;
        GL11.nglTexCoordPointer(size, 5126, stride, pointer, pointer.position() << 2, function_pointer);
    }

    public static void glTexCoordPointer(int size, int stride, IntBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexCoordPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).glTexCoordPointer_buffer[GLChecks.getReferences((ContextCapabilities)caps).glClientActiveTexture] = pointer;
        GL11.nglTexCoordPointer(size, 5124, stride, pointer, pointer.position() << 2, function_pointer);
    }

    public static void glTexCoordPointer(int size, int stride, ShortBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexCoordPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).glTexCoordPointer_buffer[GLChecks.getReferences((ContextCapabilities)caps).glClientActiveTexture] = pointer;
        GL11.nglTexCoordPointer(size, 5122, stride, pointer, pointer.position() << 1, function_pointer);
    }

    private static native void nglTexCoordPointer(int var0, int var1, int var2, Buffer var3, int var4, long var5);

    public static void glTexCoordPointer(int size, int type, int stride, long pointer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexCoordPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        GL11.nglTexCoordPointerBO(size, type, stride, pointer_buffer_offset, function_pointer);
    }

    private static native void nglTexCoordPointerBO(int var0, int var1, int var2, long var3, long var5);

    public static void glTexCoord1f(float s2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexCoord1f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexCoord1f(s2, function_pointer);
    }

    private static native void nglTexCoord1f(float var0, long var1);

    public static void glTexCoord1d(double s2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexCoord1d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexCoord1d(s2, function_pointer);
    }

    private static native void nglTexCoord1d(double var0, long var2);

    public static void glTexCoord2f(float s2, float t2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexCoord2f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexCoord2f(s2, t2, function_pointer);
    }

    private static native void nglTexCoord2f(float var0, float var1, long var2);

    public static void glTexCoord2d(double s2, double t2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexCoord2d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexCoord2d(s2, t2, function_pointer);
    }

    private static native void nglTexCoord2d(double var0, double var2, long var4);

    public static void glTexCoord3f(float s2, float t2, float r2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexCoord3f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexCoord3f(s2, t2, r2, function_pointer);
    }

    private static native void nglTexCoord3f(float var0, float var1, float var2, long var3);

    public static void glTexCoord3d(double s2, double t2, double r2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexCoord3d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexCoord3d(s2, t2, r2, function_pointer);
    }

    private static native void nglTexCoord3d(double var0, double var2, double var4, long var6);

    public static void glTexCoord4f(float s2, float t2, float r2, float q2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexCoord4f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexCoord4f(s2, t2, r2, q2, function_pointer);
    }

    private static native void nglTexCoord4f(float var0, float var1, float var2, float var3, long var4);

    public static void glTexCoord4d(double s2, double t2, double r2, double q2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glTexCoord4d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglTexCoord4d(s2, t2, r2, q2, function_pointer);
    }

    private static native void nglTexCoord4d(double var0, double var2, double var4, double var6, long var8);

    public static void glStencilOp(int fail, int zfail, int zpass) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glStencilOp_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglStencilOp(fail, zfail, zpass, function_pointer);
    }

    private static native void nglStencilOp(int var0, int var1, int var2, long var3);

    public static void glStencilMask(int mask) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glStencilMask_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglStencilMask(mask, function_pointer);
    }

    private static native void nglStencilMask(int var0, long var1);

    public static void glViewport(int x2, int y2, int width, int height) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL11_glViewport_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL11.nglViewport(x2, y2, width, height, function_pointer);
    }

    private static native void nglViewport(int var0, int var1, int var2, int var3, long var4);
}

