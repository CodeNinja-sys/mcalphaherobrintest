/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.Set;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.StateTracker;

public class ContextCapabilities {
    static final boolean DEBUG = false;
    final StateTracker tracker = new StateTracker();
    final IntBuffer scratch_int_buffer = BufferUtils.createIntBuffer(16);
    public final boolean GL_AMD_conservative_depth;
    public final boolean GL_AMD_draw_buffers_blend;
    public final boolean GL_AMD_performance_monitor;
    public final boolean GL_AMD_seamless_cubemap_per_texture;
    public final boolean GL_AMD_shader_stencil_export;
    public final boolean GL_AMD_texture_texture4;
    public final boolean GL_AMD_vertex_shader_tessellator;
    public final boolean GL_APPLE_aux_depth_stencil;
    public final boolean GL_APPLE_client_storage;
    public final boolean GL_APPLE_element_array;
    public final boolean GL_APPLE_fence;
    public final boolean GL_APPLE_float_pixels;
    public final boolean GL_APPLE_flush_buffer_range;
    public final boolean GL_APPLE_object_purgeable;
    public final boolean GL_APPLE_packed_pixels;
    public final boolean GL_APPLE_rgb_422;
    public final boolean GL_APPLE_row_bytes;
    public final boolean GL_APPLE_texture_range;
    public final boolean GL_APPLE_vertex_array_object;
    public final boolean GL_APPLE_vertex_array_range;
    public final boolean GL_APPLE_vertex_program_evaluators;
    public final boolean GL_APPLE_ycbcr_422;
    public final boolean GL_ARB_blend_func_extended;
    public final boolean GL_ARB_color_buffer_float;
    public final boolean GL_ARB_compatibility;
    public final boolean GL_ARB_copy_buffer;
    public final boolean GL_ARB_depth_buffer_float;
    public final boolean GL_ARB_depth_clamp;
    public final boolean GL_ARB_depth_texture;
    public final boolean GL_ARB_draw_buffers;
    public final boolean GL_ARB_draw_buffers_blend;
    public final boolean GL_ARB_draw_elements_base_vertex;
    public final boolean GL_ARB_draw_indirect;
    public final boolean GL_ARB_draw_instanced;
    public final boolean GL_ARB_explicit_attrib_location;
    public final boolean GL_ARB_fragment_coord_conventions;
    public final boolean GL_ARB_fragment_program;
    public final boolean GL_ARB_fragment_program_shadow;
    public final boolean GL_ARB_fragment_shader;
    public final boolean GL_ARB_framebuffer_object;
    public final boolean GL_ARB_framebuffer_sRGB;
    public final boolean GL_ARB_geometry_shader4;
    public final boolean GL_ARB_gpu_shader5;
    public final boolean GL_ARB_gpu_shader_fp64;
    public final boolean GL_ARB_half_float_pixel;
    public final boolean GL_ARB_half_float_vertex;
    public final boolean GL_ARB_imaging;
    public final boolean GL_ARB_instanced_arrays;
    public final boolean GL_ARB_map_buffer_range;
    public final boolean GL_ARB_matrix_palette;
    public final boolean GL_ARB_multisample;
    public final boolean GL_ARB_multitexture;
    public final boolean GL_ARB_occlusion_query;
    public final boolean GL_ARB_occlusion_query2;
    public final boolean GL_ARB_pixel_buffer_object;
    public final boolean GL_ARB_point_parameters;
    public final boolean GL_ARB_point_sprite;
    public final boolean GL_ARB_provoking_vertex;
    public final boolean GL_ARB_sample_shading;
    public final boolean GL_ARB_sampler_objects;
    public final boolean GL_ARB_seamless_cube_map;
    public final boolean GL_ARB_shader_bit_encoding;
    public final boolean GL_ARB_shader_objects;
    public final boolean GL_ARB_shader_subroutine;
    public final boolean GL_ARB_shader_texture_lod;
    public final boolean GL_ARB_shading_language_100;
    public final boolean GL_ARB_shading_language_include;
    public final boolean GL_ARB_shadow;
    public final boolean GL_ARB_shadow_ambient;
    public final boolean GL_ARB_sync;
    public final boolean GL_ARB_tessellation_shader;
    public final boolean GL_ARB_texture_border_clamp;
    public final boolean GL_ARB_texture_buffer_object;
    public final boolean GL_ARB_texture_buffer_object_rgb32;
    public final boolean GL_ARB_texture_compression;
    public final boolean GL_ARB_texture_compression_bptc;
    public final boolean GL_ARB_texture_compression_rgtc;
    public final boolean GL_ARB_texture_cube_map;
    public final boolean GL_ARB_texture_cube_map_array;
    public final boolean GL_ARB_texture_env_add;
    public final boolean GL_ARB_texture_env_combine;
    public final boolean GL_ARB_texture_env_crossbar;
    public final boolean GL_ARB_texture_env_dot3;
    public final boolean GL_ARB_texture_float;
    public final boolean GL_ARB_texture_gather;
    public final boolean GL_ARB_texture_mirrored_repeat;
    public final boolean GL_ARB_texture_multisample;
    public final boolean GL_ARB_texture_non_power_of_two;
    public final boolean GL_ARB_texture_query_lod;
    public final boolean GL_ARB_texture_rectangle;
    public final boolean GL_ARB_texture_rg;
    public final boolean GL_ARB_texture_rgb10_a2ui;
    public final boolean GL_ARB_texture_swizzle;
    public final boolean GL_ARB_timer_query;
    public final boolean GL_ARB_transform_feedback2;
    public final boolean GL_ARB_transform_feedback3;
    public final boolean GL_ARB_transpose_matrix;
    public final boolean GL_ARB_uniform_buffer_object;
    public final boolean GL_ARB_vertex_array_bgra;
    public final boolean GL_ARB_vertex_array_object;
    public final boolean GL_ARB_vertex_blend;
    public final boolean GL_ARB_vertex_buffer_object;
    public final boolean GL_ARB_vertex_program;
    public final boolean GL_ARB_vertex_shader;
    public final boolean GL_ARB_vertex_type_2_10_10_10_rev;
    public final boolean GL_ARB_window_pos;
    public final boolean GL_ATI_draw_buffers;
    public final boolean GL_ATI_element_array;
    public final boolean GL_ATI_envmap_bumpmap;
    public final boolean GL_ATI_fragment_shader;
    public final boolean GL_ATI_map_object_buffer;
    public final boolean GL_ATI_meminfo;
    public final boolean GL_ATI_pn_triangles;
    public final boolean GL_ATI_separate_stencil;
    public final boolean GL_ATI_shader_texture_lod;
    public final boolean GL_ATI_text_fragment_shader;
    public final boolean GL_ATI_texture_compression_3dc;
    public final boolean GL_ATI_texture_env_combine3;
    public final boolean GL_ATI_texture_float;
    public final boolean GL_ATI_texture_mirror_once;
    public final boolean GL_ATI_vertex_array_object;
    public final boolean GL_ATI_vertex_attrib_array_object;
    public final boolean GL_ATI_vertex_streams;
    public final boolean GL_EXT_abgr;
    public final boolean GL_EXT_bgra;
    public final boolean GL_EXT_bindable_uniform;
    public final boolean GL_EXT_blend_color;
    public final boolean GL_EXT_blend_equation_separate;
    public final boolean GL_EXT_blend_func_separate;
    public final boolean GL_EXT_blend_minmax;
    public final boolean GL_EXT_blend_subtract;
    public final boolean GL_EXT_Cg_shader;
    public final boolean GL_EXT_compiled_vertex_array;
    public final boolean GL_EXT_depth_bounds_test;
    public final boolean GL_EXT_direct_state_access;
    public final boolean GL_EXT_draw_buffers2;
    public final boolean GL_EXT_draw_instanced;
    public final boolean GL_EXT_draw_range_elements;
    public final boolean GL_EXT_fog_coord;
    public final boolean GL_EXT_framebuffer_blit;
    public final boolean GL_EXT_framebuffer_multisample;
    public final boolean GL_EXT_framebuffer_object;
    public final boolean GL_EXT_framebuffer_sRGB;
    public final boolean GL_EXT_geometry_shader4;
    public final boolean GL_EXT_gpu_program_parameters;
    public final boolean GL_EXT_gpu_shader4;
    public final boolean GL_EXT_multi_draw_arrays;
    public final boolean GL_EXT_packed_depth_stencil;
    public final boolean GL_EXT_packed_float;
    public final boolean GL_EXT_packed_pixels;
    public final boolean GL_EXT_paletted_texture;
    public final boolean GL_EXT_pixel_buffer_object;
    public final boolean GL_EXT_point_parameters;
    public final boolean GL_EXT_provoking_vertex;
    public final boolean GL_EXT_rescale_normal;
    public final boolean GL_EXT_secondary_color;
    public final boolean GL_EXT_separate_shader_objects;
    public final boolean GL_EXT_separate_specular_color;
    public final boolean GL_EXT_shader_image_load_store;
    public final boolean GL_EXT_shadow_funcs;
    public final boolean GL_EXT_shared_texture_palette;
    public final boolean GL_EXT_stencil_clear_tag;
    public final boolean GL_EXT_stencil_two_side;
    public final boolean GL_EXT_stencil_wrap;
    public final boolean GL_EXT_texture_3d;
    public final boolean GL_EXT_texture_array;
    public final boolean GL_EXT_texture_buffer_object;
    public final boolean GL_EXT_texture_compression_latc;
    public final boolean GL_EXT_texture_compression_rgtc;
    public final boolean GL_EXT_texture_compression_s3tc;
    public final boolean GL_EXT_texture_env_combine;
    public final boolean GL_EXT_texture_env_dot3;
    public final boolean GL_EXT_texture_filter_anisotropic;
    public final boolean GL_EXT_texture_integer;
    public final boolean GL_EXT_texture_lod_bias;
    public final boolean GL_EXT_texture_mirror_clamp;
    public final boolean GL_EXT_texture_rectangle;
    public final boolean GL_EXT_texture_sRGB;
    public final boolean GL_EXT_texture_shared_exponent;
    public final boolean GL_EXT_texture_snorm;
    public final boolean GL_EXT_texture_swizzle;
    public final boolean GL_EXT_timer_query;
    public final boolean GL_EXT_transform_feedback;
    public final boolean GL_EXT_vertex_array_bgra;
    public final boolean GL_EXT_vertex_attrib_64bit;
    public final boolean GL_EXT_vertex_shader;
    public final boolean GL_EXT_vertex_weighting;
    public final boolean OpenGL11;
    public final boolean OpenGL12;
    public final boolean OpenGL13;
    public final boolean OpenGL14;
    public final boolean OpenGL15;
    public final boolean OpenGL20;
    public final boolean OpenGL21;
    public final boolean OpenGL30;
    public final boolean OpenGL31;
    public final boolean OpenGL32;
    public final boolean OpenGL33;
    public final boolean OpenGL40;
    public final boolean GL_GREMEDY_string_marker;
    public final boolean GL_HP_occlusion_test;
    public final boolean GL_IBM_rasterpos_clip;
    public final boolean GL_NVX_gpu_memory_info;
    public final boolean GL_NV_blend_square;
    public final boolean GL_NV_conditional_render;
    public final boolean GL_NV_copy_depth_to_color;
    public final boolean GL_NV_copy_image;
    public final boolean GL_NV_depth_buffer_float;
    public final boolean GL_NV_depth_clamp;
    public final boolean GL_NV_evaluators;
    public final boolean GL_NV_explicit_multisample;
    public final boolean GL_NV_fence;
    public final boolean GL_NV_float_buffer;
    public final boolean GL_NV_fog_distance;
    public final boolean GL_NV_fragment_program;
    public final boolean GL_NV_fragment_program2;
    public final boolean GL_NV_fragment_program4;
    public final boolean GL_NV_fragment_program_option;
    public final boolean GL_NV_framebuffer_multisample_coverage;
    public final boolean GL_NV_geometry_program4;
    public final boolean GL_NV_geometry_shader4;
    public final boolean GL_NV_gpu_program4;
    public final boolean GL_NV_gpu_program5;
    public final boolean GL_NV_gpu_shader5;
    public final boolean GL_NV_half_float;
    public final boolean GL_NV_light_max_exponent;
    public final boolean GL_NV_multisample_filter_hint;
    public final boolean GL_NV_occlusion_query;
    public final boolean GL_NV_packed_depth_stencil;
    public final boolean GL_NV_parameter_buffer_object;
    public final boolean GL_NV_parameter_buffer_object2;
    public final boolean GL_NV_pixel_data_range;
    public final boolean GL_NV_point_sprite;
    public final boolean GL_NV_primitive_restart;
    public final boolean GL_NV_register_combiners;
    public final boolean GL_NV_register_combiners2;
    public final boolean GL_NV_shader_buffer_load;
    public final boolean GL_NV_shader_buffer_store;
    public final boolean GL_NV_tessellation_program5;
    public final boolean GL_NV_texgen_reflection;
    public final boolean GL_NV_texture_barrier;
    public final boolean GL_NV_texture_compression_vtc;
    public final boolean GL_NV_texture_env_combine4;
    public final boolean GL_NV_texture_expand_normal;
    public final boolean GL_NV_texture_rectangle;
    public final boolean GL_NV_texture_shader;
    public final boolean GL_NV_texture_shader2;
    public final boolean GL_NV_texture_shader3;
    public final boolean GL_NV_transform_feedback;
    public final boolean GL_NV_transform_feedback2;
    public final boolean GL_NV_vertex_array_range;
    public final boolean GL_NV_vertex_array_range2;
    public final boolean GL_NV_vertex_attrib_integer_64bit;
    public final boolean GL_NV_vertex_buffer_unified_memory;
    public final boolean GL_NV_vertex_program;
    public final boolean GL_NV_vertex_program1_1;
    public final boolean GL_NV_vertex_program2;
    public final boolean GL_NV_vertex_program2_option;
    public final boolean GL_NV_vertex_program3;
    public final boolean GL_NV_vertex_program4;
    public final boolean GL_SGIS_generate_mipmap;
    public final boolean GL_SGIS_texture_lod;
    public final boolean GL_SUN_slice_accum;
    long AMD_draw_buffers_blend_glBlendFuncIndexedAMD_pointer;
    long AMD_draw_buffers_blend_glBlendFuncSeparateIndexedAMD_pointer;
    long AMD_draw_buffers_blend_glBlendEquationIndexedAMD_pointer;
    long AMD_draw_buffers_blend_glBlendEquationSeparateIndexedAMD_pointer;
    long AMD_performance_monitor_glGetPerfMonitorGroupsAMD_pointer;
    long AMD_performance_monitor_glGetPerfMonitorCountersAMD_pointer;
    long AMD_performance_monitor_glGetPerfMonitorGroupStringAMD_pointer;
    long AMD_performance_monitor_glGetPerfMonitorCounterStringAMD_pointer;
    long AMD_performance_monitor_glGetPerfMonitorCounterInfoAMD_pointer;
    long AMD_performance_monitor_glGenPerfMonitorsAMD_pointer;
    long AMD_performance_monitor_glDeletePerfMonitorsAMD_pointer;
    long AMD_performance_monitor_glSelectPerfMonitorCountersAMD_pointer;
    long AMD_performance_monitor_glBeginPerfMonitorAMD_pointer;
    long AMD_performance_monitor_glEndPerfMonitorAMD_pointer;
    long AMD_performance_monitor_glGetPerfMonitorCounterDataAMD_pointer;
    long AMD_vertex_shader_tessellator_glTessellationFactorAMD_pointer;
    long AMD_vertex_shader_tessellator_glTessellationModeAMD_pointer;
    long APPLE_element_array_glElementPointerAPPLE_pointer;
    long APPLE_element_array_glDrawElementArrayAPPLE_pointer;
    long APPLE_element_array_glDrawRangeElementArrayAPPLE_pointer;
    long APPLE_element_array_glMultiDrawElementArrayAPPLE_pointer;
    long APPLE_element_array_glMultiDrawRangeElementArrayAPPLE_pointer;
    long APPLE_fence_glGenFencesAPPLE_pointer;
    long APPLE_fence_glDeleteFencesAPPLE_pointer;
    long APPLE_fence_glSetFenceAPPLE_pointer;
    long APPLE_fence_glIsFenceAPPLE_pointer;
    long APPLE_fence_glTestFenceAPPLE_pointer;
    long APPLE_fence_glFinishFenceAPPLE_pointer;
    long APPLE_fence_glTestObjectAPPLE_pointer;
    long APPLE_fence_glFinishObjectAPPLE_pointer;
    long APPLE_flush_buffer_range_glBufferParameteriAPPLE_pointer;
    long APPLE_flush_buffer_range_glFlushMappedBufferRangeAPPLE_pointer;
    long APPLE_object_purgeable_glObjectPurgeableAPPLE_pointer;
    long APPLE_object_purgeable_glObjectUnpurgeableAPPLE_pointer;
    long APPLE_object_purgeable_glGetObjectParameterivAPPLE_pointer;
    long APPLE_texture_range_glTextureRangeAPPLE_pointer;
    long APPLE_texture_range_glGetTexParameterPointervAPPLE_pointer;
    long APPLE_vertex_array_object_glBindVertexArrayAPPLE_pointer;
    long APPLE_vertex_array_object_glDeleteVertexArraysAPPLE_pointer;
    long APPLE_vertex_array_object_glGenVertexArraysAPPLE_pointer;
    long APPLE_vertex_array_object_glIsVertexArrayAPPLE_pointer;
    long APPLE_vertex_array_range_glVertexArrayRangeAPPLE_pointer;
    long APPLE_vertex_array_range_glFlushVertexArrayRangeAPPLE_pointer;
    long APPLE_vertex_array_range_glVertexArrayParameteriAPPLE_pointer;
    long APPLE_vertex_program_evaluators_glEnableVertexAttribAPPLE_pointer;
    long APPLE_vertex_program_evaluators_glDisableVertexAttribAPPLE_pointer;
    long APPLE_vertex_program_evaluators_glIsVertexAttribEnabledAPPLE_pointer;
    long APPLE_vertex_program_evaluators_glMapVertexAttrib1dAPPLE_pointer;
    long APPLE_vertex_program_evaluators_glMapVertexAttrib1fAPPLE_pointer;
    long APPLE_vertex_program_evaluators_glMapVertexAttrib2dAPPLE_pointer;
    long APPLE_vertex_program_evaluators_glMapVertexAttrib2fAPPLE_pointer;
    long ARB_blend_func_extended_glBindFragDataLocationIndexed_pointer;
    long ARB_blend_func_extended_glGetFragDataIndex_pointer;
    long ARB_buffer_object_glBindBufferARB_pointer;
    long ARB_buffer_object_glDeleteBuffersARB_pointer;
    long ARB_buffer_object_glGenBuffersARB_pointer;
    long ARB_buffer_object_glIsBufferARB_pointer;
    long ARB_buffer_object_glBufferDataARB_pointer;
    long ARB_buffer_object_glBufferSubDataARB_pointer;
    long ARB_buffer_object_glGetBufferSubDataARB_pointer;
    long ARB_buffer_object_glMapBufferARB_pointer;
    long ARB_buffer_object_glUnmapBufferARB_pointer;
    long ARB_buffer_object_glGetBufferParameterivARB_pointer;
    long ARB_buffer_object_glGetBufferPointervARB_pointer;
    long ARB_color_buffer_float_glClampColorARB_pointer;
    long ARB_copy_buffer_glCopyBufferSubData_pointer;
    long ARB_draw_buffers_glDrawBuffersARB_pointer;
    long ARB_draw_buffers_blend_glBlendEquationiARB_pointer;
    long ARB_draw_buffers_blend_glBlendEquationSeparateiARB_pointer;
    long ARB_draw_buffers_blend_glBlendFunciARB_pointer;
    long ARB_draw_buffers_blend_glBlendFuncSeparateiARB_pointer;
    long ARB_draw_elements_base_vertex_glDrawElementsBaseVertex_pointer;
    long ARB_draw_elements_base_vertex_glDrawRangeElementsBaseVertex_pointer;
    long ARB_draw_elements_base_vertex_glDrawElementsInstancedBaseVertex_pointer;
    long ARB_draw_indirect_glDrawArraysIndirect_pointer;
    long ARB_draw_indirect_glDrawElementsIndirect_pointer;
    long ARB_draw_instanced_glDrawArraysInstancedARB_pointer;
    long ARB_draw_instanced_glDrawElementsInstancedARB_pointer;
    long ARB_framebuffer_object_glIsRenderbuffer_pointer;
    long ARB_framebuffer_object_glBindRenderbuffer_pointer;
    long ARB_framebuffer_object_glDeleteRenderbuffers_pointer;
    long ARB_framebuffer_object_glGenRenderbuffers_pointer;
    long ARB_framebuffer_object_glRenderbufferStorage_pointer;
    long ARB_framebuffer_object_glRenderbufferStorageMultisample_pointer;
    long ARB_framebuffer_object_glGetRenderbufferParameteriv_pointer;
    long ARB_framebuffer_object_glIsFramebuffer_pointer;
    long ARB_framebuffer_object_glBindFramebuffer_pointer;
    long ARB_framebuffer_object_glDeleteFramebuffers_pointer;
    long ARB_framebuffer_object_glGenFramebuffers_pointer;
    long ARB_framebuffer_object_glCheckFramebufferStatus_pointer;
    long ARB_framebuffer_object_glFramebufferTexture1D_pointer;
    long ARB_framebuffer_object_glFramebufferTexture2D_pointer;
    long ARB_framebuffer_object_glFramebufferTexture3D_pointer;
    long ARB_framebuffer_object_glFramebufferTextureLayer_pointer;
    long ARB_framebuffer_object_glFramebufferRenderbuffer_pointer;
    long ARB_framebuffer_object_glGetFramebufferAttachmentParameteriv_pointer;
    long ARB_framebuffer_object_glBlitFramebuffer_pointer;
    long ARB_framebuffer_object_glGenerateMipmap_pointer;
    long ARB_geometry_shader4_glProgramParameteriARB_pointer;
    long ARB_geometry_shader4_glFramebufferTextureARB_pointer;
    long ARB_geometry_shader4_glFramebufferTextureLayerARB_pointer;
    long ARB_geometry_shader4_glFramebufferTextureFaceARB_pointer;
    long ARB_gpu_shader_fp64_glUniform1d_pointer;
    long ARB_gpu_shader_fp64_glUniform2d_pointer;
    long ARB_gpu_shader_fp64_glUniform3d_pointer;
    long ARB_gpu_shader_fp64_glUniform4d_pointer;
    long ARB_gpu_shader_fp64_glUniform1dv_pointer;
    long ARB_gpu_shader_fp64_glUniform2dv_pointer;
    long ARB_gpu_shader_fp64_glUniform3dv_pointer;
    long ARB_gpu_shader_fp64_glUniform4dv_pointer;
    long ARB_gpu_shader_fp64_glUniformMatrix2dv_pointer;
    long ARB_gpu_shader_fp64_glUniformMatrix3dv_pointer;
    long ARB_gpu_shader_fp64_glUniformMatrix4dv_pointer;
    long ARB_gpu_shader_fp64_glUniformMatrix2x3dv_pointer;
    long ARB_gpu_shader_fp64_glUniformMatrix2x4dv_pointer;
    long ARB_gpu_shader_fp64_glUniformMatrix3x2dv_pointer;
    long ARB_gpu_shader_fp64_glUniformMatrix3x4dv_pointer;
    long ARB_gpu_shader_fp64_glUniformMatrix4x2dv_pointer;
    long ARB_gpu_shader_fp64_glUniformMatrix4x3dv_pointer;
    long ARB_gpu_shader_fp64_glGetUniformdv_pointer;
    long ARB_gpu_shader_fp64_glProgramUniform1dEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniform2dEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniform3dEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniform4dEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniform1dvEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniform2dvEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniform3dvEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniform4dvEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniformMatrix2dvEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniformMatrix3dvEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniformMatrix4dvEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniformMatrix2x3dvEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniformMatrix2x4dvEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniformMatrix3x2dvEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniformMatrix3x4dvEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniformMatrix4x2dvEXT_pointer;
    long ARB_gpu_shader_fp64_glProgramUniformMatrix4x3dvEXT_pointer;
    long ARB_imaging_glColorTable_pointer;
    long ARB_imaging_glColorSubTable_pointer;
    long ARB_imaging_glColorTableParameteriv_pointer;
    long ARB_imaging_glColorTableParameterfv_pointer;
    long ARB_imaging_glCopyColorSubTable_pointer;
    long ARB_imaging_glCopyColorTable_pointer;
    long ARB_imaging_glGetColorTable_pointer;
    long ARB_imaging_glGetColorTableParameteriv_pointer;
    long ARB_imaging_glGetColorTableParameterfv_pointer;
    long ARB_imaging_glBlendEquation_pointer;
    long ARB_imaging_glBlendColor_pointer;
    long ARB_imaging_glHistogram_pointer;
    long ARB_imaging_glResetHistogram_pointer;
    long ARB_imaging_glGetHistogram_pointer;
    long ARB_imaging_glGetHistogramParameterfv_pointer;
    long ARB_imaging_glGetHistogramParameteriv_pointer;
    long ARB_imaging_glMinmax_pointer;
    long ARB_imaging_glResetMinmax_pointer;
    long ARB_imaging_glGetMinmax_pointer;
    long ARB_imaging_glGetMinmaxParameterfv_pointer;
    long ARB_imaging_glGetMinmaxParameteriv_pointer;
    long ARB_imaging_glConvolutionFilter1D_pointer;
    long ARB_imaging_glConvolutionFilter2D_pointer;
    long ARB_imaging_glConvolutionParameterf_pointer;
    long ARB_imaging_glConvolutionParameterfv_pointer;
    long ARB_imaging_glConvolutionParameteri_pointer;
    long ARB_imaging_glConvolutionParameteriv_pointer;
    long ARB_imaging_glCopyConvolutionFilter1D_pointer;
    long ARB_imaging_glCopyConvolutionFilter2D_pointer;
    long ARB_imaging_glGetConvolutionFilter_pointer;
    long ARB_imaging_glGetConvolutionParameterfv_pointer;
    long ARB_imaging_glGetConvolutionParameteriv_pointer;
    long ARB_imaging_glSeparableFilter2D_pointer;
    long ARB_imaging_glGetSeparableFilter_pointer;
    long ARB_instanced_arrays_glVertexAttribDivisorARB_pointer;
    long ARB_map_buffer_range_glMapBufferRange_pointer;
    long ARB_map_buffer_range_glFlushMappedBufferRange_pointer;
    long ARB_matrix_palette_glCurrentPaletteMatrixARB_pointer;
    long ARB_matrix_palette_glMatrixIndexPointerARB_pointer;
    long ARB_matrix_palette_glMatrixIndexubvARB_pointer;
    long ARB_matrix_palette_glMatrixIndexusvARB_pointer;
    long ARB_matrix_palette_glMatrixIndexuivARB_pointer;
    long ARB_multisample_glSampleCoverageARB_pointer;
    long ARB_multitexture_glClientActiveTextureARB_pointer;
    long ARB_multitexture_glActiveTextureARB_pointer;
    long ARB_multitexture_glMultiTexCoord1fARB_pointer;
    long ARB_multitexture_glMultiTexCoord1dARB_pointer;
    long ARB_multitexture_glMultiTexCoord1iARB_pointer;
    long ARB_multitexture_glMultiTexCoord1sARB_pointer;
    long ARB_multitexture_glMultiTexCoord2fARB_pointer;
    long ARB_multitexture_glMultiTexCoord2dARB_pointer;
    long ARB_multitexture_glMultiTexCoord2iARB_pointer;
    long ARB_multitexture_glMultiTexCoord2sARB_pointer;
    long ARB_multitexture_glMultiTexCoord3fARB_pointer;
    long ARB_multitexture_glMultiTexCoord3dARB_pointer;
    long ARB_multitexture_glMultiTexCoord3iARB_pointer;
    long ARB_multitexture_glMultiTexCoord3sARB_pointer;
    long ARB_multitexture_glMultiTexCoord4fARB_pointer;
    long ARB_multitexture_glMultiTexCoord4dARB_pointer;
    long ARB_multitexture_glMultiTexCoord4iARB_pointer;
    long ARB_multitexture_glMultiTexCoord4sARB_pointer;
    long ARB_occlusion_query_glGenQueriesARB_pointer;
    long ARB_occlusion_query_glDeleteQueriesARB_pointer;
    long ARB_occlusion_query_glIsQueryARB_pointer;
    long ARB_occlusion_query_glBeginQueryARB_pointer;
    long ARB_occlusion_query_glEndQueryARB_pointer;
    long ARB_occlusion_query_glGetQueryivARB_pointer;
    long ARB_occlusion_query_glGetQueryObjectivARB_pointer;
    long ARB_occlusion_query_glGetQueryObjectuivARB_pointer;
    long ARB_point_parameters_glPointParameterfARB_pointer;
    long ARB_point_parameters_glPointParameterfvARB_pointer;
    long ARB_program_glProgramStringARB_pointer;
    long ARB_program_glBindProgramARB_pointer;
    long ARB_program_glDeleteProgramsARB_pointer;
    long ARB_program_glGenProgramsARB_pointer;
    long ARB_program_glProgramEnvParameter4fARB_pointer;
    long ARB_program_glProgramEnvParameter4dARB_pointer;
    long ARB_program_glProgramEnvParameter4fvARB_pointer;
    long ARB_program_glProgramEnvParameter4dvARB_pointer;
    long ARB_program_glProgramLocalParameter4fARB_pointer;
    long ARB_program_glProgramLocalParameter4dARB_pointer;
    long ARB_program_glProgramLocalParameter4fvARB_pointer;
    long ARB_program_glProgramLocalParameter4dvARB_pointer;
    long ARB_program_glGetProgramEnvParameterfvARB_pointer;
    long ARB_program_glGetProgramEnvParameterdvARB_pointer;
    long ARB_program_glGetProgramLocalParameterfvARB_pointer;
    long ARB_program_glGetProgramLocalParameterdvARB_pointer;
    long ARB_program_glGetProgramivARB_pointer;
    long ARB_program_glGetProgramStringARB_pointer;
    long ARB_program_glIsProgramARB_pointer;
    long ARB_provoking_vertex_glProvokingVertex_pointer;
    long ARB_sample_shading_glMinSampleShadingARB_pointer;
    long ARB_sampler_objects_glGenSamplers_pointer;
    long ARB_sampler_objects_glDeleteSamplers_pointer;
    long ARB_sampler_objects_glIsSampler_pointer;
    long ARB_sampler_objects_glBindSampler_pointer;
    long ARB_sampler_objects_glSamplerParameteri_pointer;
    long ARB_sampler_objects_glSamplerParameterf_pointer;
    long ARB_sampler_objects_glSamplerParameteriv_pointer;
    long ARB_sampler_objects_glSamplerParameterfv_pointer;
    long ARB_sampler_objects_glSamplerParameterIiv_pointer;
    long ARB_sampler_objects_glSamplerParameterIuiv_pointer;
    long ARB_sampler_objects_glGetSamplerParameteriv_pointer;
    long ARB_sampler_objects_glGetSamplerParameterfv_pointer;
    long ARB_sampler_objects_glGetSamplerParameterIiv_pointer;
    long ARB_sampler_objects_glGetSamplerParameterIuiv_pointer;
    long ARB_shader_objects_glDeleteObjectARB_pointer;
    long ARB_shader_objects_glGetHandleARB_pointer;
    long ARB_shader_objects_glDetachObjectARB_pointer;
    long ARB_shader_objects_glCreateShaderObjectARB_pointer;
    long ARB_shader_objects_glShaderSourceARB_pointer;
    long ARB_shader_objects_glCompileShaderARB_pointer;
    long ARB_shader_objects_glCreateProgramObjectARB_pointer;
    long ARB_shader_objects_glAttachObjectARB_pointer;
    long ARB_shader_objects_glLinkProgramARB_pointer;
    long ARB_shader_objects_glUseProgramObjectARB_pointer;
    long ARB_shader_objects_glValidateProgramARB_pointer;
    long ARB_shader_objects_glUniform1fARB_pointer;
    long ARB_shader_objects_glUniform2fARB_pointer;
    long ARB_shader_objects_glUniform3fARB_pointer;
    long ARB_shader_objects_glUniform4fARB_pointer;
    long ARB_shader_objects_glUniform1iARB_pointer;
    long ARB_shader_objects_glUniform2iARB_pointer;
    long ARB_shader_objects_glUniform3iARB_pointer;
    long ARB_shader_objects_glUniform4iARB_pointer;
    long ARB_shader_objects_glUniform1fvARB_pointer;
    long ARB_shader_objects_glUniform2fvARB_pointer;
    long ARB_shader_objects_glUniform3fvARB_pointer;
    long ARB_shader_objects_glUniform4fvARB_pointer;
    long ARB_shader_objects_glUniform1ivARB_pointer;
    long ARB_shader_objects_glUniform2ivARB_pointer;
    long ARB_shader_objects_glUniform3ivARB_pointer;
    long ARB_shader_objects_glUniform4ivARB_pointer;
    long ARB_shader_objects_glUniformMatrix2fvARB_pointer;
    long ARB_shader_objects_glUniformMatrix3fvARB_pointer;
    long ARB_shader_objects_glUniformMatrix4fvARB_pointer;
    long ARB_shader_objects_glGetObjectParameterfvARB_pointer;
    long ARB_shader_objects_glGetObjectParameterivARB_pointer;
    long ARB_shader_objects_glGetInfoLogARB_pointer;
    long ARB_shader_objects_glGetAttachedObjectsARB_pointer;
    long ARB_shader_objects_glGetUniformLocationARB_pointer;
    long ARB_shader_objects_glGetActiveUniformARB_pointer;
    long ARB_shader_objects_glGetUniformfvARB_pointer;
    long ARB_shader_objects_glGetUniformivARB_pointer;
    long ARB_shader_objects_glGetShaderSourceARB_pointer;
    long ARB_shader_subroutine_glGetSubroutineUniformLocation_pointer;
    long ARB_shader_subroutine_glGetSubroutineIndex_pointer;
    long ARB_shader_subroutine_glGetActiveSubroutineUniformiv_pointer;
    long ARB_shader_subroutine_glGetActiveSubroutineUniformName_pointer;
    long ARB_shader_subroutine_glGetActiveSubroutineName_pointer;
    long ARB_shader_subroutine_glUniformSubroutinesuiv_pointer;
    long ARB_shader_subroutine_glGetUniformSubroutineuiv_pointer;
    long ARB_shader_subroutine_glGetProgramStageiv_pointer;
    long ARB_shading_language_include_glNamedStringARB_pointer;
    long ARB_shading_language_include_glDeleteNamedStringARB_pointer;
    long ARB_shading_language_include_glCompileShaderIncludeARB_pointer;
    long ARB_shading_language_include_glIsNamedStringARB_pointer;
    long ARB_shading_language_include_glGetNamedStringARB_pointer;
    long ARB_shading_language_include_glGetNamedStringivARB_pointer;
    long ARB_sync_glFenceSync_pointer;
    long ARB_sync_glIsSync_pointer;
    long ARB_sync_glDeleteSync_pointer;
    long ARB_sync_glClientWaitSync_pointer;
    long ARB_sync_glWaitSync_pointer;
    long ARB_sync_glGetInteger64v_pointer;
    long ARB_sync_glGetSynciv_pointer;
    long ARB_tessellation_shader_glPatchParameteri_pointer;
    long ARB_tessellation_shader_glPatchParameterfv_pointer;
    long ARB_texture_buffer_object_glTexBufferARB_pointer;
    long ARB_texture_compression_glCompressedTexImage1DARB_pointer;
    long ARB_texture_compression_glCompressedTexImage2DARB_pointer;
    long ARB_texture_compression_glCompressedTexImage3DARB_pointer;
    long ARB_texture_compression_glCompressedTexSubImage1DARB_pointer;
    long ARB_texture_compression_glCompressedTexSubImage2DARB_pointer;
    long ARB_texture_compression_glCompressedTexSubImage3DARB_pointer;
    long ARB_texture_compression_glGetCompressedTexImageARB_pointer;
    long ARB_texture_multisample_glTexImage2DMultisample_pointer;
    long ARB_texture_multisample_glTexImage3DMultisample_pointer;
    long ARB_texture_multisample_glGetMultisamplefv_pointer;
    long ARB_texture_multisample_glSampleMaski_pointer;
    long ARB_timer_query_glQueryCounter_pointer;
    long ARB_timer_query_glGetQueryObjecti64v_pointer;
    long ARB_timer_query_glGetQueryObjectui64v_pointer;
    long ARB_transform_feedback2_glBindTransformFeedback_pointer;
    long ARB_transform_feedback2_glDeleteTransformFeedbacks_pointer;
    long ARB_transform_feedback2_glGenTransformFeedbacks_pointer;
    long ARB_transform_feedback2_glIsTransformFeedback_pointer;
    long ARB_transform_feedback2_glPauseTransformFeedback_pointer;
    long ARB_transform_feedback2_glResumeTransformFeedback_pointer;
    long ARB_transform_feedback2_glDrawTransformFeedback_pointer;
    long ARB_transform_feedback3_glDrawTransformFeedbackStream_pointer;
    long ARB_transform_feedback3_glBeginQueryIndexed_pointer;
    long ARB_transform_feedback3_glEndQueryIndexed_pointer;
    long ARB_transform_feedback3_glGetQueryIndexediv_pointer;
    long ARB_transpose_matrix_glLoadTransposeMatrixfARB_pointer;
    long ARB_transpose_matrix_glMultTransposeMatrixfARB_pointer;
    long ARB_uniform_buffer_object_glGetUniformIndices_pointer;
    long ARB_uniform_buffer_object_glGetActiveUniformsiv_pointer;
    long ARB_uniform_buffer_object_glGetActiveUniformName_pointer;
    long ARB_uniform_buffer_object_glGetUniformBlockIndex_pointer;
    long ARB_uniform_buffer_object_glGetActiveUniformBlockiv_pointer;
    long ARB_uniform_buffer_object_glGetActiveUniformBlockName_pointer;
    long ARB_uniform_buffer_object_glBindBufferRange_pointer;
    long ARB_uniform_buffer_object_glBindBufferBase_pointer;
    long ARB_uniform_buffer_object_glGetIntegeri_v_pointer;
    long ARB_uniform_buffer_object_glUniformBlockBinding_pointer;
    long ARB_vertex_array_object_glBindVertexArray_pointer;
    long ARB_vertex_array_object_glDeleteVertexArrays_pointer;
    long ARB_vertex_array_object_glGenVertexArrays_pointer;
    long ARB_vertex_array_object_glIsVertexArray_pointer;
    long ARB_vertex_blend_glWeightbvARB_pointer;
    long ARB_vertex_blend_glWeightsvARB_pointer;
    long ARB_vertex_blend_glWeightivARB_pointer;
    long ARB_vertex_blend_glWeightfvARB_pointer;
    long ARB_vertex_blend_glWeightdvARB_pointer;
    long ARB_vertex_blend_glWeightubvARB_pointer;
    long ARB_vertex_blend_glWeightusvARB_pointer;
    long ARB_vertex_blend_glWeightuivARB_pointer;
    long ARB_vertex_blend_glWeightPointerARB_pointer;
    long ARB_vertex_blend_glVertexBlendARB_pointer;
    long ARB_vertex_program_glVertexAttrib1sARB_pointer;
    long ARB_vertex_program_glVertexAttrib1fARB_pointer;
    long ARB_vertex_program_glVertexAttrib1dARB_pointer;
    long ARB_vertex_program_glVertexAttrib2sARB_pointer;
    long ARB_vertex_program_glVertexAttrib2fARB_pointer;
    long ARB_vertex_program_glVertexAttrib2dARB_pointer;
    long ARB_vertex_program_glVertexAttrib3sARB_pointer;
    long ARB_vertex_program_glVertexAttrib3fARB_pointer;
    long ARB_vertex_program_glVertexAttrib3dARB_pointer;
    long ARB_vertex_program_glVertexAttrib4sARB_pointer;
    long ARB_vertex_program_glVertexAttrib4fARB_pointer;
    long ARB_vertex_program_glVertexAttrib4dARB_pointer;
    long ARB_vertex_program_glVertexAttrib4NubARB_pointer;
    long ARB_vertex_program_glVertexAttribPointerARB_pointer;
    long ARB_vertex_program_glEnableVertexAttribArrayARB_pointer;
    long ARB_vertex_program_glDisableVertexAttribArrayARB_pointer;
    long ARB_vertex_program_glGetVertexAttribfvARB_pointer;
    long ARB_vertex_program_glGetVertexAttribdvARB_pointer;
    long ARB_vertex_program_glGetVertexAttribivARB_pointer;
    long ARB_vertex_program_glGetVertexAttribPointervARB_pointer;
    long ARB_vertex_shader_glVertexAttrib1sARB_pointer;
    long ARB_vertex_shader_glVertexAttrib1fARB_pointer;
    long ARB_vertex_shader_glVertexAttrib1dARB_pointer;
    long ARB_vertex_shader_glVertexAttrib2sARB_pointer;
    long ARB_vertex_shader_glVertexAttrib2fARB_pointer;
    long ARB_vertex_shader_glVertexAttrib2dARB_pointer;
    long ARB_vertex_shader_glVertexAttrib3sARB_pointer;
    long ARB_vertex_shader_glVertexAttrib3fARB_pointer;
    long ARB_vertex_shader_glVertexAttrib3dARB_pointer;
    long ARB_vertex_shader_glVertexAttrib4sARB_pointer;
    long ARB_vertex_shader_glVertexAttrib4fARB_pointer;
    long ARB_vertex_shader_glVertexAttrib4dARB_pointer;
    long ARB_vertex_shader_glVertexAttrib4NubARB_pointer;
    long ARB_vertex_shader_glVertexAttribPointerARB_pointer;
    long ARB_vertex_shader_glEnableVertexAttribArrayARB_pointer;
    long ARB_vertex_shader_glDisableVertexAttribArrayARB_pointer;
    long ARB_vertex_shader_glBindAttribLocationARB_pointer;
    long ARB_vertex_shader_glGetActiveAttribARB_pointer;
    long ARB_vertex_shader_glGetAttribLocationARB_pointer;
    long ARB_vertex_shader_glGetVertexAttribfvARB_pointer;
    long ARB_vertex_shader_glGetVertexAttribdvARB_pointer;
    long ARB_vertex_shader_glGetVertexAttribivARB_pointer;
    long ARB_vertex_shader_glGetVertexAttribPointervARB_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glVertexP2ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glVertexP3ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glVertexP4ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glVertexP2uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glVertexP3uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glVertexP4uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glTexCoordP1ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glTexCoordP2ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glTexCoordP3ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glTexCoordP4ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glTexCoordP1uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glTexCoordP2uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glTexCoordP3uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glTexCoordP4uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP1ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP2ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP3ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP4ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP1uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP2uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP3uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP4uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glNormalP3ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glNormalP3uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glColorP3ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glColorP4ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glColorP3uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glColorP4uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glSecondaryColorP3ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glSecondaryColorP3uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glVertexAttribP1ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glVertexAttribP2ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glVertexAttribP3ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glVertexAttribP4ui_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glVertexAttribP1uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glVertexAttribP2uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glVertexAttribP3uiv_pointer;
    long ARB_vertex_type_2_10_10_10_rev_glVertexAttribP4uiv_pointer;
    long ARB_window_pos_glWindowPos2fARB_pointer;
    long ARB_window_pos_glWindowPos2dARB_pointer;
    long ARB_window_pos_glWindowPos2iARB_pointer;
    long ARB_window_pos_glWindowPos2sARB_pointer;
    long ARB_window_pos_glWindowPos3fARB_pointer;
    long ARB_window_pos_glWindowPos3dARB_pointer;
    long ARB_window_pos_glWindowPos3iARB_pointer;
    long ARB_window_pos_glWindowPos3sARB_pointer;
    long ATI_draw_buffers_glDrawBuffersATI_pointer;
    long ATI_element_array_glElementPointerATI_pointer;
    long ATI_element_array_glDrawElementArrayATI_pointer;
    long ATI_element_array_glDrawRangeElementArrayATI_pointer;
    long ATI_envmap_bumpmap_glTexBumpParameterfvATI_pointer;
    long ATI_envmap_bumpmap_glTexBumpParameterivATI_pointer;
    long ATI_envmap_bumpmap_glGetTexBumpParameterfvATI_pointer;
    long ATI_envmap_bumpmap_glGetTexBumpParameterivATI_pointer;
    long ATI_fragment_shader_glGenFragmentShadersATI_pointer;
    long ATI_fragment_shader_glBindFragmentShaderATI_pointer;
    long ATI_fragment_shader_glDeleteFragmentShaderATI_pointer;
    long ATI_fragment_shader_glBeginFragmentShaderATI_pointer;
    long ATI_fragment_shader_glEndFragmentShaderATI_pointer;
    long ATI_fragment_shader_glPassTexCoordATI_pointer;
    long ATI_fragment_shader_glSampleMapATI_pointer;
    long ATI_fragment_shader_glColorFragmentOp1ATI_pointer;
    long ATI_fragment_shader_glColorFragmentOp2ATI_pointer;
    long ATI_fragment_shader_glColorFragmentOp3ATI_pointer;
    long ATI_fragment_shader_glAlphaFragmentOp1ATI_pointer;
    long ATI_fragment_shader_glAlphaFragmentOp2ATI_pointer;
    long ATI_fragment_shader_glAlphaFragmentOp3ATI_pointer;
    long ATI_fragment_shader_glSetFragmentShaderConstantATI_pointer;
    long ATI_map_object_buffer_glMapObjectBufferATI_pointer;
    long ATI_map_object_buffer_glUnmapObjectBufferATI_pointer;
    long ATI_pn_triangles_glPNTrianglesfATI_pointer;
    long ATI_pn_triangles_glPNTrianglesiATI_pointer;
    long ATI_separate_stencil_glStencilOpSeparateATI_pointer;
    long ATI_separate_stencil_glStencilFuncSeparateATI_pointer;
    long ATI_vertex_array_object_glNewObjectBufferATI_pointer;
    long ATI_vertex_array_object_glIsObjectBufferATI_pointer;
    long ATI_vertex_array_object_glUpdateObjectBufferATI_pointer;
    long ATI_vertex_array_object_glGetObjectBufferfvATI_pointer;
    long ATI_vertex_array_object_glGetObjectBufferivATI_pointer;
    long ATI_vertex_array_object_glFreeObjectBufferATI_pointer;
    long ATI_vertex_array_object_glArrayObjectATI_pointer;
    long ATI_vertex_array_object_glGetArrayObjectfvATI_pointer;
    long ATI_vertex_array_object_glGetArrayObjectivATI_pointer;
    long ATI_vertex_array_object_glVariantArrayObjectATI_pointer;
    long ATI_vertex_array_object_glGetVariantArrayObjectfvATI_pointer;
    long ATI_vertex_array_object_glGetVariantArrayObjectivATI_pointer;
    long ATI_vertex_attrib_array_object_glVertexAttribArrayObjectATI_pointer;
    long ATI_vertex_attrib_array_object_glGetVertexAttribArrayObjectfvATI_pointer;
    long ATI_vertex_attrib_array_object_glGetVertexAttribArrayObjectivATI_pointer;
    long ATI_vertex_streams_glVertexStream2fATI_pointer;
    long ATI_vertex_streams_glVertexStream2dATI_pointer;
    long ATI_vertex_streams_glVertexStream2iATI_pointer;
    long ATI_vertex_streams_glVertexStream2sATI_pointer;
    long ATI_vertex_streams_glVertexStream3fATI_pointer;
    long ATI_vertex_streams_glVertexStream3dATI_pointer;
    long ATI_vertex_streams_glVertexStream3iATI_pointer;
    long ATI_vertex_streams_glVertexStream3sATI_pointer;
    long ATI_vertex_streams_glVertexStream4fATI_pointer;
    long ATI_vertex_streams_glVertexStream4dATI_pointer;
    long ATI_vertex_streams_glVertexStream4iATI_pointer;
    long ATI_vertex_streams_glVertexStream4sATI_pointer;
    long ATI_vertex_streams_glNormalStream3bATI_pointer;
    long ATI_vertex_streams_glNormalStream3fATI_pointer;
    long ATI_vertex_streams_glNormalStream3dATI_pointer;
    long ATI_vertex_streams_glNormalStream3iATI_pointer;
    long ATI_vertex_streams_glNormalStream3sATI_pointer;
    long ATI_vertex_streams_glClientActiveVertexStreamATI_pointer;
    long ATI_vertex_streams_glVertexBlendEnvfATI_pointer;
    long ATI_vertex_streams_glVertexBlendEnviATI_pointer;
    long EXT_bindable_uniform_glUniformBufferEXT_pointer;
    long EXT_bindable_uniform_glGetUniformBufferSizeEXT_pointer;
    long EXT_bindable_uniform_glGetUniformOffsetEXT_pointer;
    long EXT_blend_color_glBlendColorEXT_pointer;
    long EXT_blend_equation_separate_glBlendEquationSeparateEXT_pointer;
    long EXT_blend_func_separate_glBlendFuncSeparateEXT_pointer;
    long EXT_blend_minmax_glBlendEquationEXT_pointer;
    long EXT_compiled_vertex_array_glLockArraysEXT_pointer;
    long EXT_compiled_vertex_array_glUnlockArraysEXT_pointer;
    long EXT_depth_bounds_test_glDepthBoundsEXT_pointer;
    long EXT_direct_state_access_glClientAttribDefaultEXT_pointer;
    long EXT_direct_state_access_glPushClientAttribDefaultEXT_pointer;
    long EXT_direct_state_access_glMatrixLoadfEXT_pointer;
    long EXT_direct_state_access_glMatrixLoaddEXT_pointer;
    long EXT_direct_state_access_glMatrixMultfEXT_pointer;
    long EXT_direct_state_access_glMatrixMultdEXT_pointer;
    long EXT_direct_state_access_glMatrixLoadIdentityEXT_pointer;
    long EXT_direct_state_access_glMatrixRotatefEXT_pointer;
    long EXT_direct_state_access_glMatrixRotatedEXT_pointer;
    long EXT_direct_state_access_glMatrixScalefEXT_pointer;
    long EXT_direct_state_access_glMatrixScaledEXT_pointer;
    long EXT_direct_state_access_glMatrixTranslatefEXT_pointer;
    long EXT_direct_state_access_glMatrixTranslatedEXT_pointer;
    long EXT_direct_state_access_glMatrixOrthoEXT_pointer;
    long EXT_direct_state_access_glMatrixFrustumEXT_pointer;
    long EXT_direct_state_access_glMatrixPushEXT_pointer;
    long EXT_direct_state_access_glMatrixPopEXT_pointer;
    long EXT_direct_state_access_glTextureParameteriEXT_pointer;
    long EXT_direct_state_access_glTextureParameterivEXT_pointer;
    long EXT_direct_state_access_glTextureParameterfEXT_pointer;
    long EXT_direct_state_access_glTextureParameterfvEXT_pointer;
    long EXT_direct_state_access_glTextureImage1DEXT_pointer;
    long EXT_direct_state_access_glTextureImage2DEXT_pointer;
    long EXT_direct_state_access_glTextureSubImage1DEXT_pointer;
    long EXT_direct_state_access_glTextureSubImage2DEXT_pointer;
    long EXT_direct_state_access_glCopyTextureImage1DEXT_pointer;
    long EXT_direct_state_access_glCopyTextureImage2DEXT_pointer;
    long EXT_direct_state_access_glCopyTextureSubImage1DEXT_pointer;
    long EXT_direct_state_access_glCopyTextureSubImage2DEXT_pointer;
    long EXT_direct_state_access_glGetTextureImageEXT_pointer;
    long EXT_direct_state_access_glGetTextureParameterfvEXT_pointer;
    long EXT_direct_state_access_glGetTextureParameterivEXT_pointer;
    long EXT_direct_state_access_glGetTextureLevelParameterfvEXT_pointer;
    long EXT_direct_state_access_glGetTextureLevelParameterivEXT_pointer;
    long EXT_direct_state_access_glTextureImage3DEXT_pointer;
    long EXT_direct_state_access_glTextureSubImage3DEXT_pointer;
    long EXT_direct_state_access_glCopyTextureSubImage3DEXT_pointer;
    long EXT_direct_state_access_glBindMultiTextureEXT_pointer;
    long EXT_direct_state_access_glMultiTexCoordPointerEXT_pointer;
    long EXT_direct_state_access_glMultiTexEnvfEXT_pointer;
    long EXT_direct_state_access_glMultiTexEnvfvEXT_pointer;
    long EXT_direct_state_access_glMultiTexEnviEXT_pointer;
    long EXT_direct_state_access_glMultiTexEnvivEXT_pointer;
    long EXT_direct_state_access_glMultiTexGendEXT_pointer;
    long EXT_direct_state_access_glMultiTexGendvEXT_pointer;
    long EXT_direct_state_access_glMultiTexGenfEXT_pointer;
    long EXT_direct_state_access_glMultiTexGenfvEXT_pointer;
    long EXT_direct_state_access_glMultiTexGeniEXT_pointer;
    long EXT_direct_state_access_glMultiTexGenivEXT_pointer;
    long EXT_direct_state_access_glGetMultiTexEnvfvEXT_pointer;
    long EXT_direct_state_access_glGetMultiTexEnvivEXT_pointer;
    long EXT_direct_state_access_glGetMultiTexGendvEXT_pointer;
    long EXT_direct_state_access_glGetMultiTexGenfvEXT_pointer;
    long EXT_direct_state_access_glGetMultiTexGenivEXT_pointer;
    long EXT_direct_state_access_glMultiTexParameteriEXT_pointer;
    long EXT_direct_state_access_glMultiTexParameterivEXT_pointer;
    long EXT_direct_state_access_glMultiTexParameterfEXT_pointer;
    long EXT_direct_state_access_glMultiTexParameterfvEXT_pointer;
    long EXT_direct_state_access_glMultiTexImage1DEXT_pointer;
    long EXT_direct_state_access_glMultiTexImage2DEXT_pointer;
    long EXT_direct_state_access_glMultiTexSubImage1DEXT_pointer;
    long EXT_direct_state_access_glMultiTexSubImage2DEXT_pointer;
    long EXT_direct_state_access_glCopyMultiTexImage1DEXT_pointer;
    long EXT_direct_state_access_glCopyMultiTexImage2DEXT_pointer;
    long EXT_direct_state_access_glCopyMultiTexSubImage1DEXT_pointer;
    long EXT_direct_state_access_glCopyMultiTexSubImage2DEXT_pointer;
    long EXT_direct_state_access_glGetMultiTexImageEXT_pointer;
    long EXT_direct_state_access_glGetMultiTexParameterfvEXT_pointer;
    long EXT_direct_state_access_glGetMultiTexParameterivEXT_pointer;
    long EXT_direct_state_access_glGetMultiTexLevelParameterfvEXT_pointer;
    long EXT_direct_state_access_glGetMultiTexLevelParameterivEXT_pointer;
    long EXT_direct_state_access_glMultiTexImage3DEXT_pointer;
    long EXT_direct_state_access_glMultiTexSubImage3DEXT_pointer;
    long EXT_direct_state_access_glCopyMultiTexSubImage3DEXT_pointer;
    long EXT_direct_state_access_glEnableClientStateIndexedEXT_pointer;
    long EXT_direct_state_access_glDisableClientStateIndexedEXT_pointer;
    long EXT_direct_state_access_glEnableClientStateiEXT_pointer;
    long EXT_direct_state_access_glDisableClientStateiEXT_pointer;
    long EXT_direct_state_access_glGetFloatIndexedvEXT_pointer;
    long EXT_direct_state_access_glGetDoubleIndexedvEXT_pointer;
    long EXT_direct_state_access_glGetPointerIndexedvEXT_pointer;
    long EXT_direct_state_access_glGetFloati_vEXT_pointer;
    long EXT_direct_state_access_glGetDoublei_vEXT_pointer;
    long EXT_direct_state_access_glGetPointeri_vEXT_pointer;
    long EXT_direct_state_access_glEnableIndexedEXT_pointer;
    long EXT_direct_state_access_glDisableIndexedEXT_pointer;
    long EXT_direct_state_access_glIsEnabledIndexedEXT_pointer;
    long EXT_direct_state_access_glGetIntegerIndexedvEXT_pointer;
    long EXT_direct_state_access_glGetBooleanIndexedvEXT_pointer;
    long EXT_direct_state_access_glNamedProgramStringEXT_pointer;
    long EXT_direct_state_access_glNamedProgramLocalParameter4dEXT_pointer;
    long EXT_direct_state_access_glNamedProgramLocalParameter4dvEXT_pointer;
    long EXT_direct_state_access_glNamedProgramLocalParameter4fEXT_pointer;
    long EXT_direct_state_access_glNamedProgramLocalParameter4fvEXT_pointer;
    long EXT_direct_state_access_glGetNamedProgramLocalParameterdvEXT_pointer;
    long EXT_direct_state_access_glGetNamedProgramLocalParameterfvEXT_pointer;
    long EXT_direct_state_access_glGetNamedProgramivEXT_pointer;
    long EXT_direct_state_access_glGetNamedProgramStringEXT_pointer;
    long EXT_direct_state_access_glCompressedTextureImage3DEXT_pointer;
    long EXT_direct_state_access_glCompressedTextureImage2DEXT_pointer;
    long EXT_direct_state_access_glCompressedTextureImage1DEXT_pointer;
    long EXT_direct_state_access_glCompressedTextureSubImage3DEXT_pointer;
    long EXT_direct_state_access_glCompressedTextureSubImage2DEXT_pointer;
    long EXT_direct_state_access_glCompressedTextureSubImage1DEXT_pointer;
    long EXT_direct_state_access_glGetCompressedTextureImageEXT_pointer;
    long EXT_direct_state_access_glCompressedMultiTexImage3DEXT_pointer;
    long EXT_direct_state_access_glCompressedMultiTexImage2DEXT_pointer;
    long EXT_direct_state_access_glCompressedMultiTexImage1DEXT_pointer;
    long EXT_direct_state_access_glCompressedMultiTexSubImage3DEXT_pointer;
    long EXT_direct_state_access_glCompressedMultiTexSubImage2DEXT_pointer;
    long EXT_direct_state_access_glCompressedMultiTexSubImage1DEXT_pointer;
    long EXT_direct_state_access_glGetCompressedMultiTexImageEXT_pointer;
    long EXT_direct_state_access_glGetCompressedTexImage_pointer;
    long EXT_direct_state_access_glMatrixLoadTransposefEXT_pointer;
    long EXT_direct_state_access_glMatrixLoadTransposedEXT_pointer;
    long EXT_direct_state_access_glMatrixMultTransposefEXT_pointer;
    long EXT_direct_state_access_glMatrixMultTransposedEXT_pointer;
    long EXT_direct_state_access_glNamedBufferDataEXT_pointer;
    long EXT_direct_state_access_glNamedBufferSubDataEXT_pointer;
    long EXT_direct_state_access_glMapNamedBufferEXT_pointer;
    long EXT_direct_state_access_glUnmapNamedBufferEXT_pointer;
    long EXT_direct_state_access_glGetNamedBufferParameterivEXT_pointer;
    long EXT_direct_state_access_glGetNamedBufferPointervEXT_pointer;
    long EXT_direct_state_access_glGetNamedBufferSubDataEXT_pointer;
    long EXT_direct_state_access_glProgramUniform1fEXT_pointer;
    long EXT_direct_state_access_glProgramUniform2fEXT_pointer;
    long EXT_direct_state_access_glProgramUniform3fEXT_pointer;
    long EXT_direct_state_access_glProgramUniform4fEXT_pointer;
    long EXT_direct_state_access_glProgramUniform1iEXT_pointer;
    long EXT_direct_state_access_glProgramUniform2iEXT_pointer;
    long EXT_direct_state_access_glProgramUniform3iEXT_pointer;
    long EXT_direct_state_access_glProgramUniform4iEXT_pointer;
    long EXT_direct_state_access_glProgramUniform1fvEXT_pointer;
    long EXT_direct_state_access_glProgramUniform2fvEXT_pointer;
    long EXT_direct_state_access_glProgramUniform3fvEXT_pointer;
    long EXT_direct_state_access_glProgramUniform4fvEXT_pointer;
    long EXT_direct_state_access_glProgramUniform1ivEXT_pointer;
    long EXT_direct_state_access_glProgramUniform2ivEXT_pointer;
    long EXT_direct_state_access_glProgramUniform3ivEXT_pointer;
    long EXT_direct_state_access_glProgramUniform4ivEXT_pointer;
    long EXT_direct_state_access_glProgramUniformMatrix2fvEXT_pointer;
    long EXT_direct_state_access_glProgramUniformMatrix3fvEXT_pointer;
    long EXT_direct_state_access_glProgramUniformMatrix4fvEXT_pointer;
    long EXT_direct_state_access_glProgramUniformMatrix2x3fvEXT_pointer;
    long EXT_direct_state_access_glProgramUniformMatrix3x2fvEXT_pointer;
    long EXT_direct_state_access_glProgramUniformMatrix2x4fvEXT_pointer;
    long EXT_direct_state_access_glProgramUniformMatrix4x2fvEXT_pointer;
    long EXT_direct_state_access_glProgramUniformMatrix3x4fvEXT_pointer;
    long EXT_direct_state_access_glProgramUniformMatrix4x3fvEXT_pointer;
    long EXT_direct_state_access_glTextureBufferEXT_pointer;
    long EXT_direct_state_access_glMultiTexBufferEXT_pointer;
    long EXT_direct_state_access_glTextureParameterIivEXT_pointer;
    long EXT_direct_state_access_glTextureParameterIuivEXT_pointer;
    long EXT_direct_state_access_glGetTextureParameterIivEXT_pointer;
    long EXT_direct_state_access_glGetTextureParameterIuivEXT_pointer;
    long EXT_direct_state_access_glMultiTexParameterIivEXT_pointer;
    long EXT_direct_state_access_glMultiTexParameterIuivEXT_pointer;
    long EXT_direct_state_access_glGetMultiTexParameterIivEXT_pointer;
    long EXT_direct_state_access_glGetMultiTexParameterIuivEXT_pointer;
    long EXT_direct_state_access_glProgramUniform1uiEXT_pointer;
    long EXT_direct_state_access_glProgramUniform2uiEXT_pointer;
    long EXT_direct_state_access_glProgramUniform3uiEXT_pointer;
    long EXT_direct_state_access_glProgramUniform4uiEXT_pointer;
    long EXT_direct_state_access_glProgramUniform1uivEXT_pointer;
    long EXT_direct_state_access_glProgramUniform2uivEXT_pointer;
    long EXT_direct_state_access_glProgramUniform3uivEXT_pointer;
    long EXT_direct_state_access_glProgramUniform4uivEXT_pointer;
    long EXT_direct_state_access_glNamedProgramLocalParameters4fvEXT_pointer;
    long EXT_direct_state_access_glNamedProgramLocalParameterI4iEXT_pointer;
    long EXT_direct_state_access_glNamedProgramLocalParameterI4ivEXT_pointer;
    long EXT_direct_state_access_glNamedProgramLocalParametersI4ivEXT_pointer;
    long EXT_direct_state_access_glNamedProgramLocalParameterI4uiEXT_pointer;
    long EXT_direct_state_access_glNamedProgramLocalParameterI4uivEXT_pointer;
    long EXT_direct_state_access_glNamedProgramLocalParametersI4uivEXT_pointer;
    long EXT_direct_state_access_glGetNamedProgramLocalParameterIivEXT_pointer;
    long EXT_direct_state_access_glGetNamedProgramLocalParameterIuivEXT_pointer;
    long EXT_direct_state_access_glNamedRenderbufferStorageEXT_pointer;
    long EXT_direct_state_access_glGetNamedRenderbufferParameterivEXT_pointer;
    long EXT_direct_state_access_glNamedRenderbufferStorageMultisampleEXT_pointer;
    long EXT_direct_state_access_glNamedRenderbufferStorageMultisampleCoverageEXT_pointer;
    long EXT_direct_state_access_glCheckNamedFramebufferStatusEXT_pointer;
    long EXT_direct_state_access_glNamedFramebufferTexture1DEXT_pointer;
    long EXT_direct_state_access_glNamedFramebufferTexture2DEXT_pointer;
    long EXT_direct_state_access_glNamedFramebufferTexture3DEXT_pointer;
    long EXT_direct_state_access_glNamedFramebufferRenderbufferEXT_pointer;
    long EXT_direct_state_access_glGetNamedFramebufferAttachmentParameterivEXT_pointer;
    long EXT_direct_state_access_glGenerateTextureMipmapEXT_pointer;
    long EXT_direct_state_access_glGenerateMultiTexMipmapEXT_pointer;
    long EXT_direct_state_access_glFramebufferDrawBufferEXT_pointer;
    long EXT_direct_state_access_glFramebufferDrawBuffersEXT_pointer;
    long EXT_direct_state_access_glFramebufferReadBufferEXT_pointer;
    long EXT_direct_state_access_glGetFramebufferParameterivEXT_pointer;
    long EXT_direct_state_access_glNamedCopyBufferSubDataEXT_pointer;
    long EXT_direct_state_access_glNamedFramebufferTextureEXT_pointer;
    long EXT_direct_state_access_glNamedFramebufferTextureLayerEXT_pointer;
    long EXT_direct_state_access_glNamedFramebufferTextureFaceEXT_pointer;
    long EXT_direct_state_access_glTextureRenderbufferEXT_pointer;
    long EXT_direct_state_access_glMultiTexRenderbufferEXT_pointer;
    long EXT_direct_state_access_glVertexArrayVertexOffsetEXT_pointer;
    long EXT_direct_state_access_glVertexArrayColorOffsetEXT_pointer;
    long EXT_direct_state_access_glVertexArrayEdgeFlagOffsetEXT_pointer;
    long EXT_direct_state_access_glVertexArrayIndexOffsetEXT_pointer;
    long EXT_direct_state_access_glVertexArrayNormalOffsetEXT_pointer;
    long EXT_direct_state_access_glVertexArrayTexCoordOffsetEXT_pointer;
    long EXT_direct_state_access_glVertexArrayMultiTexCoordOffsetEXT_pointer;
    long EXT_direct_state_access_glVertexArrayFogCoordOffsetEXT_pointer;
    long EXT_direct_state_access_glVertexArraySecondaryColorOffsetEXT_pointer;
    long EXT_direct_state_access_glVertexArrayVertexAttribOffsetEXT_pointer;
    long EXT_direct_state_access_glVertexArrayVertexAttribIOffsetEXT_pointer;
    long EXT_direct_state_access_glEnableVertexArrayEXT_pointer;
    long EXT_direct_state_access_glDisableVertexArrayEXT_pointer;
    long EXT_direct_state_access_glEnableVertexArrayAttribEXT_pointer;
    long EXT_direct_state_access_glDisableVertexArrayAttribEXT_pointer;
    long EXT_direct_state_access_glGetVertexArrayIntegervEXT_pointer;
    long EXT_direct_state_access_glGetVertexArrayPointervEXT_pointer;
    long EXT_direct_state_access_glGetVertexArrayIntegeri_vEXT_pointer;
    long EXT_direct_state_access_glGetVertexArrayPointeri_vEXT_pointer;
    long EXT_direct_state_access_glMapNamedBufferRangeEXT_pointer;
    long EXT_direct_state_access_glFlushMappedNamedBufferRangeEXT_pointer;
    long EXT_draw_buffers2_glColorMaskIndexedEXT_pointer;
    long EXT_draw_buffers2_glGetBooleanIndexedvEXT_pointer;
    long EXT_draw_buffers2_glGetIntegerIndexedvEXT_pointer;
    long EXT_draw_buffers2_glEnableIndexedEXT_pointer;
    long EXT_draw_buffers2_glDisableIndexedEXT_pointer;
    long EXT_draw_buffers2_glIsEnabledIndexedEXT_pointer;
    long EXT_draw_instanced_glDrawArraysInstancedEXT_pointer;
    long EXT_draw_instanced_glDrawElementsInstancedEXT_pointer;
    long EXT_draw_range_elements_glDrawRangeElementsEXT_pointer;
    long EXT_fog_coord_glFogCoordfEXT_pointer;
    long EXT_fog_coord_glFogCoorddEXT_pointer;
    long EXT_fog_coord_glFogCoordPointerEXT_pointer;
    long EXT_framebuffer_blit_glBlitFramebufferEXT_pointer;
    long EXT_framebuffer_multisample_glRenderbufferStorageMultisampleEXT_pointer;
    long EXT_framebuffer_object_glIsRenderbufferEXT_pointer;
    long EXT_framebuffer_object_glBindRenderbufferEXT_pointer;
    long EXT_framebuffer_object_glDeleteRenderbuffersEXT_pointer;
    long EXT_framebuffer_object_glGenRenderbuffersEXT_pointer;
    long EXT_framebuffer_object_glRenderbufferStorageEXT_pointer;
    long EXT_framebuffer_object_glGetRenderbufferParameterivEXT_pointer;
    long EXT_framebuffer_object_glIsFramebufferEXT_pointer;
    long EXT_framebuffer_object_glBindFramebufferEXT_pointer;
    long EXT_framebuffer_object_glDeleteFramebuffersEXT_pointer;
    long EXT_framebuffer_object_glGenFramebuffersEXT_pointer;
    long EXT_framebuffer_object_glCheckFramebufferStatusEXT_pointer;
    long EXT_framebuffer_object_glFramebufferTexture1DEXT_pointer;
    long EXT_framebuffer_object_glFramebufferTexture2DEXT_pointer;
    long EXT_framebuffer_object_glFramebufferTexture3DEXT_pointer;
    long EXT_framebuffer_object_glFramebufferRenderbufferEXT_pointer;
    long EXT_framebuffer_object_glGetFramebufferAttachmentParameterivEXT_pointer;
    long EXT_framebuffer_object_glGenerateMipmapEXT_pointer;
    long EXT_geometry_shader4_glProgramParameteriEXT_pointer;
    long EXT_geometry_shader4_glFramebufferTextureEXT_pointer;
    long EXT_geometry_shader4_glFramebufferTextureLayerEXT_pointer;
    long EXT_geometry_shader4_glFramebufferTextureFaceEXT_pointer;
    long EXT_gpu_program_parameters_glProgramEnvParameters4fvEXT_pointer;
    long EXT_gpu_program_parameters_glProgramLocalParameters4fvEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI1iEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI2iEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI3iEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI4iEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI1uiEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI2uiEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI3uiEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI4uiEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI1ivEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI2ivEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI3ivEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI4ivEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI1uivEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI2uivEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI3uivEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI4uivEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI4bvEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI4svEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI4ubvEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribI4usvEXT_pointer;
    long EXT_gpu_shader4_glVertexAttribIPointerEXT_pointer;
    long EXT_gpu_shader4_glGetVertexAttribIivEXT_pointer;
    long EXT_gpu_shader4_glGetVertexAttribIuivEXT_pointer;
    long EXT_gpu_shader4_glUniform1uiEXT_pointer;
    long EXT_gpu_shader4_glUniform2uiEXT_pointer;
    long EXT_gpu_shader4_glUniform3uiEXT_pointer;
    long EXT_gpu_shader4_glUniform4uiEXT_pointer;
    long EXT_gpu_shader4_glUniform1uivEXT_pointer;
    long EXT_gpu_shader4_glUniform2uivEXT_pointer;
    long EXT_gpu_shader4_glUniform3uivEXT_pointer;
    long EXT_gpu_shader4_glUniform4uivEXT_pointer;
    long EXT_gpu_shader4_glGetUniformuivEXT_pointer;
    long EXT_gpu_shader4_glBindFragDataLocationEXT_pointer;
    long EXT_gpu_shader4_glGetFragDataLocationEXT_pointer;
    long EXT_multi_draw_arrays_glMultiDrawArraysEXT_pointer;
    long EXT_paletted_texture_glColorTableEXT_pointer;
    long EXT_paletted_texture_glColorSubTableEXT_pointer;
    long EXT_paletted_texture_glGetColorTableEXT_pointer;
    long EXT_paletted_texture_glGetColorTableParameterivEXT_pointer;
    long EXT_paletted_texture_glGetColorTableParameterfvEXT_pointer;
    long EXT_point_parameters_glPointParameterfEXT_pointer;
    long EXT_point_parameters_glPointParameterfvEXT_pointer;
    long EXT_provoking_vertex_glProvokingVertexEXT_pointer;
    long EXT_secondary_color_glSecondaryColor3bEXT_pointer;
    long EXT_secondary_color_glSecondaryColor3fEXT_pointer;
    long EXT_secondary_color_glSecondaryColor3dEXT_pointer;
    long EXT_secondary_color_glSecondaryColor3ubEXT_pointer;
    long EXT_secondary_color_glSecondaryColorPointerEXT_pointer;
    long EXT_separate_shader_objects_glUseShaderProgramEXT_pointer;
    long EXT_separate_shader_objects_glActiveProgramEXT_pointer;
    long EXT_separate_shader_objects_glCreateShaderProgramEXT_pointer;
    long EXT_shader_image_load_store_glBindImageTextureEXT_pointer;
    long EXT_shader_image_load_store_glMemoryBarrierEXT_pointer;
    long EXT_stencil_clear_tag_glStencilClearTagEXT_pointer;
    long EXT_stencil_two_side_glActiveStencilFaceEXT_pointer;
    long EXT_texture_array_glFramebufferTextureLayerEXT_pointer;
    long EXT_texture_buffer_object_glTexBufferEXT_pointer;
    long EXT_texture_integer_glClearColorIiEXT_pointer;
    long EXT_texture_integer_glClearColorIuiEXT_pointer;
    long EXT_texture_integer_glTexParameterIivEXT_pointer;
    long EXT_texture_integer_glTexParameterIuivEXT_pointer;
    long EXT_texture_integer_glGetTexParameterIivEXT_pointer;
    long EXT_texture_integer_glGetTexParameterIuivEXT_pointer;
    long EXT_timer_query_glGetQueryObjecti64vEXT_pointer;
    long EXT_timer_query_glGetQueryObjectui64vEXT_pointer;
    long EXT_transform_feedback_glBindBufferRangeEXT_pointer;
    long EXT_transform_feedback_glBindBufferOffsetEXT_pointer;
    long EXT_transform_feedback_glBindBufferBaseEXT_pointer;
    long EXT_transform_feedback_glBeginTransformFeedbackEXT_pointer;
    long EXT_transform_feedback_glEndTransformFeedbackEXT_pointer;
    long EXT_transform_feedback_glTransformFeedbackVaryingsEXT_pointer;
    long EXT_transform_feedback_glGetTransformFeedbackVaryingEXT_pointer;
    long EXT_vertex_attrib_64bit_glVertexAttribL1dEXT_pointer;
    long EXT_vertex_attrib_64bit_glVertexAttribL2dEXT_pointer;
    long EXT_vertex_attrib_64bit_glVertexAttribL3dEXT_pointer;
    long EXT_vertex_attrib_64bit_glVertexAttribL4dEXT_pointer;
    long EXT_vertex_attrib_64bit_glVertexAttribL1dvEXT_pointer;
    long EXT_vertex_attrib_64bit_glVertexAttribL2dvEXT_pointer;
    long EXT_vertex_attrib_64bit_glVertexAttribL3dvEXT_pointer;
    long EXT_vertex_attrib_64bit_glVertexAttribL4dvEXT_pointer;
    long EXT_vertex_attrib_64bit_glVertexAttribLPointerEXT_pointer;
    long EXT_vertex_attrib_64bit_glGetVertexAttribLdvEXT_pointer;
    long EXT_vertex_attrib_64bit_glVertexArrayVertexAttribLOffsetEXT_pointer;
    long EXT_vertex_shader_glBeginVertexShaderEXT_pointer;
    long EXT_vertex_shader_glEndVertexShaderEXT_pointer;
    long EXT_vertex_shader_glBindVertexShaderEXT_pointer;
    long EXT_vertex_shader_glGenVertexShadersEXT_pointer;
    long EXT_vertex_shader_glDeleteVertexShaderEXT_pointer;
    long EXT_vertex_shader_glShaderOp1EXT_pointer;
    long EXT_vertex_shader_glShaderOp2EXT_pointer;
    long EXT_vertex_shader_glShaderOp3EXT_pointer;
    long EXT_vertex_shader_glSwizzleEXT_pointer;
    long EXT_vertex_shader_glWriteMaskEXT_pointer;
    long EXT_vertex_shader_glInsertComponentEXT_pointer;
    long EXT_vertex_shader_glExtractComponentEXT_pointer;
    long EXT_vertex_shader_glGenSymbolsEXT_pointer;
    long EXT_vertex_shader_glSetInvariantEXT_pointer;
    long EXT_vertex_shader_glSetLocalConstantEXT_pointer;
    long EXT_vertex_shader_glVariantbvEXT_pointer;
    long EXT_vertex_shader_glVariantsvEXT_pointer;
    long EXT_vertex_shader_glVariantivEXT_pointer;
    long EXT_vertex_shader_glVariantfvEXT_pointer;
    long EXT_vertex_shader_glVariantdvEXT_pointer;
    long EXT_vertex_shader_glVariantubvEXT_pointer;
    long EXT_vertex_shader_glVariantusvEXT_pointer;
    long EXT_vertex_shader_glVariantuivEXT_pointer;
    long EXT_vertex_shader_glVariantPointerEXT_pointer;
    long EXT_vertex_shader_glEnableVariantClientStateEXT_pointer;
    long EXT_vertex_shader_glDisableVariantClientStateEXT_pointer;
    long EXT_vertex_shader_glBindLightParameterEXT_pointer;
    long EXT_vertex_shader_glBindMaterialParameterEXT_pointer;
    long EXT_vertex_shader_glBindTexGenParameterEXT_pointer;
    long EXT_vertex_shader_glBindTextureUnitParameterEXT_pointer;
    long EXT_vertex_shader_glBindParameterEXT_pointer;
    long EXT_vertex_shader_glIsVariantEnabledEXT_pointer;
    long EXT_vertex_shader_glGetVariantBooleanvEXT_pointer;
    long EXT_vertex_shader_glGetVariantIntegervEXT_pointer;
    long EXT_vertex_shader_glGetVariantFloatvEXT_pointer;
    long EXT_vertex_shader_glGetVariantPointervEXT_pointer;
    long EXT_vertex_shader_glGetInvariantBooleanvEXT_pointer;
    long EXT_vertex_shader_glGetInvariantIntegervEXT_pointer;
    long EXT_vertex_shader_glGetInvariantFloatvEXT_pointer;
    long EXT_vertex_shader_glGetLocalConstantBooleanvEXT_pointer;
    long EXT_vertex_shader_glGetLocalConstantIntegervEXT_pointer;
    long EXT_vertex_shader_glGetLocalConstantFloatvEXT_pointer;
    long EXT_vertex_weighting_glVertexWeightfEXT_pointer;
    long EXT_vertex_weighting_glVertexWeightPointerEXT_pointer;
    long GL11_glAccum_pointer;
    long GL11_glAlphaFunc_pointer;
    long GL11_glClearColor_pointer;
    long GL11_glClearAccum_pointer;
    long GL11_glClear_pointer;
    long GL11_glCallLists_pointer;
    long GL11_glCallList_pointer;
    long GL11_glBlendFunc_pointer;
    long GL11_glBitmap_pointer;
    long GL11_glBindTexture_pointer;
    long GL11_glPrioritizeTextures_pointer;
    long GL11_glAreTexturesResident_pointer;
    long GL11_glBegin_pointer;
    long GL11_glEnd_pointer;
    long GL11_glArrayElement_pointer;
    long GL11_glClearDepth_pointer;
    long GL11_glDeleteLists_pointer;
    long GL11_glDeleteTextures_pointer;
    long GL11_glCullFace_pointer;
    long GL11_glCopyTexSubImage2D_pointer;
    long GL11_glCopyTexSubImage1D_pointer;
    long GL11_glCopyTexImage2D_pointer;
    long GL11_glCopyTexImage1D_pointer;
    long GL11_glCopyPixels_pointer;
    long GL11_glColorPointer_pointer;
    long GL11_glColorMaterial_pointer;
    long GL11_glColorMask_pointer;
    long GL11_glColor3b_pointer;
    long GL11_glColor3f_pointer;
    long GL11_glColor3d_pointer;
    long GL11_glColor3ub_pointer;
    long GL11_glColor4b_pointer;
    long GL11_glColor4f_pointer;
    long GL11_glColor4d_pointer;
    long GL11_glColor4ub_pointer;
    long GL11_glClipPlane_pointer;
    long GL11_glClearStencil_pointer;
    long GL11_glEvalPoint1_pointer;
    long GL11_glEvalPoint2_pointer;
    long GL11_glEvalMesh1_pointer;
    long GL11_glEvalMesh2_pointer;
    long GL11_glEvalCoord1f_pointer;
    long GL11_glEvalCoord1d_pointer;
    long GL11_glEvalCoord2f_pointer;
    long GL11_glEvalCoord2d_pointer;
    long GL11_glEnableClientState_pointer;
    long GL11_glDisableClientState_pointer;
    long GL11_glEnable_pointer;
    long GL11_glDisable_pointer;
    long GL11_glEdgeFlagPointer_pointer;
    long GL11_glEdgeFlag_pointer;
    long GL11_glDrawPixels_pointer;
    long GL11_glDrawElements_pointer;
    long GL11_glDrawBuffer_pointer;
    long GL11_glDrawArrays_pointer;
    long GL11_glDepthRange_pointer;
    long GL11_glDepthMask_pointer;
    long GL11_glDepthFunc_pointer;
    long GL11_glFeedbackBuffer_pointer;
    long GL11_glGetPixelMapfv_pointer;
    long GL11_glGetPixelMapuiv_pointer;
    long GL11_glGetPixelMapusv_pointer;
    long GL11_glGetMaterialfv_pointer;
    long GL11_glGetMaterialiv_pointer;
    long GL11_glGetMapfv_pointer;
    long GL11_glGetMapdv_pointer;
    long GL11_glGetMapiv_pointer;
    long GL11_glGetLightfv_pointer;
    long GL11_glGetLightiv_pointer;
    long GL11_glGetError_pointer;
    long GL11_glGetClipPlane_pointer;
    long GL11_glGetBooleanv_pointer;
    long GL11_glGetDoublev_pointer;
    long GL11_glGetFloatv_pointer;
    long GL11_glGetIntegerv_pointer;
    long GL11_glGenTextures_pointer;
    long GL11_glGenLists_pointer;
    long GL11_glFrustum_pointer;
    long GL11_glFrontFace_pointer;
    long GL11_glFogf_pointer;
    long GL11_glFogi_pointer;
    long GL11_glFogfv_pointer;
    long GL11_glFogiv_pointer;
    long GL11_glFlush_pointer;
    long GL11_glFinish_pointer;
    long GL11_glGetPointerv_pointer;
    long GL11_glIsEnabled_pointer;
    long GL11_glInterleavedArrays_pointer;
    long GL11_glInitNames_pointer;
    long GL11_glHint_pointer;
    long GL11_glGetTexParameterfv_pointer;
    long GL11_glGetTexParameteriv_pointer;
    long GL11_glGetTexLevelParameterfv_pointer;
    long GL11_glGetTexLevelParameteriv_pointer;
    long GL11_glGetTexImage_pointer;
    long GL11_glGetTexGeniv_pointer;
    long GL11_glGetTexGenfv_pointer;
    long GL11_glGetTexGendv_pointer;
    long GL11_glGetTexEnviv_pointer;
    long GL11_glGetTexEnvfv_pointer;
    long GL11_glGetString_pointer;
    long GL11_glGetPolygonStipple_pointer;
    long GL11_glIsList_pointer;
    long GL11_glMaterialf_pointer;
    long GL11_glMateriali_pointer;
    long GL11_glMaterialfv_pointer;
    long GL11_glMaterialiv_pointer;
    long GL11_glMapGrid1f_pointer;
    long GL11_glMapGrid1d_pointer;
    long GL11_glMapGrid2f_pointer;
    long GL11_glMapGrid2d_pointer;
    long GL11_glMap2f_pointer;
    long GL11_glMap2d_pointer;
    long GL11_glMap1f_pointer;
    long GL11_glMap1d_pointer;
    long GL11_glLogicOp_pointer;
    long GL11_glLoadName_pointer;
    long GL11_glLoadMatrixf_pointer;
    long GL11_glLoadMatrixd_pointer;
    long GL11_glLoadIdentity_pointer;
    long GL11_glListBase_pointer;
    long GL11_glLineWidth_pointer;
    long GL11_glLineStipple_pointer;
    long GL11_glLightModelf_pointer;
    long GL11_glLightModeli_pointer;
    long GL11_glLightModelfv_pointer;
    long GL11_glLightModeliv_pointer;
    long GL11_glLightf_pointer;
    long GL11_glLighti_pointer;
    long GL11_glLightfv_pointer;
    long GL11_glLightiv_pointer;
    long GL11_glIsTexture_pointer;
    long GL11_glMatrixMode_pointer;
    long GL11_glPolygonStipple_pointer;
    long GL11_glPolygonOffset_pointer;
    long GL11_glPolygonMode_pointer;
    long GL11_glPointSize_pointer;
    long GL11_glPixelZoom_pointer;
    long GL11_glPixelTransferf_pointer;
    long GL11_glPixelTransferi_pointer;
    long GL11_glPixelStoref_pointer;
    long GL11_glPixelStorei_pointer;
    long GL11_glPixelMapfv_pointer;
    long GL11_glPixelMapuiv_pointer;
    long GL11_glPixelMapusv_pointer;
    long GL11_glPassThrough_pointer;
    long GL11_glOrtho_pointer;
    long GL11_glNormalPointer_pointer;
    long GL11_glNormal3b_pointer;
    long GL11_glNormal3f_pointer;
    long GL11_glNormal3d_pointer;
    long GL11_glNormal3i_pointer;
    long GL11_glNewList_pointer;
    long GL11_glEndList_pointer;
    long GL11_glMultMatrixf_pointer;
    long GL11_glMultMatrixd_pointer;
    long GL11_glShadeModel_pointer;
    long GL11_glSelectBuffer_pointer;
    long GL11_glScissor_pointer;
    long GL11_glScalef_pointer;
    long GL11_glScaled_pointer;
    long GL11_glRotatef_pointer;
    long GL11_glRenderMode_pointer;
    long GL11_glRectf_pointer;
    long GL11_glRectd_pointer;
    long GL11_glRecti_pointer;
    long GL11_glReadPixels_pointer;
    long GL11_glReadBuffer_pointer;
    long GL11_glRasterPos2f_pointer;
    long GL11_glRasterPos2d_pointer;
    long GL11_glRasterPos2i_pointer;
    long GL11_glRasterPos3f_pointer;
    long GL11_glRasterPos3d_pointer;
    long GL11_glRasterPos3i_pointer;
    long GL11_glRasterPos4f_pointer;
    long GL11_glRasterPos4d_pointer;
    long GL11_glRasterPos4i_pointer;
    long GL11_glPushName_pointer;
    long GL11_glPopName_pointer;
    long GL11_glPushMatrix_pointer;
    long GL11_glPopMatrix_pointer;
    long GL11_glPushClientAttrib_pointer;
    long GL11_glPopClientAttrib_pointer;
    long GL11_glPushAttrib_pointer;
    long GL11_glPopAttrib_pointer;
    long GL11_glStencilFunc_pointer;
    long GL11_glVertexPointer_pointer;
    long GL11_glVertex2f_pointer;
    long GL11_glVertex2d_pointer;
    long GL11_glVertex2i_pointer;
    long GL11_glVertex3f_pointer;
    long GL11_glVertex3d_pointer;
    long GL11_glVertex3i_pointer;
    long GL11_glVertex4f_pointer;
    long GL11_glVertex4d_pointer;
    long GL11_glVertex4i_pointer;
    long GL11_glTranslatef_pointer;
    long GL11_glTranslated_pointer;
    long GL11_glTexImage1D_pointer;
    long GL11_glTexImage2D_pointer;
    long GL11_glTexSubImage1D_pointer;
    long GL11_glTexSubImage2D_pointer;
    long GL11_glTexParameterf_pointer;
    long GL11_glTexParameteri_pointer;
    long GL11_glTexParameterfv_pointer;
    long GL11_glTexParameteriv_pointer;
    long GL11_glTexGenf_pointer;
    long GL11_glTexGend_pointer;
    long GL11_glTexGenfv_pointer;
    long GL11_glTexGendv_pointer;
    long GL11_glTexGeni_pointer;
    long GL11_glTexGeniv_pointer;
    long GL11_glTexEnvf_pointer;
    long GL11_glTexEnvi_pointer;
    long GL11_glTexEnvfv_pointer;
    long GL11_glTexEnviv_pointer;
    long GL11_glTexCoordPointer_pointer;
    long GL11_glTexCoord1f_pointer;
    long GL11_glTexCoord1d_pointer;
    long GL11_glTexCoord2f_pointer;
    long GL11_glTexCoord2d_pointer;
    long GL11_glTexCoord3f_pointer;
    long GL11_glTexCoord3d_pointer;
    long GL11_glTexCoord4f_pointer;
    long GL11_glTexCoord4d_pointer;
    long GL11_glStencilOp_pointer;
    long GL11_glStencilMask_pointer;
    long GL11_glViewport_pointer;
    long GL12_glDrawRangeElements_pointer;
    long GL12_glTexImage3D_pointer;
    long GL12_glTexSubImage3D_pointer;
    long GL12_glCopyTexSubImage3D_pointer;
    long GL13_glActiveTexture_pointer;
    long GL13_glClientActiveTexture_pointer;
    long GL13_glCompressedTexImage1D_pointer;
    long GL13_glCompressedTexImage2D_pointer;
    long GL13_glCompressedTexImage3D_pointer;
    long GL13_glCompressedTexSubImage1D_pointer;
    long GL13_glCompressedTexSubImage2D_pointer;
    long GL13_glCompressedTexSubImage3D_pointer;
    long GL13_glGetCompressedTexImage_pointer;
    long GL13_glMultiTexCoord1f_pointer;
    long GL13_glMultiTexCoord1d_pointer;
    long GL13_glMultiTexCoord2f_pointer;
    long GL13_glMultiTexCoord2d_pointer;
    long GL13_glMultiTexCoord3f_pointer;
    long GL13_glMultiTexCoord3d_pointer;
    long GL13_glMultiTexCoord4f_pointer;
    long GL13_glMultiTexCoord4d_pointer;
    long GL13_glLoadTransposeMatrixf_pointer;
    long GL13_glLoadTransposeMatrixd_pointer;
    long GL13_glMultTransposeMatrixf_pointer;
    long GL13_glMultTransposeMatrixd_pointer;
    long GL13_glSampleCoverage_pointer;
    long GL14_glBlendEquation_pointer;
    long GL14_glBlendColor_pointer;
    long GL14_glFogCoordf_pointer;
    long GL14_glFogCoordd_pointer;
    long GL14_glFogCoordPointer_pointer;
    long GL14_glMultiDrawArrays_pointer;
    long GL14_glPointParameteri_pointer;
    long GL14_glPointParameterf_pointer;
    long GL14_glPointParameteriv_pointer;
    long GL14_glPointParameterfv_pointer;
    long GL14_glSecondaryColor3b_pointer;
    long GL14_glSecondaryColor3f_pointer;
    long GL14_glSecondaryColor3d_pointer;
    long GL14_glSecondaryColor3ub_pointer;
    long GL14_glSecondaryColorPointer_pointer;
    long GL14_glBlendFuncSeparate_pointer;
    long GL14_glWindowPos2f_pointer;
    long GL14_glWindowPos2d_pointer;
    long GL14_glWindowPos2i_pointer;
    long GL14_glWindowPos3f_pointer;
    long GL14_glWindowPos3d_pointer;
    long GL14_glWindowPos3i_pointer;
    long GL15_glBindBuffer_pointer;
    long GL15_glDeleteBuffers_pointer;
    long GL15_glGenBuffers_pointer;
    long GL15_glIsBuffer_pointer;
    long GL15_glBufferData_pointer;
    long GL15_glBufferSubData_pointer;
    long GL15_glGetBufferSubData_pointer;
    long GL15_glMapBuffer_pointer;
    long GL15_glUnmapBuffer_pointer;
    long GL15_glGetBufferParameteriv_pointer;
    long GL15_glGetBufferPointerv_pointer;
    long GL15_glGenQueries_pointer;
    long GL15_glDeleteQueries_pointer;
    long GL15_glIsQuery_pointer;
    long GL15_glBeginQuery_pointer;
    long GL15_glEndQuery_pointer;
    long GL15_glGetQueryiv_pointer;
    long GL15_glGetQueryObjectiv_pointer;
    long GL15_glGetQueryObjectuiv_pointer;
    long GL20_glShaderSource_pointer;
    long GL20_glCreateShader_pointer;
    long GL20_glIsShader_pointer;
    long GL20_glCompileShader_pointer;
    long GL20_glDeleteShader_pointer;
    long GL20_glCreateProgram_pointer;
    long GL20_glIsProgram_pointer;
    long GL20_glAttachShader_pointer;
    long GL20_glDetachShader_pointer;
    long GL20_glLinkProgram_pointer;
    long GL20_glUseProgram_pointer;
    long GL20_glValidateProgram_pointer;
    long GL20_glDeleteProgram_pointer;
    long GL20_glUniform1f_pointer;
    long GL20_glUniform2f_pointer;
    long GL20_glUniform3f_pointer;
    long GL20_glUniform4f_pointer;
    long GL20_glUniform1i_pointer;
    long GL20_glUniform2i_pointer;
    long GL20_glUniform3i_pointer;
    long GL20_glUniform4i_pointer;
    long GL20_glUniform1fv_pointer;
    long GL20_glUniform2fv_pointer;
    long GL20_glUniform3fv_pointer;
    long GL20_glUniform4fv_pointer;
    long GL20_glUniform1iv_pointer;
    long GL20_glUniform2iv_pointer;
    long GL20_glUniform3iv_pointer;
    long GL20_glUniform4iv_pointer;
    long GL20_glUniformMatrix2fv_pointer;
    long GL20_glUniformMatrix3fv_pointer;
    long GL20_glUniformMatrix4fv_pointer;
    long GL20_glGetShaderiv_pointer;
    long GL20_glGetProgramiv_pointer;
    long GL20_glGetShaderInfoLog_pointer;
    long GL20_glGetProgramInfoLog_pointer;
    long GL20_glGetAttachedShaders_pointer;
    long GL20_glGetUniformLocation_pointer;
    long GL20_glGetActiveUniform_pointer;
    long GL20_glGetUniformfv_pointer;
    long GL20_glGetUniformiv_pointer;
    long GL20_glGetShaderSource_pointer;
    long GL20_glVertexAttrib1s_pointer;
    long GL20_glVertexAttrib1f_pointer;
    long GL20_glVertexAttrib1d_pointer;
    long GL20_glVertexAttrib2s_pointer;
    long GL20_glVertexAttrib2f_pointer;
    long GL20_glVertexAttrib2d_pointer;
    long GL20_glVertexAttrib3s_pointer;
    long GL20_glVertexAttrib3f_pointer;
    long GL20_glVertexAttrib3d_pointer;
    long GL20_glVertexAttrib4s_pointer;
    long GL20_glVertexAttrib4f_pointer;
    long GL20_glVertexAttrib4d_pointer;
    long GL20_glVertexAttrib4Nub_pointer;
    long GL20_glVertexAttribPointer_pointer;
    long GL20_glEnableVertexAttribArray_pointer;
    long GL20_glDisableVertexAttribArray_pointer;
    long GL20_glGetVertexAttribfv_pointer;
    long GL20_glGetVertexAttribdv_pointer;
    long GL20_glGetVertexAttribiv_pointer;
    long GL20_glGetVertexAttribPointerv_pointer;
    long GL20_glBindAttribLocation_pointer;
    long GL20_glGetActiveAttrib_pointer;
    long GL20_glGetAttribLocation_pointer;
    long GL20_glDrawBuffers_pointer;
    long GL20_glStencilOpSeparate_pointer;
    long GL20_glStencilFuncSeparate_pointer;
    long GL20_glStencilMaskSeparate_pointer;
    long GL20_glBlendEquationSeparate_pointer;
    long GL21_glUniformMatrix2x3fv_pointer;
    long GL21_glUniformMatrix3x2fv_pointer;
    long GL21_glUniformMatrix2x4fv_pointer;
    long GL21_glUniformMatrix4x2fv_pointer;
    long GL21_glUniformMatrix3x4fv_pointer;
    long GL21_glUniformMatrix4x3fv_pointer;
    long GL30_glGetStringi_pointer;
    long GL30_glClearBufferfv_pointer;
    long GL30_glClearBufferiv_pointer;
    long GL30_glClearBufferuiv_pointer;
    long GL30_glClearBufferfi_pointer;
    long GL30_glVertexAttribI1i_pointer;
    long GL30_glVertexAttribI2i_pointer;
    long GL30_glVertexAttribI3i_pointer;
    long GL30_glVertexAttribI4i_pointer;
    long GL30_glVertexAttribI1ui_pointer;
    long GL30_glVertexAttribI2ui_pointer;
    long GL30_glVertexAttribI3ui_pointer;
    long GL30_glVertexAttribI4ui_pointer;
    long GL30_glVertexAttribI1iv_pointer;
    long GL30_glVertexAttribI2iv_pointer;
    long GL30_glVertexAttribI3iv_pointer;
    long GL30_glVertexAttribI4iv_pointer;
    long GL30_glVertexAttribI1uiv_pointer;
    long GL30_glVertexAttribI2uiv_pointer;
    long GL30_glVertexAttribI3uiv_pointer;
    long GL30_glVertexAttribI4uiv_pointer;
    long GL30_glVertexAttribI4bv_pointer;
    long GL30_glVertexAttribI4sv_pointer;
    long GL30_glVertexAttribI4ubv_pointer;
    long GL30_glVertexAttribI4usv_pointer;
    long GL30_glVertexAttribIPointer_pointer;
    long GL30_glGetVertexAttribIiv_pointer;
    long GL30_glGetVertexAttribIuiv_pointer;
    long GL30_glUniform1ui_pointer;
    long GL30_glUniform2ui_pointer;
    long GL30_glUniform3ui_pointer;
    long GL30_glUniform4ui_pointer;
    long GL30_glUniform1uiv_pointer;
    long GL30_glUniform2uiv_pointer;
    long GL30_glUniform3uiv_pointer;
    long GL30_glUniform4uiv_pointer;
    long GL30_glGetUniformuiv_pointer;
    long GL30_glBindFragDataLocation_pointer;
    long GL30_glGetFragDataLocation_pointer;
    long GL30_glBeginConditionalRender_pointer;
    long GL30_glEndConditionalRender_pointer;
    long GL30_glMapBufferRange_pointer;
    long GL30_glFlushMappedBufferRange_pointer;
    long GL30_glClampColor_pointer;
    long GL30_glIsRenderbuffer_pointer;
    long GL30_glBindRenderbuffer_pointer;
    long GL30_glDeleteRenderbuffers_pointer;
    long GL30_glGenRenderbuffers_pointer;
    long GL30_glRenderbufferStorage_pointer;
    long GL30_glGetRenderbufferParameteriv_pointer;
    long GL30_glIsFramebuffer_pointer;
    long GL30_glBindFramebuffer_pointer;
    long GL30_glDeleteFramebuffers_pointer;
    long GL30_glGenFramebuffers_pointer;
    long GL30_glCheckFramebufferStatus_pointer;
    long GL30_glFramebufferTexture1D_pointer;
    long GL30_glFramebufferTexture2D_pointer;
    long GL30_glFramebufferTexture3D_pointer;
    long GL30_glFramebufferRenderbuffer_pointer;
    long GL30_glGetFramebufferAttachmentParameteriv_pointer;
    long GL30_glGenerateMipmap_pointer;
    long GL30_glRenderbufferStorageMultisample_pointer;
    long GL30_glBlitFramebuffer_pointer;
    long GL30_glTexParameterIiv_pointer;
    long GL30_glTexParameterIuiv_pointer;
    long GL30_glGetTexParameterIiv_pointer;
    long GL30_glGetTexParameterIuiv_pointer;
    long GL30_glFramebufferTextureLayer_pointer;
    long GL30_glColorMaski_pointer;
    long GL30_glGetBooleani_v_pointer;
    long GL30_glGetIntegeri_v_pointer;
    long GL30_glEnablei_pointer;
    long GL30_glDisablei_pointer;
    long GL30_glIsEnabledi_pointer;
    long GL30_glBindBufferRange_pointer;
    long GL30_glBindBufferBase_pointer;
    long GL30_glBeginTransformFeedback_pointer;
    long GL30_glEndTransformFeedback_pointer;
    long GL30_glTransformFeedbackVaryings_pointer;
    long GL30_glGetTransformFeedbackVarying_pointer;
    long GL30_glBindVertexArray_pointer;
    long GL30_glDeleteVertexArrays_pointer;
    long GL30_glGenVertexArrays_pointer;
    long GL30_glIsVertexArray_pointer;
    long GL31_glDrawArraysInstanced_pointer;
    long GL31_glDrawElementsInstanced_pointer;
    long GL31_glCopyBufferSubData_pointer;
    long GL31_glPrimitiveRestartIndex_pointer;
    long GL31_glTexBuffer_pointer;
    long GL31_glGetUniformIndices_pointer;
    long GL31_glGetActiveUniformsiv_pointer;
    long GL31_glGetActiveUniformName_pointer;
    long GL31_glGetUniformBlockIndex_pointer;
    long GL31_glGetActiveUniformBlockiv_pointer;
    long GL31_glGetActiveUniformBlockName_pointer;
    long GL31_glUniformBlockBinding_pointer;
    long GL32_glDrawElementsBaseVertex_pointer;
    long GL32_glDrawRangeElementsBaseVertex_pointer;
    long GL32_glDrawElementsInstancedBaseVertex_pointer;
    long GL32_glProvokingVertex_pointer;
    long GL32_glTexImage2DMultisample_pointer;
    long GL32_glTexImage3DMultisample_pointer;
    long GL32_glGetMultisamplefv_pointer;
    long GL32_glSampleMaski_pointer;
    long GL32_glFramebufferTexture_pointer;
    long GL32_glFramebufferTextureLayer_pointer;
    long GL32_glFenceSync_pointer;
    long GL32_glIsSync_pointer;
    long GL32_glDeleteSync_pointer;
    long GL32_glClientWaitSync_pointer;
    long GL32_glWaitSync_pointer;
    long GL32_glGetInteger64v_pointer;
    long GL32_glGetInteger64i_v_pointer;
    long GL32_glGetSynciv_pointer;
    long GL33_glBindFragDataLocationIndexed_pointer;
    long GL33_glGetFragDataIndex_pointer;
    long GL33_glGenSamplers_pointer;
    long GL33_glDeleteSamplers_pointer;
    long GL33_glIsSampler_pointer;
    long GL33_glBindSampler_pointer;
    long GL33_glSamplerParameteri_pointer;
    long GL33_glSamplerParameterf_pointer;
    long GL33_glSamplerParameteriv_pointer;
    long GL33_glSamplerParameterfv_pointer;
    long GL33_glSamplerParameterIiv_pointer;
    long GL33_glSamplerParameterIuiv_pointer;
    long GL33_glGetSamplerParameteriv_pointer;
    long GL33_glGetSamplerParameterfv_pointer;
    long GL33_glGetSamplerParameterIiv_pointer;
    long GL33_glGetSamplerParameterIuiv_pointer;
    long GL33_glQueryCounter_pointer;
    long GL33_glGetQueryObjecti64v_pointer;
    long GL33_glGetQueryObjectui64v_pointer;
    long GL33_glVertexAttribDivisor_pointer;
    long GL33_glVertexP2ui_pointer;
    long GL33_glVertexP3ui_pointer;
    long GL33_glVertexP4ui_pointer;
    long GL33_glVertexP2uiv_pointer;
    long GL33_glVertexP3uiv_pointer;
    long GL33_glVertexP4uiv_pointer;
    long GL33_glTexCoordP1ui_pointer;
    long GL33_glTexCoordP2ui_pointer;
    long GL33_glTexCoordP3ui_pointer;
    long GL33_glTexCoordP4ui_pointer;
    long GL33_glTexCoordP1uiv_pointer;
    long GL33_glTexCoordP2uiv_pointer;
    long GL33_glTexCoordP3uiv_pointer;
    long GL33_glTexCoordP4uiv_pointer;
    long GL33_glMultiTexCoordP1ui_pointer;
    long GL33_glMultiTexCoordP2ui_pointer;
    long GL33_glMultiTexCoordP3ui_pointer;
    long GL33_glMultiTexCoordP4ui_pointer;
    long GL33_glMultiTexCoordP1uiv_pointer;
    long GL33_glMultiTexCoordP2uiv_pointer;
    long GL33_glMultiTexCoordP3uiv_pointer;
    long GL33_glMultiTexCoordP4uiv_pointer;
    long GL33_glNormalP3ui_pointer;
    long GL33_glNormalP3uiv_pointer;
    long GL33_glColorP3ui_pointer;
    long GL33_glColorP4ui_pointer;
    long GL33_glColorP3uiv_pointer;
    long GL33_glColorP4uiv_pointer;
    long GL33_glSecondaryColorP3ui_pointer;
    long GL33_glSecondaryColorP3uiv_pointer;
    long GL33_glVertexAttribP1ui_pointer;
    long GL33_glVertexAttribP2ui_pointer;
    long GL33_glVertexAttribP3ui_pointer;
    long GL33_glVertexAttribP4ui_pointer;
    long GL33_glVertexAttribP1uiv_pointer;
    long GL33_glVertexAttribP2uiv_pointer;
    long GL33_glVertexAttribP3uiv_pointer;
    long GL33_glVertexAttribP4uiv_pointer;
    long GL40_glBlendEquationi_pointer;
    long GL40_glBlendEquationSeparatei_pointer;
    long GL40_glBlendFunci_pointer;
    long GL40_glBlendFuncSeparatei_pointer;
    long GL40_glDrawArraysIndirect_pointer;
    long GL40_glDrawElementsIndirect_pointer;
    long GL40_glUniform1d_pointer;
    long GL40_glUniform2d_pointer;
    long GL40_glUniform3d_pointer;
    long GL40_glUniform4d_pointer;
    long GL40_glUniform1dv_pointer;
    long GL40_glUniform2dv_pointer;
    long GL40_glUniform3dv_pointer;
    long GL40_glUniform4dv_pointer;
    long GL40_glUniformMatrix2dv_pointer;
    long GL40_glUniformMatrix3dv_pointer;
    long GL40_glUniformMatrix4dv_pointer;
    long GL40_glUniformMatrix2x3dv_pointer;
    long GL40_glUniformMatrix2x4dv_pointer;
    long GL40_glUniformMatrix3x2dv_pointer;
    long GL40_glUniformMatrix3x4dv_pointer;
    long GL40_glUniformMatrix4x2dv_pointer;
    long GL40_glUniformMatrix4x3dv_pointer;
    long GL40_glGetUniformdv_pointer;
    long GL40_glMinSampleShading_pointer;
    long GL40_glGetSubroutineUniformLocation_pointer;
    long GL40_glGetSubroutineIndex_pointer;
    long GL40_glGetActiveSubroutineUniformiv_pointer;
    long GL40_glGetActiveSubroutineUniformName_pointer;
    long GL40_glGetActiveSubroutineName_pointer;
    long GL40_glUniformSubroutinesuiv_pointer;
    long GL40_glGetUniformSubroutineuiv_pointer;
    long GL40_glGetProgramStageiv_pointer;
    long GL40_glPatchParameteri_pointer;
    long GL40_glPatchParameterfv_pointer;
    long GL40_glBindTransformFeedback_pointer;
    long GL40_glDeleteTransformFeedbacks_pointer;
    long GL40_glGenTransformFeedbacks_pointer;
    long GL40_glIsTransformFeedback_pointer;
    long GL40_glPauseTransformFeedback_pointer;
    long GL40_glResumeTransformFeedback_pointer;
    long GL40_glDrawTransformFeedback_pointer;
    long GL40_glDrawTransformFeedbackStream_pointer;
    long GL40_glBeginQueryIndexed_pointer;
    long GL40_glEndQueryIndexed_pointer;
    long GL40_glGetQueryIndexediv_pointer;
    long GREMEDY_string_marker_glStringMarkerGREMEDY_pointer;
    long NV_conditional_render_glBeginConditionalRenderNV_pointer;
    long NV_conditional_render_glEndConditionalRenderNV_pointer;
    long NV_copy_image_glCopyImageSubDataNV_pointer;
    long NV_depth_buffer_float_glDepthRangedNV_pointer;
    long NV_depth_buffer_float_glClearDepthdNV_pointer;
    long NV_depth_buffer_float_glDepthBoundsdNV_pointer;
    long NV_evaluators_glGetMapControlPointsNV_pointer;
    long NV_evaluators_glMapControlPointsNV_pointer;
    long NV_evaluators_glMapParameterfvNV_pointer;
    long NV_evaluators_glMapParameterivNV_pointer;
    long NV_evaluators_glGetMapParameterfvNV_pointer;
    long NV_evaluators_glGetMapParameterivNV_pointer;
    long NV_evaluators_glGetMapAttribParameterfvNV_pointer;
    long NV_evaluators_glGetMapAttribParameterivNV_pointer;
    long NV_evaluators_glEvalMapsNV_pointer;
    long NV_explicit_multisample_glGetBooleanIndexedvEXT_pointer;
    long NV_explicit_multisample_glGetIntegerIndexedvEXT_pointer;
    long NV_explicit_multisample_glGetMultisamplefvNV_pointer;
    long NV_explicit_multisample_glSampleMaskIndexedNV_pointer;
    long NV_explicit_multisample_glTexRenderbufferNV_pointer;
    long NV_fence_glGenFencesNV_pointer;
    long NV_fence_glDeleteFencesNV_pointer;
    long NV_fence_glSetFenceNV_pointer;
    long NV_fence_glTestFenceNV_pointer;
    long NV_fence_glFinishFenceNV_pointer;
    long NV_fence_glIsFenceNV_pointer;
    long NV_fence_glGetFenceivNV_pointer;
    long NV_fragment_program_glProgramNamedParameter4fNV_pointer;
    long NV_fragment_program_glProgramNamedParameter4dNV_pointer;
    long NV_fragment_program_glGetProgramNamedParameterfvNV_pointer;
    long NV_fragment_program_glGetProgramNamedParameterdvNV_pointer;
    long NV_framebuffer_multisample_coverage_glRenderbufferStorageMultisampleCoverageNV_pointer;
    long NV_geometry_program4_glProgramVertexLimitNV_pointer;
    long NV_geometry_program4_glFramebufferTextureEXT_pointer;
    long NV_geometry_program4_glFramebufferTextureLayerEXT_pointer;
    long NV_geometry_program4_glFramebufferTextureFaceEXT_pointer;
    long NV_gpu_program4_glProgramLocalParameterI4iNV_pointer;
    long NV_gpu_program4_glProgramLocalParameterI4ivNV_pointer;
    long NV_gpu_program4_glProgramLocalParametersI4ivNV_pointer;
    long NV_gpu_program4_glProgramLocalParameterI4uiNV_pointer;
    long NV_gpu_program4_glProgramLocalParameterI4uivNV_pointer;
    long NV_gpu_program4_glProgramLocalParametersI4uivNV_pointer;
    long NV_gpu_program4_glProgramEnvParameterI4iNV_pointer;
    long NV_gpu_program4_glProgramEnvParameterI4ivNV_pointer;
    long NV_gpu_program4_glProgramEnvParametersI4ivNV_pointer;
    long NV_gpu_program4_glProgramEnvParameterI4uiNV_pointer;
    long NV_gpu_program4_glProgramEnvParameterI4uivNV_pointer;
    long NV_gpu_program4_glProgramEnvParametersI4uivNV_pointer;
    long NV_gpu_program4_glGetProgramLocalParameterIivNV_pointer;
    long NV_gpu_program4_glGetProgramLocalParameterIuivNV_pointer;
    long NV_gpu_program4_glGetProgramEnvParameterIivNV_pointer;
    long NV_gpu_program4_glGetProgramEnvParameterIuivNV_pointer;
    long NV_gpu_shader5_glUniform1i64NV_pointer;
    long NV_gpu_shader5_glUniform2i64NV_pointer;
    long NV_gpu_shader5_glUniform3i64NV_pointer;
    long NV_gpu_shader5_glUniform4i64NV_pointer;
    long NV_gpu_shader5_glUniform1i64vNV_pointer;
    long NV_gpu_shader5_glUniform2i64vNV_pointer;
    long NV_gpu_shader5_glUniform3i64vNV_pointer;
    long NV_gpu_shader5_glUniform4i64vNV_pointer;
    long NV_gpu_shader5_glUniform1ui64NV_pointer;
    long NV_gpu_shader5_glUniform2ui64NV_pointer;
    long NV_gpu_shader5_glUniform3ui64NV_pointer;
    long NV_gpu_shader5_glUniform4ui64NV_pointer;
    long NV_gpu_shader5_glUniform1ui64vNV_pointer;
    long NV_gpu_shader5_glUniform2ui64vNV_pointer;
    long NV_gpu_shader5_glUniform3ui64vNV_pointer;
    long NV_gpu_shader5_glUniform4ui64vNV_pointer;
    long NV_gpu_shader5_glGetUniformi64vNV_pointer;
    long NV_gpu_shader5_glGetUniformui64vNV_pointer;
    long NV_gpu_shader5_glProgramUniform1i64NV_pointer;
    long NV_gpu_shader5_glProgramUniform2i64NV_pointer;
    long NV_gpu_shader5_glProgramUniform3i64NV_pointer;
    long NV_gpu_shader5_glProgramUniform4i64NV_pointer;
    long NV_gpu_shader5_glProgramUniform1i64vNV_pointer;
    long NV_gpu_shader5_glProgramUniform2i64vNV_pointer;
    long NV_gpu_shader5_glProgramUniform3i64vNV_pointer;
    long NV_gpu_shader5_glProgramUniform4i64vNV_pointer;
    long NV_gpu_shader5_glProgramUniform1ui64NV_pointer;
    long NV_gpu_shader5_glProgramUniform2ui64NV_pointer;
    long NV_gpu_shader5_glProgramUniform3ui64NV_pointer;
    long NV_gpu_shader5_glProgramUniform4ui64NV_pointer;
    long NV_gpu_shader5_glProgramUniform1ui64vNV_pointer;
    long NV_gpu_shader5_glProgramUniform2ui64vNV_pointer;
    long NV_gpu_shader5_glProgramUniform3ui64vNV_pointer;
    long NV_gpu_shader5_glProgramUniform4ui64vNV_pointer;
    long NV_half_float_glVertex2hNV_pointer;
    long NV_half_float_glVertex3hNV_pointer;
    long NV_half_float_glVertex4hNV_pointer;
    long NV_half_float_glNormal3hNV_pointer;
    long NV_half_float_glColor3hNV_pointer;
    long NV_half_float_glColor4hNV_pointer;
    long NV_half_float_glTexCoord1hNV_pointer;
    long NV_half_float_glTexCoord2hNV_pointer;
    long NV_half_float_glTexCoord3hNV_pointer;
    long NV_half_float_glTexCoord4hNV_pointer;
    long NV_half_float_glMultiTexCoord1hNV_pointer;
    long NV_half_float_glMultiTexCoord2hNV_pointer;
    long NV_half_float_glMultiTexCoord3hNV_pointer;
    long NV_half_float_glMultiTexCoord4hNV_pointer;
    long NV_half_float_glFogCoordhNV_pointer;
    long NV_half_float_glSecondaryColor3hNV_pointer;
    long NV_half_float_glVertexWeighthNV_pointer;
    long NV_half_float_glVertexAttrib1hNV_pointer;
    long NV_half_float_glVertexAttrib2hNV_pointer;
    long NV_half_float_glVertexAttrib3hNV_pointer;
    long NV_half_float_glVertexAttrib4hNV_pointer;
    long NV_half_float_glVertexAttribs1hvNV_pointer;
    long NV_half_float_glVertexAttribs2hvNV_pointer;
    long NV_half_float_glVertexAttribs3hvNV_pointer;
    long NV_half_float_glVertexAttribs4hvNV_pointer;
    long NV_occlusion_query_glGenOcclusionQueriesNV_pointer;
    long NV_occlusion_query_glDeleteOcclusionQueriesNV_pointer;
    long NV_occlusion_query_glIsOcclusionQueryNV_pointer;
    long NV_occlusion_query_glBeginOcclusionQueryNV_pointer;
    long NV_occlusion_query_glEndOcclusionQueryNV_pointer;
    long NV_occlusion_query_glGetOcclusionQueryuivNV_pointer;
    long NV_occlusion_query_glGetOcclusionQueryivNV_pointer;
    long NV_parameter_buffer_object_glProgramBufferParametersfvNV_pointer;
    long NV_parameter_buffer_object_glProgramBufferParametersIivNV_pointer;
    long NV_parameter_buffer_object_glProgramBufferParametersIuivNV_pointer;
    long NV_pixel_data_range_glPixelDataRangeNV_pointer;
    long NV_pixel_data_range_glFlushPixelDataRangeNV_pointer;
    long NV_point_sprite_glPointParameteriNV_pointer;
    long NV_point_sprite_glPointParameterivNV_pointer;
    long NV_primitive_restart_glPrimitiveRestartNV_pointer;
    long NV_primitive_restart_glPrimitiveRestartIndexNV_pointer;
    long NV_program_glLoadProgramNV_pointer;
    long NV_program_glBindProgramNV_pointer;
    long NV_program_glDeleteProgramsNV_pointer;
    long NV_program_glGenProgramsNV_pointer;
    long NV_program_glGetProgramivNV_pointer;
    long NV_program_glGetProgramStringNV_pointer;
    long NV_program_glIsProgramNV_pointer;
    long NV_program_glAreProgramsResidentNV_pointer;
    long NV_program_glRequestResidentProgramsNV_pointer;
    long NV_register_combiners_glCombinerParameterfNV_pointer;
    long NV_register_combiners_glCombinerParameterfvNV_pointer;
    long NV_register_combiners_glCombinerParameteriNV_pointer;
    long NV_register_combiners_glCombinerParameterivNV_pointer;
    long NV_register_combiners_glCombinerInputNV_pointer;
    long NV_register_combiners_glCombinerOutputNV_pointer;
    long NV_register_combiners_glFinalCombinerInputNV_pointer;
    long NV_register_combiners_glGetCombinerInputParameterfvNV_pointer;
    long NV_register_combiners_glGetCombinerInputParameterivNV_pointer;
    long NV_register_combiners_glGetCombinerOutputParameterfvNV_pointer;
    long NV_register_combiners_glGetCombinerOutputParameterivNV_pointer;
    long NV_register_combiners_glGetFinalCombinerInputParameterfvNV_pointer;
    long NV_register_combiners_glGetFinalCombinerInputParameterivNV_pointer;
    long NV_register_combiners2_glCombinerStageParameterfvNV_pointer;
    long NV_register_combiners2_glGetCombinerStageParameterfvNV_pointer;
    long NV_shader_buffer_load_glMakeBufferResidentNV_pointer;
    long NV_shader_buffer_load_glMakeBufferNonResidentNV_pointer;
    long NV_shader_buffer_load_glIsBufferResidentNV_pointer;
    long NV_shader_buffer_load_glMakeNamedBufferResidentNV_pointer;
    long NV_shader_buffer_load_glMakeNamedBufferNonResidentNV_pointer;
    long NV_shader_buffer_load_glIsNamedBufferResidentNV_pointer;
    long NV_shader_buffer_load_glGetBufferParameterui64vNV_pointer;
    long NV_shader_buffer_load_glGetNamedBufferParameterui64vNV_pointer;
    long NV_shader_buffer_load_glGetIntegerui64vNV_pointer;
    long NV_shader_buffer_load_glUniformui64NV_pointer;
    long NV_shader_buffer_load_glUniformui64vNV_pointer;
    long NV_shader_buffer_load_glGetUniformui64vNV_pointer;
    long NV_shader_buffer_load_glProgramUniformui64NV_pointer;
    long NV_shader_buffer_load_glProgramUniformui64vNV_pointer;
    long NV_texture_barrier_glTextureBarrierNV_pointer;
    long NV_transform_feedback_glBindBufferRangeNV_pointer;
    long NV_transform_feedback_glBindBufferOffsetNV_pointer;
    long NV_transform_feedback_glBindBufferBaseNV_pointer;
    long NV_transform_feedback_glTransformFeedbackAttribsNV_pointer;
    long NV_transform_feedback_glTransformFeedbackVaryingsNV_pointer;
    long NV_transform_feedback_glBeginTransformFeedbackNV_pointer;
    long NV_transform_feedback_glEndTransformFeedbackNV_pointer;
    long NV_transform_feedback_glGetVaryingLocationNV_pointer;
    long NV_transform_feedback_glGetActiveVaryingNV_pointer;
    long NV_transform_feedback_glActiveVaryingNV_pointer;
    long NV_transform_feedback_glGetTransformFeedbackVaryingNV_pointer;
    long NV_transform_feedback2_glBindTransformFeedbackNV_pointer;
    long NV_transform_feedback2_glDeleteTransformFeedbacksNV_pointer;
    long NV_transform_feedback2_glGenTransformFeedbacksNV_pointer;
    long NV_transform_feedback2_glIsTransformFeedbackNV_pointer;
    long NV_transform_feedback2_glPauseTransformFeedbackNV_pointer;
    long NV_transform_feedback2_glResumeTransformFeedbackNV_pointer;
    long NV_transform_feedback2_glDrawTransformFeedbackNV_pointer;
    long NV_vertex_array_range_glVertexArrayRangeNV_pointer;
    long NV_vertex_array_range_glFlushVertexArrayRangeNV_pointer;
    long NV_vertex_array_range_glAllocateMemoryNV_pointer;
    long NV_vertex_array_range_glFreeMemoryNV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL1i64NV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL2i64NV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL3i64NV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL4i64NV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL1i64vNV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL2i64vNV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL3i64vNV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL4i64vNV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL1ui64NV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL2ui64NV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL3ui64NV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL4ui64NV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL1ui64vNV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL2ui64vNV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL3ui64vNV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribL4ui64vNV_pointer;
    long NV_vertex_attrib_integer_64bit_glGetVertexAttribLi64vNV_pointer;
    long NV_vertex_attrib_integer_64bit_glGetVertexAttribLui64vNV_pointer;
    long NV_vertex_attrib_integer_64bit_glVertexAttribLFormatNV_pointer;
    long NV_vertex_buffer_unified_memory_glBufferAddressRangeNV_pointer;
    long NV_vertex_buffer_unified_memory_glVertexFormatNV_pointer;
    long NV_vertex_buffer_unified_memory_glNormalFormatNV_pointer;
    long NV_vertex_buffer_unified_memory_glColorFormatNV_pointer;
    long NV_vertex_buffer_unified_memory_glIndexFormatNV_pointer;
    long NV_vertex_buffer_unified_memory_glTexCoordFormatNV_pointer;
    long NV_vertex_buffer_unified_memory_glEdgeFlagFormatNV_pointer;
    long NV_vertex_buffer_unified_memory_glSecondaryColorFormatNV_pointer;
    long NV_vertex_buffer_unified_memory_glFogCoordFormatNV_pointer;
    long NV_vertex_buffer_unified_memory_glVertexAttribFormatNV_pointer;
    long NV_vertex_buffer_unified_memory_glVertexAttribIFormatNV_pointer;
    long NV_vertex_buffer_unified_memory_glGetIntegerui64i_vNV_pointer;
    long NV_vertex_program_glExecuteProgramNV_pointer;
    long NV_vertex_program_glGetProgramParameterfvNV_pointer;
    long NV_vertex_program_glGetProgramParameterdvNV_pointer;
    long NV_vertex_program_glGetTrackMatrixivNV_pointer;
    long NV_vertex_program_glGetVertexAttribfvNV_pointer;
    long NV_vertex_program_glGetVertexAttribdvNV_pointer;
    long NV_vertex_program_glGetVertexAttribivNV_pointer;
    long NV_vertex_program_glGetVertexAttribPointervNV_pointer;
    long NV_vertex_program_glProgramParameter4fNV_pointer;
    long NV_vertex_program_glProgramParameter4dNV_pointer;
    long NV_vertex_program_glProgramParameters4fvNV_pointer;
    long NV_vertex_program_glProgramParameters4dvNV_pointer;
    long NV_vertex_program_glTrackMatrixNV_pointer;
    long NV_vertex_program_glVertexAttribPointerNV_pointer;
    long NV_vertex_program_glVertexAttrib1sNV_pointer;
    long NV_vertex_program_glVertexAttrib1fNV_pointer;
    long NV_vertex_program_glVertexAttrib1dNV_pointer;
    long NV_vertex_program_glVertexAttrib2sNV_pointer;
    long NV_vertex_program_glVertexAttrib2fNV_pointer;
    long NV_vertex_program_glVertexAttrib2dNV_pointer;
    long NV_vertex_program_glVertexAttrib3sNV_pointer;
    long NV_vertex_program_glVertexAttrib3fNV_pointer;
    long NV_vertex_program_glVertexAttrib3dNV_pointer;
    long NV_vertex_program_glVertexAttrib4sNV_pointer;
    long NV_vertex_program_glVertexAttrib4fNV_pointer;
    long NV_vertex_program_glVertexAttrib4dNV_pointer;
    long NV_vertex_program_glVertexAttrib4ubNV_pointer;
    long NV_vertex_program_glVertexAttribs1svNV_pointer;
    long NV_vertex_program_glVertexAttribs1fvNV_pointer;
    long NV_vertex_program_glVertexAttribs1dvNV_pointer;
    long NV_vertex_program_glVertexAttribs2svNV_pointer;
    long NV_vertex_program_glVertexAttribs2fvNV_pointer;
    long NV_vertex_program_glVertexAttribs2dvNV_pointer;
    long NV_vertex_program_glVertexAttribs3svNV_pointer;
    long NV_vertex_program_glVertexAttribs3fvNV_pointer;
    long NV_vertex_program_glVertexAttribs3dvNV_pointer;
    long NV_vertex_program_glVertexAttribs4svNV_pointer;
    long NV_vertex_program_glVertexAttribs4fvNV_pointer;
    long NV_vertex_program_glVertexAttribs4dvNV_pointer;

    private boolean AMD_draw_buffers_blend_initNativeFunctionAddresses() {
        this.AMD_draw_buffers_blend_glBlendFuncIndexedAMD_pointer = GLContext.getFunctionAddress("glBlendFuncIndexedAMD");
        boolean bl2 = this.AMD_draw_buffers_blend_glBlendFuncIndexedAMD_pointer != 0L;
        this.AMD_draw_buffers_blend_glBlendFuncSeparateIndexedAMD_pointer = GLContext.getFunctionAddress("glBlendFuncSeparateIndexedAMD");
        this.AMD_draw_buffers_blend_glBlendEquationIndexedAMD_pointer = GLContext.getFunctionAddress("glBlendEquationIndexedAMD");
        this.AMD_draw_buffers_blend_glBlendEquationSeparateIndexedAMD_pointer = GLContext.getFunctionAddress("glBlendEquationSeparateIndexedAMD");
        return bl2 & this.AMD_draw_buffers_blend_glBlendFuncSeparateIndexedAMD_pointer != 0L & this.AMD_draw_buffers_blend_glBlendEquationIndexedAMD_pointer != 0L & this.AMD_draw_buffers_blend_glBlendEquationSeparateIndexedAMD_pointer != 0L;
    }

    private boolean AMD_performance_monitor_initNativeFunctionAddresses() {
        this.AMD_performance_monitor_glGetPerfMonitorGroupsAMD_pointer = GLContext.getFunctionAddress("glGetPerfMonitorGroupsAMD");
        boolean bl2 = this.AMD_performance_monitor_glGetPerfMonitorGroupsAMD_pointer != 0L;
        this.AMD_performance_monitor_glGetPerfMonitorCountersAMD_pointer = GLContext.getFunctionAddress("glGetPerfMonitorCountersAMD");
        this.AMD_performance_monitor_glGetPerfMonitorGroupStringAMD_pointer = GLContext.getFunctionAddress("glGetPerfMonitorGroupStringAMD");
        this.AMD_performance_monitor_glGetPerfMonitorCounterStringAMD_pointer = GLContext.getFunctionAddress("glGetPerfMonitorCounterStringAMD");
        this.AMD_performance_monitor_glGetPerfMonitorCounterInfoAMD_pointer = GLContext.getFunctionAddress("glGetPerfMonitorCounterInfoAMD");
        this.AMD_performance_monitor_glGenPerfMonitorsAMD_pointer = GLContext.getFunctionAddress("glGenPerfMonitorsAMD");
        this.AMD_performance_monitor_glDeletePerfMonitorsAMD_pointer = GLContext.getFunctionAddress("glDeletePerfMonitorsAMD");
        this.AMD_performance_monitor_glSelectPerfMonitorCountersAMD_pointer = GLContext.getFunctionAddress("glSelectPerfMonitorCountersAMD");
        this.AMD_performance_monitor_glBeginPerfMonitorAMD_pointer = GLContext.getFunctionAddress("glBeginPerfMonitorAMD");
        this.AMD_performance_monitor_glEndPerfMonitorAMD_pointer = GLContext.getFunctionAddress("glEndPerfMonitorAMD");
        this.AMD_performance_monitor_glGetPerfMonitorCounterDataAMD_pointer = GLContext.getFunctionAddress("glGetPerfMonitorCounterDataAMD");
        return bl2 & this.AMD_performance_monitor_glGetPerfMonitorCountersAMD_pointer != 0L & this.AMD_performance_monitor_glGetPerfMonitorGroupStringAMD_pointer != 0L & this.AMD_performance_monitor_glGetPerfMonitorCounterStringAMD_pointer != 0L & this.AMD_performance_monitor_glGetPerfMonitorCounterInfoAMD_pointer != 0L & this.AMD_performance_monitor_glGenPerfMonitorsAMD_pointer != 0L & this.AMD_performance_monitor_glDeletePerfMonitorsAMD_pointer != 0L & this.AMD_performance_monitor_glSelectPerfMonitorCountersAMD_pointer != 0L & this.AMD_performance_monitor_glBeginPerfMonitorAMD_pointer != 0L & this.AMD_performance_monitor_glEndPerfMonitorAMD_pointer != 0L & this.AMD_performance_monitor_glGetPerfMonitorCounterDataAMD_pointer != 0L;
    }

    private boolean AMD_vertex_shader_tessellator_initNativeFunctionAddresses() {
        this.AMD_vertex_shader_tessellator_glTessellationFactorAMD_pointer = GLContext.getFunctionAddress("glTessellationFactorAMD");
        boolean bl2 = this.AMD_vertex_shader_tessellator_glTessellationFactorAMD_pointer != 0L;
        this.AMD_vertex_shader_tessellator_glTessellationModeAMD_pointer = GLContext.getFunctionAddress("glTessellationModeAMD");
        return bl2 & this.AMD_vertex_shader_tessellator_glTessellationModeAMD_pointer != 0L;
    }

    private boolean APPLE_element_array_initNativeFunctionAddresses() {
        this.APPLE_element_array_glElementPointerAPPLE_pointer = GLContext.getFunctionAddress("glElementPointerAPPLE");
        boolean bl2 = this.APPLE_element_array_glElementPointerAPPLE_pointer != 0L;
        this.APPLE_element_array_glDrawElementArrayAPPLE_pointer = GLContext.getFunctionAddress("glDrawElementArrayAPPLE");
        this.APPLE_element_array_glDrawRangeElementArrayAPPLE_pointer = GLContext.getFunctionAddress("glDrawRangeElementArrayAPPLE");
        this.APPLE_element_array_glMultiDrawElementArrayAPPLE_pointer = GLContext.getFunctionAddress("glMultiDrawElementArrayAPPLE");
        this.APPLE_element_array_glMultiDrawRangeElementArrayAPPLE_pointer = GLContext.getFunctionAddress("glMultiDrawRangeElementArrayAPPLE");
        return bl2 & this.APPLE_element_array_glDrawElementArrayAPPLE_pointer != 0L & this.APPLE_element_array_glDrawRangeElementArrayAPPLE_pointer != 0L & this.APPLE_element_array_glMultiDrawElementArrayAPPLE_pointer != 0L & this.APPLE_element_array_glMultiDrawRangeElementArrayAPPLE_pointer != 0L;
    }

    private boolean APPLE_fence_initNativeFunctionAddresses() {
        this.APPLE_fence_glGenFencesAPPLE_pointer = GLContext.getFunctionAddress("glGenFencesAPPLE");
        boolean bl2 = this.APPLE_fence_glGenFencesAPPLE_pointer != 0L;
        this.APPLE_fence_glDeleteFencesAPPLE_pointer = GLContext.getFunctionAddress("glDeleteFencesAPPLE");
        this.APPLE_fence_glSetFenceAPPLE_pointer = GLContext.getFunctionAddress("glSetFenceAPPLE");
        this.APPLE_fence_glIsFenceAPPLE_pointer = GLContext.getFunctionAddress("glIsFenceAPPLE");
        this.APPLE_fence_glTestFenceAPPLE_pointer = GLContext.getFunctionAddress("glTestFenceAPPLE");
        this.APPLE_fence_glFinishFenceAPPLE_pointer = GLContext.getFunctionAddress("glFinishFenceAPPLE");
        this.APPLE_fence_glTestObjectAPPLE_pointer = GLContext.getFunctionAddress("glTestObjectAPPLE");
        this.APPLE_fence_glFinishObjectAPPLE_pointer = GLContext.getFunctionAddress("glFinishObjectAPPLE");
        return bl2 & this.APPLE_fence_glDeleteFencesAPPLE_pointer != 0L & this.APPLE_fence_glSetFenceAPPLE_pointer != 0L & this.APPLE_fence_glIsFenceAPPLE_pointer != 0L & this.APPLE_fence_glTestFenceAPPLE_pointer != 0L & this.APPLE_fence_glFinishFenceAPPLE_pointer != 0L & this.APPLE_fence_glTestObjectAPPLE_pointer != 0L & this.APPLE_fence_glFinishObjectAPPLE_pointer != 0L;
    }

    private boolean APPLE_flush_buffer_range_initNativeFunctionAddresses() {
        this.APPLE_flush_buffer_range_glBufferParameteriAPPLE_pointer = GLContext.getFunctionAddress("glBufferParameteriAPPLE");
        boolean bl2 = this.APPLE_flush_buffer_range_glBufferParameteriAPPLE_pointer != 0L;
        this.APPLE_flush_buffer_range_glFlushMappedBufferRangeAPPLE_pointer = GLContext.getFunctionAddress("glFlushMappedBufferRangeAPPLE");
        return bl2 & this.APPLE_flush_buffer_range_glFlushMappedBufferRangeAPPLE_pointer != 0L;
    }

    private boolean APPLE_object_purgeable_initNativeFunctionAddresses() {
        this.APPLE_object_purgeable_glObjectPurgeableAPPLE_pointer = GLContext.getFunctionAddress("glObjectPurgeableAPPLE");
        boolean bl2 = this.APPLE_object_purgeable_glObjectPurgeableAPPLE_pointer != 0L;
        this.APPLE_object_purgeable_glObjectUnpurgeableAPPLE_pointer = GLContext.getFunctionAddress("glObjectUnpurgeableAPPLE");
        this.APPLE_object_purgeable_glGetObjectParameterivAPPLE_pointer = GLContext.getFunctionAddress("glGetObjectParameterivAPPLE");
        return bl2 & this.APPLE_object_purgeable_glObjectUnpurgeableAPPLE_pointer != 0L & this.APPLE_object_purgeable_glGetObjectParameterivAPPLE_pointer != 0L;
    }

    private boolean APPLE_texture_range_initNativeFunctionAddresses() {
        this.APPLE_texture_range_glTextureRangeAPPLE_pointer = GLContext.getFunctionAddress("glTextureRangeAPPLE");
        boolean bl2 = this.APPLE_texture_range_glTextureRangeAPPLE_pointer != 0L;
        this.APPLE_texture_range_glGetTexParameterPointervAPPLE_pointer = GLContext.getFunctionAddress("glGetTexParameterPointervAPPLE");
        return bl2 & this.APPLE_texture_range_glGetTexParameterPointervAPPLE_pointer != 0L;
    }

    private boolean APPLE_vertex_array_object_initNativeFunctionAddresses() {
        this.APPLE_vertex_array_object_glBindVertexArrayAPPLE_pointer = GLContext.getFunctionAddress("glBindVertexArrayAPPLE");
        boolean bl2 = this.APPLE_vertex_array_object_glBindVertexArrayAPPLE_pointer != 0L;
        this.APPLE_vertex_array_object_glDeleteVertexArraysAPPLE_pointer = GLContext.getFunctionAddress("glDeleteVertexArraysAPPLE");
        this.APPLE_vertex_array_object_glGenVertexArraysAPPLE_pointer = GLContext.getFunctionAddress("glGenVertexArraysAPPLE");
        this.APPLE_vertex_array_object_glIsVertexArrayAPPLE_pointer = GLContext.getFunctionAddress("glIsVertexArrayAPPLE");
        return bl2 & this.APPLE_vertex_array_object_glDeleteVertexArraysAPPLE_pointer != 0L & this.APPLE_vertex_array_object_glGenVertexArraysAPPLE_pointer != 0L & this.APPLE_vertex_array_object_glIsVertexArrayAPPLE_pointer != 0L;
    }

    private boolean APPLE_vertex_array_range_initNativeFunctionAddresses() {
        this.APPLE_vertex_array_range_glVertexArrayRangeAPPLE_pointer = GLContext.getFunctionAddress("glVertexArrayRangeAPPLE");
        boolean bl2 = this.APPLE_vertex_array_range_glVertexArrayRangeAPPLE_pointer != 0L;
        this.APPLE_vertex_array_range_glFlushVertexArrayRangeAPPLE_pointer = GLContext.getFunctionAddress("glFlushVertexArrayRangeAPPLE");
        this.APPLE_vertex_array_range_glVertexArrayParameteriAPPLE_pointer = GLContext.getFunctionAddress("glVertexArrayParameteriAPPLE");
        return bl2 & this.APPLE_vertex_array_range_glFlushVertexArrayRangeAPPLE_pointer != 0L & this.APPLE_vertex_array_range_glVertexArrayParameteriAPPLE_pointer != 0L;
    }

    private boolean APPLE_vertex_program_evaluators_initNativeFunctionAddresses() {
        this.APPLE_vertex_program_evaluators_glEnableVertexAttribAPPLE_pointer = GLContext.getFunctionAddress("glEnableVertexAttribAPPLE");
        boolean bl2 = this.APPLE_vertex_program_evaluators_glEnableVertexAttribAPPLE_pointer != 0L;
        this.APPLE_vertex_program_evaluators_glDisableVertexAttribAPPLE_pointer = GLContext.getFunctionAddress("glDisableVertexAttribAPPLE");
        this.APPLE_vertex_program_evaluators_glIsVertexAttribEnabledAPPLE_pointer = GLContext.getFunctionAddress("glIsVertexAttribEnabledAPPLE");
        this.APPLE_vertex_program_evaluators_glMapVertexAttrib1dAPPLE_pointer = GLContext.getFunctionAddress("glMapVertexAttrib1dAPPLE");
        this.APPLE_vertex_program_evaluators_glMapVertexAttrib1fAPPLE_pointer = GLContext.getFunctionAddress("glMapVertexAttrib1fAPPLE");
        this.APPLE_vertex_program_evaluators_glMapVertexAttrib2dAPPLE_pointer = GLContext.getFunctionAddress("glMapVertexAttrib2dAPPLE");
        this.APPLE_vertex_program_evaluators_glMapVertexAttrib2fAPPLE_pointer = GLContext.getFunctionAddress("glMapVertexAttrib2fAPPLE");
        return bl2 & this.APPLE_vertex_program_evaluators_glDisableVertexAttribAPPLE_pointer != 0L & this.APPLE_vertex_program_evaluators_glIsVertexAttribEnabledAPPLE_pointer != 0L & this.APPLE_vertex_program_evaluators_glMapVertexAttrib1dAPPLE_pointer != 0L & this.APPLE_vertex_program_evaluators_glMapVertexAttrib1fAPPLE_pointer != 0L & this.APPLE_vertex_program_evaluators_glMapVertexAttrib2dAPPLE_pointer != 0L & this.APPLE_vertex_program_evaluators_glMapVertexAttrib2fAPPLE_pointer != 0L;
    }

    private boolean ARB_blend_func_extended_initNativeFunctionAddresses() {
        this.ARB_blend_func_extended_glBindFragDataLocationIndexed_pointer = GLContext.getFunctionAddress("glBindFragDataLocationIndexed");
        boolean bl2 = this.ARB_blend_func_extended_glBindFragDataLocationIndexed_pointer != 0L;
        this.ARB_blend_func_extended_glGetFragDataIndex_pointer = GLContext.getFunctionAddress("glGetFragDataIndex");
        return bl2 & this.ARB_blend_func_extended_glGetFragDataIndex_pointer != 0L;
    }

    private boolean ARB_buffer_object_initNativeFunctionAddresses() {
        this.ARB_buffer_object_glBindBufferARB_pointer = GLContext.getFunctionAddress("glBindBufferARB");
        boolean bl2 = this.ARB_buffer_object_glBindBufferARB_pointer != 0L;
        this.ARB_buffer_object_glDeleteBuffersARB_pointer = GLContext.getFunctionAddress("glDeleteBuffersARB");
        this.ARB_buffer_object_glGenBuffersARB_pointer = GLContext.getFunctionAddress("glGenBuffersARB");
        this.ARB_buffer_object_glIsBufferARB_pointer = GLContext.getFunctionAddress("glIsBufferARB");
        this.ARB_buffer_object_glBufferDataARB_pointer = GLContext.getFunctionAddress("glBufferDataARB");
        this.ARB_buffer_object_glBufferSubDataARB_pointer = GLContext.getFunctionAddress("glBufferSubDataARB");
        this.ARB_buffer_object_glGetBufferSubDataARB_pointer = GLContext.getFunctionAddress("glGetBufferSubDataARB");
        this.ARB_buffer_object_glMapBufferARB_pointer = GLContext.getFunctionAddress("glMapBufferARB");
        this.ARB_buffer_object_glUnmapBufferARB_pointer = GLContext.getFunctionAddress("glUnmapBufferARB");
        this.ARB_buffer_object_glGetBufferParameterivARB_pointer = GLContext.getFunctionAddress("glGetBufferParameterivARB");
        this.ARB_buffer_object_glGetBufferPointervARB_pointer = GLContext.getFunctionAddress("glGetBufferPointervARB");
        return bl2 & this.ARB_buffer_object_glDeleteBuffersARB_pointer != 0L & this.ARB_buffer_object_glGenBuffersARB_pointer != 0L & this.ARB_buffer_object_glIsBufferARB_pointer != 0L & this.ARB_buffer_object_glBufferDataARB_pointer != 0L & this.ARB_buffer_object_glBufferSubDataARB_pointer != 0L & this.ARB_buffer_object_glGetBufferSubDataARB_pointer != 0L & this.ARB_buffer_object_glMapBufferARB_pointer != 0L & this.ARB_buffer_object_glUnmapBufferARB_pointer != 0L & this.ARB_buffer_object_glGetBufferParameterivARB_pointer != 0L & this.ARB_buffer_object_glGetBufferPointervARB_pointer != 0L;
    }

    private boolean ARB_color_buffer_float_initNativeFunctionAddresses() {
        this.ARB_color_buffer_float_glClampColorARB_pointer = GLContext.getFunctionAddress("glClampColorARB");
        return this.ARB_color_buffer_float_glClampColorARB_pointer != 0L;
    }

    private boolean ARB_copy_buffer_initNativeFunctionAddresses() {
        this.ARB_copy_buffer_glCopyBufferSubData_pointer = GLContext.getFunctionAddress("glCopyBufferSubData");
        return this.ARB_copy_buffer_glCopyBufferSubData_pointer != 0L;
    }

    private boolean ARB_draw_buffers_initNativeFunctionAddresses() {
        this.ARB_draw_buffers_glDrawBuffersARB_pointer = GLContext.getFunctionAddress("glDrawBuffersARB");
        return this.ARB_draw_buffers_glDrawBuffersARB_pointer != 0L;
    }

    private boolean ARB_draw_buffers_blend_initNativeFunctionAddresses() {
        this.ARB_draw_buffers_blend_glBlendEquationiARB_pointer = GLContext.getFunctionAddress("glBlendEquationiARB");
        boolean bl2 = this.ARB_draw_buffers_blend_glBlendEquationiARB_pointer != 0L;
        this.ARB_draw_buffers_blend_glBlendEquationSeparateiARB_pointer = GLContext.getFunctionAddress("glBlendEquationSeparateiARB");
        this.ARB_draw_buffers_blend_glBlendFunciARB_pointer = GLContext.getFunctionAddress("glBlendFunciARB");
        this.ARB_draw_buffers_blend_glBlendFuncSeparateiARB_pointer = GLContext.getFunctionAddress("glBlendFuncSeparateiARB");
        return bl2 & this.ARB_draw_buffers_blend_glBlendEquationSeparateiARB_pointer != 0L & this.ARB_draw_buffers_blend_glBlendFunciARB_pointer != 0L & this.ARB_draw_buffers_blend_glBlendFuncSeparateiARB_pointer != 0L;
    }

    private boolean ARB_draw_elements_base_vertex_initNativeFunctionAddresses() {
        this.ARB_draw_elements_base_vertex_glDrawElementsBaseVertex_pointer = GLContext.getFunctionAddress("glDrawElementsBaseVertex");
        boolean bl2 = this.ARB_draw_elements_base_vertex_glDrawElementsBaseVertex_pointer != 0L;
        this.ARB_draw_elements_base_vertex_glDrawRangeElementsBaseVertex_pointer = GLContext.getFunctionAddress("glDrawRangeElementsBaseVertex");
        this.ARB_draw_elements_base_vertex_glDrawElementsInstancedBaseVertex_pointer = GLContext.getFunctionAddress("glDrawElementsInstancedBaseVertex");
        return bl2 & this.ARB_draw_elements_base_vertex_glDrawRangeElementsBaseVertex_pointer != 0L & this.ARB_draw_elements_base_vertex_glDrawElementsInstancedBaseVertex_pointer != 0L;
    }

    private boolean ARB_draw_indirect_initNativeFunctionAddresses() {
        this.ARB_draw_indirect_glDrawArraysIndirect_pointer = GLContext.getFunctionAddress("glDrawArraysIndirect");
        boolean bl2 = this.ARB_draw_indirect_glDrawArraysIndirect_pointer != 0L;
        this.ARB_draw_indirect_glDrawElementsIndirect_pointer = GLContext.getFunctionAddress("glDrawElementsIndirect");
        return bl2 & this.ARB_draw_indirect_glDrawElementsIndirect_pointer != 0L;
    }

    private boolean ARB_draw_instanced_initNativeFunctionAddresses() {
        this.ARB_draw_instanced_glDrawArraysInstancedARB_pointer = GLContext.getFunctionAddress("glDrawArraysInstancedARB");
        boolean bl2 = this.ARB_draw_instanced_glDrawArraysInstancedARB_pointer != 0L;
        this.ARB_draw_instanced_glDrawElementsInstancedARB_pointer = GLContext.getFunctionAddress("glDrawElementsInstancedARB");
        return bl2 & this.ARB_draw_instanced_glDrawElementsInstancedARB_pointer != 0L;
    }

    private boolean ARB_framebuffer_object_initNativeFunctionAddresses() {
        this.ARB_framebuffer_object_glIsRenderbuffer_pointer = GLContext.getFunctionAddress("glIsRenderbuffer");
        boolean bl2 = this.ARB_framebuffer_object_glIsRenderbuffer_pointer != 0L;
        this.ARB_framebuffer_object_glBindRenderbuffer_pointer = GLContext.getFunctionAddress("glBindRenderbuffer");
        this.ARB_framebuffer_object_glDeleteRenderbuffers_pointer = GLContext.getFunctionAddress("glDeleteRenderbuffers");
        this.ARB_framebuffer_object_glGenRenderbuffers_pointer = GLContext.getFunctionAddress("glGenRenderbuffers");
        this.ARB_framebuffer_object_glRenderbufferStorage_pointer = GLContext.getFunctionAddress("glRenderbufferStorage");
        this.ARB_framebuffer_object_glRenderbufferStorageMultisample_pointer = GLContext.getFunctionAddress("glRenderbufferStorageMultisample");
        this.ARB_framebuffer_object_glGetRenderbufferParameteriv_pointer = GLContext.getFunctionAddress("glGetRenderbufferParameteriv");
        this.ARB_framebuffer_object_glIsFramebuffer_pointer = GLContext.getFunctionAddress("glIsFramebuffer");
        this.ARB_framebuffer_object_glBindFramebuffer_pointer = GLContext.getFunctionAddress("glBindFramebuffer");
        this.ARB_framebuffer_object_glDeleteFramebuffers_pointer = GLContext.getFunctionAddress("glDeleteFramebuffers");
        this.ARB_framebuffer_object_glGenFramebuffers_pointer = GLContext.getFunctionAddress("glGenFramebuffers");
        this.ARB_framebuffer_object_glCheckFramebufferStatus_pointer = GLContext.getFunctionAddress("glCheckFramebufferStatus");
        this.ARB_framebuffer_object_glFramebufferTexture1D_pointer = GLContext.getFunctionAddress("glFramebufferTexture1D");
        this.ARB_framebuffer_object_glFramebufferTexture2D_pointer = GLContext.getFunctionAddress("glFramebufferTexture2D");
        this.ARB_framebuffer_object_glFramebufferTexture3D_pointer = GLContext.getFunctionAddress("glFramebufferTexture3D");
        this.ARB_framebuffer_object_glFramebufferTextureLayer_pointer = GLContext.getFunctionAddress("glFramebufferTextureLayer");
        this.ARB_framebuffer_object_glFramebufferRenderbuffer_pointer = GLContext.getFunctionAddress("glFramebufferRenderbuffer");
        this.ARB_framebuffer_object_glGetFramebufferAttachmentParameteriv_pointer = GLContext.getFunctionAddress("glGetFramebufferAttachmentParameteriv");
        this.ARB_framebuffer_object_glBlitFramebuffer_pointer = GLContext.getFunctionAddress("glBlitFramebuffer");
        this.ARB_framebuffer_object_glGenerateMipmap_pointer = GLContext.getFunctionAddress("glGenerateMipmap");
        return bl2 & this.ARB_framebuffer_object_glBindRenderbuffer_pointer != 0L & this.ARB_framebuffer_object_glDeleteRenderbuffers_pointer != 0L & this.ARB_framebuffer_object_glGenRenderbuffers_pointer != 0L & this.ARB_framebuffer_object_glRenderbufferStorage_pointer != 0L & this.ARB_framebuffer_object_glRenderbufferStorageMultisample_pointer != 0L & this.ARB_framebuffer_object_glGetRenderbufferParameteriv_pointer != 0L & this.ARB_framebuffer_object_glIsFramebuffer_pointer != 0L & this.ARB_framebuffer_object_glBindFramebuffer_pointer != 0L & this.ARB_framebuffer_object_glDeleteFramebuffers_pointer != 0L & this.ARB_framebuffer_object_glGenFramebuffers_pointer != 0L & this.ARB_framebuffer_object_glCheckFramebufferStatus_pointer != 0L & this.ARB_framebuffer_object_glFramebufferTexture1D_pointer != 0L & this.ARB_framebuffer_object_glFramebufferTexture2D_pointer != 0L & this.ARB_framebuffer_object_glFramebufferTexture3D_pointer != 0L & this.ARB_framebuffer_object_glFramebufferTextureLayer_pointer != 0L & this.ARB_framebuffer_object_glFramebufferRenderbuffer_pointer != 0L & this.ARB_framebuffer_object_glGetFramebufferAttachmentParameteriv_pointer != 0L & this.ARB_framebuffer_object_glBlitFramebuffer_pointer != 0L & this.ARB_framebuffer_object_glGenerateMipmap_pointer != 0L;
    }

    private boolean ARB_geometry_shader4_initNativeFunctionAddresses() {
        this.ARB_geometry_shader4_glProgramParameteriARB_pointer = GLContext.getFunctionAddress("glProgramParameteriARB");
        boolean bl2 = this.ARB_geometry_shader4_glProgramParameteriARB_pointer != 0L;
        this.ARB_geometry_shader4_glFramebufferTextureARB_pointer = GLContext.getFunctionAddress("glFramebufferTextureARB");
        this.ARB_geometry_shader4_glFramebufferTextureLayerARB_pointer = GLContext.getFunctionAddress("glFramebufferTextureLayerARB");
        this.ARB_geometry_shader4_glFramebufferTextureFaceARB_pointer = GLContext.getFunctionAddress("glFramebufferTextureFaceARB");
        return bl2 & this.ARB_geometry_shader4_glFramebufferTextureARB_pointer != 0L & this.ARB_geometry_shader4_glFramebufferTextureLayerARB_pointer != 0L & this.ARB_geometry_shader4_glFramebufferTextureFaceARB_pointer != 0L;
    }

    private boolean ARB_gpu_shader_fp64_initNativeFunctionAddresses(Set supported_extensions) {
        this.ARB_gpu_shader_fp64_glUniform1d_pointer = GLContext.getFunctionAddress("glUniform1d");
        boolean bl2 = this.ARB_gpu_shader_fp64_glUniform1d_pointer != 0L;
        this.ARB_gpu_shader_fp64_glUniform2d_pointer = GLContext.getFunctionAddress("glUniform2d");
        this.ARB_gpu_shader_fp64_glUniform3d_pointer = GLContext.getFunctionAddress("glUniform3d");
        this.ARB_gpu_shader_fp64_glUniform4d_pointer = GLContext.getFunctionAddress("glUniform4d");
        this.ARB_gpu_shader_fp64_glUniform1dv_pointer = GLContext.getFunctionAddress("glUniform1dv");
        this.ARB_gpu_shader_fp64_glUniform2dv_pointer = GLContext.getFunctionAddress("glUniform2dv");
        this.ARB_gpu_shader_fp64_glUniform3dv_pointer = GLContext.getFunctionAddress("glUniform3dv");
        this.ARB_gpu_shader_fp64_glUniform4dv_pointer = GLContext.getFunctionAddress("glUniform4dv");
        this.ARB_gpu_shader_fp64_glUniformMatrix2dv_pointer = GLContext.getFunctionAddress("glUniformMatrix2dv");
        this.ARB_gpu_shader_fp64_glUniformMatrix3dv_pointer = GLContext.getFunctionAddress("glUniformMatrix3dv");
        this.ARB_gpu_shader_fp64_glUniformMatrix4dv_pointer = GLContext.getFunctionAddress("glUniformMatrix4dv");
        this.ARB_gpu_shader_fp64_glUniformMatrix2x3dv_pointer = GLContext.getFunctionAddress("glUniformMatrix2x3dv");
        this.ARB_gpu_shader_fp64_glUniformMatrix2x4dv_pointer = GLContext.getFunctionAddress("glUniformMatrix2x4dv");
        this.ARB_gpu_shader_fp64_glUniformMatrix3x2dv_pointer = GLContext.getFunctionAddress("glUniformMatrix3x2dv");
        this.ARB_gpu_shader_fp64_glUniformMatrix3x4dv_pointer = GLContext.getFunctionAddress("glUniformMatrix3x4dv");
        this.ARB_gpu_shader_fp64_glUniformMatrix4x2dv_pointer = GLContext.getFunctionAddress("glUniformMatrix4x2dv");
        this.ARB_gpu_shader_fp64_glUniformMatrix4x3dv_pointer = GLContext.getFunctionAddress("glUniformMatrix4x3dv");
        this.ARB_gpu_shader_fp64_glGetUniformdv_pointer = GLContext.getFunctionAddress("glGetUniformdv");
        return bl2 & this.ARB_gpu_shader_fp64_glUniform2d_pointer != 0L & this.ARB_gpu_shader_fp64_glUniform3d_pointer != 0L & this.ARB_gpu_shader_fp64_glUniform4d_pointer != 0L & this.ARB_gpu_shader_fp64_glUniform1dv_pointer != 0L & this.ARB_gpu_shader_fp64_glUniform2dv_pointer != 0L & this.ARB_gpu_shader_fp64_glUniform3dv_pointer != 0L & this.ARB_gpu_shader_fp64_glUniform4dv_pointer != 0L & this.ARB_gpu_shader_fp64_glUniformMatrix2dv_pointer != 0L & this.ARB_gpu_shader_fp64_glUniformMatrix3dv_pointer != 0L & this.ARB_gpu_shader_fp64_glUniformMatrix4dv_pointer != 0L & this.ARB_gpu_shader_fp64_glUniformMatrix2x3dv_pointer != 0L & this.ARB_gpu_shader_fp64_glUniformMatrix2x4dv_pointer != 0L & this.ARB_gpu_shader_fp64_glUniformMatrix3x2dv_pointer != 0L & this.ARB_gpu_shader_fp64_glUniformMatrix3x4dv_pointer != 0L & this.ARB_gpu_shader_fp64_glUniformMatrix4x2dv_pointer != 0L & this.ARB_gpu_shader_fp64_glUniformMatrix4x3dv_pointer != 0L & this.ARB_gpu_shader_fp64_glGetUniformdv_pointer != 0L & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniform1dEXT_pointer = GLContext.getFunctionAddress("glProgramUniform1dEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniform2dEXT_pointer = GLContext.getFunctionAddress("glProgramUniform2dEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniform3dEXT_pointer = GLContext.getFunctionAddress("glProgramUniform3dEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniform4dEXT_pointer = GLContext.getFunctionAddress("glProgramUniform4dEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniform1dvEXT_pointer = GLContext.getFunctionAddress("glProgramUniform1dvEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniform2dvEXT_pointer = GLContext.getFunctionAddress("glProgramUniform2dvEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniform3dvEXT_pointer = GLContext.getFunctionAddress("glProgramUniform3dvEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniform4dvEXT_pointer = GLContext.getFunctionAddress("glProgramUniform4dvEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniformMatrix2dvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix2dvEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniformMatrix3dvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix3dvEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniformMatrix4dvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix4dvEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniformMatrix2x3dvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix2x3dvEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniformMatrix2x4dvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix2x4dvEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniformMatrix3x2dvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix3x2dvEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniformMatrix3x4dvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix3x4dvEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniformMatrix4x2dvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix4x2dvEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_direct_state_access") || (this.ARB_gpu_shader_fp64_glProgramUniformMatrix4x3dvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix4x3dvEXT")) != 0L);
    }

    private boolean ARB_imaging_initNativeFunctionAddresses(boolean forwardCompatible) {
        boolean bl2 = (forwardCompatible || (this.ARB_imaging_glColorTable_pointer = GLContext.getFunctionAddress("glColorTable")) != 0L) & (forwardCompatible || (this.ARB_imaging_glColorSubTable_pointer = GLContext.getFunctionAddress("glColorSubTable")) != 0L) & (forwardCompatible || (this.ARB_imaging_glColorTableParameteriv_pointer = GLContext.getFunctionAddress("glColorTableParameteriv")) != 0L) & (forwardCompatible || (this.ARB_imaging_glColorTableParameterfv_pointer = GLContext.getFunctionAddress("glColorTableParameterfv")) != 0L) & (forwardCompatible || (this.ARB_imaging_glCopyColorSubTable_pointer = GLContext.getFunctionAddress("glCopyColorSubTable")) != 0L) & (forwardCompatible || (this.ARB_imaging_glCopyColorTable_pointer = GLContext.getFunctionAddress("glCopyColorTable")) != 0L) & (forwardCompatible || (this.ARB_imaging_glGetColorTable_pointer = GLContext.getFunctionAddress("glGetColorTable")) != 0L) & (forwardCompatible || (this.ARB_imaging_glGetColorTableParameteriv_pointer = GLContext.getFunctionAddress("glGetColorTableParameteriv")) != 0L) & (forwardCompatible || (this.ARB_imaging_glGetColorTableParameterfv_pointer = GLContext.getFunctionAddress("glGetColorTableParameterfv")) != 0L);
        this.ARB_imaging_glBlendEquation_pointer = GLContext.getFunctionAddress("glBlendEquation");
        this.ARB_imaging_glBlendColor_pointer = GLContext.getFunctionAddress("glBlendColor");
        return bl2 & this.ARB_imaging_glBlendEquation_pointer != 0L & this.ARB_imaging_glBlendColor_pointer != 0L & (forwardCompatible || (this.ARB_imaging_glHistogram_pointer = GLContext.getFunctionAddress("glHistogram")) != 0L) & (forwardCompatible || (this.ARB_imaging_glResetHistogram_pointer = GLContext.getFunctionAddress("glResetHistogram")) != 0L) & (forwardCompatible || (this.ARB_imaging_glGetHistogram_pointer = GLContext.getFunctionAddress("glGetHistogram")) != 0L) & (forwardCompatible || (this.ARB_imaging_glGetHistogramParameterfv_pointer = GLContext.getFunctionAddress("glGetHistogramParameterfv")) != 0L) & (forwardCompatible || (this.ARB_imaging_glGetHistogramParameteriv_pointer = GLContext.getFunctionAddress("glGetHistogramParameteriv")) != 0L) & (forwardCompatible || (this.ARB_imaging_glMinmax_pointer = GLContext.getFunctionAddress("glMinmax")) != 0L) & (forwardCompatible || (this.ARB_imaging_glResetMinmax_pointer = GLContext.getFunctionAddress("glResetMinmax")) != 0L) & (forwardCompatible || (this.ARB_imaging_glGetMinmax_pointer = GLContext.getFunctionAddress("glGetMinmax")) != 0L) & (forwardCompatible || (this.ARB_imaging_glGetMinmaxParameterfv_pointer = GLContext.getFunctionAddress("glGetMinmaxParameterfv")) != 0L) & (forwardCompatible || (this.ARB_imaging_glGetMinmaxParameteriv_pointer = GLContext.getFunctionAddress("glGetMinmaxParameteriv")) != 0L) & (forwardCompatible || (this.ARB_imaging_glConvolutionFilter1D_pointer = GLContext.getFunctionAddress("glConvolutionFilter1D")) != 0L) & (forwardCompatible || (this.ARB_imaging_glConvolutionFilter2D_pointer = GLContext.getFunctionAddress("glConvolutionFilter2D")) != 0L) & (forwardCompatible || (this.ARB_imaging_glConvolutionParameterf_pointer = GLContext.getFunctionAddress("glConvolutionParameterf")) != 0L) & (forwardCompatible || (this.ARB_imaging_glConvolutionParameterfv_pointer = GLContext.getFunctionAddress("glConvolutionParameterfv")) != 0L) & (forwardCompatible || (this.ARB_imaging_glConvolutionParameteri_pointer = GLContext.getFunctionAddress("glConvolutionParameteri")) != 0L) & (forwardCompatible || (this.ARB_imaging_glConvolutionParameteriv_pointer = GLContext.getFunctionAddress("glConvolutionParameteriv")) != 0L) & (forwardCompatible || (this.ARB_imaging_glCopyConvolutionFilter1D_pointer = GLContext.getFunctionAddress("glCopyConvolutionFilter1D")) != 0L) & (forwardCompatible || (this.ARB_imaging_glCopyConvolutionFilter2D_pointer = GLContext.getFunctionAddress("glCopyConvolutionFilter2D")) != 0L) & (forwardCompatible || (this.ARB_imaging_glGetConvolutionFilter_pointer = GLContext.getFunctionAddress("glGetConvolutionFilter")) != 0L) & (forwardCompatible || (this.ARB_imaging_glGetConvolutionParameterfv_pointer = GLContext.getFunctionAddress("glGetConvolutionParameterfv")) != 0L) & (forwardCompatible || (this.ARB_imaging_glGetConvolutionParameteriv_pointer = GLContext.getFunctionAddress("glGetConvolutionParameteriv")) != 0L) & (forwardCompatible || (this.ARB_imaging_glSeparableFilter2D_pointer = GLContext.getFunctionAddress("glSeparableFilter2D")) != 0L) & (forwardCompatible || (this.ARB_imaging_glGetSeparableFilter_pointer = GLContext.getFunctionAddress("glGetSeparableFilter")) != 0L);
    }

    private boolean ARB_instanced_arrays_initNativeFunctionAddresses() {
        this.ARB_instanced_arrays_glVertexAttribDivisorARB_pointer = GLContext.getFunctionAddress("glVertexAttribDivisorARB");
        return this.ARB_instanced_arrays_glVertexAttribDivisorARB_pointer != 0L;
    }

    private boolean ARB_map_buffer_range_initNativeFunctionAddresses() {
        this.ARB_map_buffer_range_glMapBufferRange_pointer = GLContext.getFunctionAddress("glMapBufferRange");
        boolean bl2 = this.ARB_map_buffer_range_glMapBufferRange_pointer != 0L;
        this.ARB_map_buffer_range_glFlushMappedBufferRange_pointer = GLContext.getFunctionAddress("glFlushMappedBufferRange");
        return bl2 & this.ARB_map_buffer_range_glFlushMappedBufferRange_pointer != 0L;
    }

    private boolean ARB_matrix_palette_initNativeFunctionAddresses() {
        this.ARB_matrix_palette_glCurrentPaletteMatrixARB_pointer = GLContext.getFunctionAddress("glCurrentPaletteMatrixARB");
        boolean bl2 = this.ARB_matrix_palette_glCurrentPaletteMatrixARB_pointer != 0L;
        this.ARB_matrix_palette_glMatrixIndexPointerARB_pointer = GLContext.getFunctionAddress("glMatrixIndexPointerARB");
        this.ARB_matrix_palette_glMatrixIndexubvARB_pointer = GLContext.getFunctionAddress("glMatrixIndexubvARB");
        this.ARB_matrix_palette_glMatrixIndexusvARB_pointer = GLContext.getFunctionAddress("glMatrixIndexusvARB");
        this.ARB_matrix_palette_glMatrixIndexuivARB_pointer = GLContext.getFunctionAddress("glMatrixIndexuivARB");
        return bl2 & this.ARB_matrix_palette_glMatrixIndexPointerARB_pointer != 0L & this.ARB_matrix_palette_glMatrixIndexubvARB_pointer != 0L & this.ARB_matrix_palette_glMatrixIndexusvARB_pointer != 0L & this.ARB_matrix_palette_glMatrixIndexuivARB_pointer != 0L;
    }

    private boolean ARB_multisample_initNativeFunctionAddresses() {
        this.ARB_multisample_glSampleCoverageARB_pointer = GLContext.getFunctionAddress("glSampleCoverageARB");
        return this.ARB_multisample_glSampleCoverageARB_pointer != 0L;
    }

    private boolean ARB_multitexture_initNativeFunctionAddresses() {
        this.ARB_multitexture_glClientActiveTextureARB_pointer = GLContext.getFunctionAddress("glClientActiveTextureARB");
        boolean bl2 = this.ARB_multitexture_glClientActiveTextureARB_pointer != 0L;
        this.ARB_multitexture_glActiveTextureARB_pointer = GLContext.getFunctionAddress("glActiveTextureARB");
        this.ARB_multitexture_glMultiTexCoord1fARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord1fARB");
        this.ARB_multitexture_glMultiTexCoord1dARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord1dARB");
        this.ARB_multitexture_glMultiTexCoord1iARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord1iARB");
        this.ARB_multitexture_glMultiTexCoord1sARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord1sARB");
        this.ARB_multitexture_glMultiTexCoord2fARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord2fARB");
        this.ARB_multitexture_glMultiTexCoord2dARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord2dARB");
        this.ARB_multitexture_glMultiTexCoord2iARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord2iARB");
        this.ARB_multitexture_glMultiTexCoord2sARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord2sARB");
        this.ARB_multitexture_glMultiTexCoord3fARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord3fARB");
        this.ARB_multitexture_glMultiTexCoord3dARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord3dARB");
        this.ARB_multitexture_glMultiTexCoord3iARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord3iARB");
        this.ARB_multitexture_glMultiTexCoord3sARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord3sARB");
        this.ARB_multitexture_glMultiTexCoord4fARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord4fARB");
        this.ARB_multitexture_glMultiTexCoord4dARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord4dARB");
        this.ARB_multitexture_glMultiTexCoord4iARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord4iARB");
        this.ARB_multitexture_glMultiTexCoord4sARB_pointer = GLContext.getFunctionAddress("glMultiTexCoord4sARB");
        return bl2 & this.ARB_multitexture_glActiveTextureARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord1fARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord1dARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord1iARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord1sARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord2fARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord2dARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord2iARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord2sARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord3fARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord3dARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord3iARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord3sARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord4fARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord4dARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord4iARB_pointer != 0L & this.ARB_multitexture_glMultiTexCoord4sARB_pointer != 0L;
    }

    private boolean ARB_occlusion_query_initNativeFunctionAddresses() {
        this.ARB_occlusion_query_glGenQueriesARB_pointer = GLContext.getFunctionAddress("glGenQueriesARB");
        boolean bl2 = this.ARB_occlusion_query_glGenQueriesARB_pointer != 0L;
        this.ARB_occlusion_query_glDeleteQueriesARB_pointer = GLContext.getFunctionAddress("glDeleteQueriesARB");
        this.ARB_occlusion_query_glIsQueryARB_pointer = GLContext.getFunctionAddress("glIsQueryARB");
        this.ARB_occlusion_query_glBeginQueryARB_pointer = GLContext.getFunctionAddress("glBeginQueryARB");
        this.ARB_occlusion_query_glEndQueryARB_pointer = GLContext.getFunctionAddress("glEndQueryARB");
        this.ARB_occlusion_query_glGetQueryivARB_pointer = GLContext.getFunctionAddress("glGetQueryivARB");
        this.ARB_occlusion_query_glGetQueryObjectivARB_pointer = GLContext.getFunctionAddress("glGetQueryObjectivARB");
        this.ARB_occlusion_query_glGetQueryObjectuivARB_pointer = GLContext.getFunctionAddress("glGetQueryObjectuivARB");
        return bl2 & this.ARB_occlusion_query_glDeleteQueriesARB_pointer != 0L & this.ARB_occlusion_query_glIsQueryARB_pointer != 0L & this.ARB_occlusion_query_glBeginQueryARB_pointer != 0L & this.ARB_occlusion_query_glEndQueryARB_pointer != 0L & this.ARB_occlusion_query_glGetQueryivARB_pointer != 0L & this.ARB_occlusion_query_glGetQueryObjectivARB_pointer != 0L & this.ARB_occlusion_query_glGetQueryObjectuivARB_pointer != 0L;
    }

    private boolean ARB_point_parameters_initNativeFunctionAddresses() {
        this.ARB_point_parameters_glPointParameterfARB_pointer = GLContext.getFunctionAddress("glPointParameterfARB");
        boolean bl2 = this.ARB_point_parameters_glPointParameterfARB_pointer != 0L;
        this.ARB_point_parameters_glPointParameterfvARB_pointer = GLContext.getFunctionAddress("glPointParameterfvARB");
        return bl2 & this.ARB_point_parameters_glPointParameterfvARB_pointer != 0L;
    }

    private boolean ARB_program_initNativeFunctionAddresses() {
        this.ARB_program_glProgramStringARB_pointer = GLContext.getFunctionAddress("glProgramStringARB");
        boolean bl2 = this.ARB_program_glProgramStringARB_pointer != 0L;
        this.ARB_program_glBindProgramARB_pointer = GLContext.getFunctionAddress("glBindProgramARB");
        this.ARB_program_glDeleteProgramsARB_pointer = GLContext.getFunctionAddress("glDeleteProgramsARB");
        this.ARB_program_glGenProgramsARB_pointer = GLContext.getFunctionAddress("glGenProgramsARB");
        this.ARB_program_glProgramEnvParameter4fARB_pointer = GLContext.getFunctionAddress("glProgramEnvParameter4fARB");
        this.ARB_program_glProgramEnvParameter4dARB_pointer = GLContext.getFunctionAddress("glProgramEnvParameter4dARB");
        this.ARB_program_glProgramEnvParameter4fvARB_pointer = GLContext.getFunctionAddress("glProgramEnvParameter4fvARB");
        this.ARB_program_glProgramEnvParameter4dvARB_pointer = GLContext.getFunctionAddress("glProgramEnvParameter4dvARB");
        this.ARB_program_glProgramLocalParameter4fARB_pointer = GLContext.getFunctionAddress("glProgramLocalParameter4fARB");
        this.ARB_program_glProgramLocalParameter4dARB_pointer = GLContext.getFunctionAddress("glProgramLocalParameter4dARB");
        this.ARB_program_glProgramLocalParameter4fvARB_pointer = GLContext.getFunctionAddress("glProgramLocalParameter4fvARB");
        this.ARB_program_glProgramLocalParameter4dvARB_pointer = GLContext.getFunctionAddress("glProgramLocalParameter4dvARB");
        this.ARB_program_glGetProgramEnvParameterfvARB_pointer = GLContext.getFunctionAddress("glGetProgramEnvParameterfvARB");
        this.ARB_program_glGetProgramEnvParameterdvARB_pointer = GLContext.getFunctionAddress("glGetProgramEnvParameterdvARB");
        this.ARB_program_glGetProgramLocalParameterfvARB_pointer = GLContext.getFunctionAddress("glGetProgramLocalParameterfvARB");
        this.ARB_program_glGetProgramLocalParameterdvARB_pointer = GLContext.getFunctionAddress("glGetProgramLocalParameterdvARB");
        this.ARB_program_glGetProgramivARB_pointer = GLContext.getFunctionAddress("glGetProgramivARB");
        this.ARB_program_glGetProgramStringARB_pointer = GLContext.getFunctionAddress("glGetProgramStringARB");
        this.ARB_program_glIsProgramARB_pointer = GLContext.getFunctionAddress("glIsProgramARB");
        return bl2 & this.ARB_program_glBindProgramARB_pointer != 0L & this.ARB_program_glDeleteProgramsARB_pointer != 0L & this.ARB_program_glGenProgramsARB_pointer != 0L & this.ARB_program_glProgramEnvParameter4fARB_pointer != 0L & this.ARB_program_glProgramEnvParameter4dARB_pointer != 0L & this.ARB_program_glProgramEnvParameter4fvARB_pointer != 0L & this.ARB_program_glProgramEnvParameter4dvARB_pointer != 0L & this.ARB_program_glProgramLocalParameter4fARB_pointer != 0L & this.ARB_program_glProgramLocalParameter4dARB_pointer != 0L & this.ARB_program_glProgramLocalParameter4fvARB_pointer != 0L & this.ARB_program_glProgramLocalParameter4dvARB_pointer != 0L & this.ARB_program_glGetProgramEnvParameterfvARB_pointer != 0L & this.ARB_program_glGetProgramEnvParameterdvARB_pointer != 0L & this.ARB_program_glGetProgramLocalParameterfvARB_pointer != 0L & this.ARB_program_glGetProgramLocalParameterdvARB_pointer != 0L & this.ARB_program_glGetProgramivARB_pointer != 0L & this.ARB_program_glGetProgramStringARB_pointer != 0L & this.ARB_program_glIsProgramARB_pointer != 0L;
    }

    private boolean ARB_provoking_vertex_initNativeFunctionAddresses() {
        this.ARB_provoking_vertex_glProvokingVertex_pointer = GLContext.getFunctionAddress("glProvokingVertex");
        return this.ARB_provoking_vertex_glProvokingVertex_pointer != 0L;
    }

    private boolean ARB_sample_shading_initNativeFunctionAddresses() {
        this.ARB_sample_shading_glMinSampleShadingARB_pointer = GLContext.getFunctionAddress("glMinSampleShadingARB");
        return this.ARB_sample_shading_glMinSampleShadingARB_pointer != 0L;
    }

    private boolean ARB_sampler_objects_initNativeFunctionAddresses() {
        this.ARB_sampler_objects_glGenSamplers_pointer = GLContext.getFunctionAddress("glGenSamplers");
        boolean bl2 = this.ARB_sampler_objects_glGenSamplers_pointer != 0L;
        this.ARB_sampler_objects_glDeleteSamplers_pointer = GLContext.getFunctionAddress("glDeleteSamplers");
        this.ARB_sampler_objects_glIsSampler_pointer = GLContext.getFunctionAddress("glIsSampler");
        this.ARB_sampler_objects_glBindSampler_pointer = GLContext.getFunctionAddress("glBindSampler");
        this.ARB_sampler_objects_glSamplerParameteri_pointer = GLContext.getFunctionAddress("glSamplerParameteri");
        this.ARB_sampler_objects_glSamplerParameterf_pointer = GLContext.getFunctionAddress("glSamplerParameterf");
        this.ARB_sampler_objects_glSamplerParameteriv_pointer = GLContext.getFunctionAddress("glSamplerParameteriv");
        this.ARB_sampler_objects_glSamplerParameterfv_pointer = GLContext.getFunctionAddress("glSamplerParameterfv");
        this.ARB_sampler_objects_glSamplerParameterIiv_pointer = GLContext.getFunctionAddress("glSamplerParameterIiv");
        this.ARB_sampler_objects_glSamplerParameterIuiv_pointer = GLContext.getFunctionAddress("glSamplerParameterIuiv");
        this.ARB_sampler_objects_glGetSamplerParameteriv_pointer = GLContext.getFunctionAddress("glGetSamplerParameteriv");
        this.ARB_sampler_objects_glGetSamplerParameterfv_pointer = GLContext.getFunctionAddress("glGetSamplerParameterfv");
        this.ARB_sampler_objects_glGetSamplerParameterIiv_pointer = GLContext.getFunctionAddress("glGetSamplerParameterIiv");
        this.ARB_sampler_objects_glGetSamplerParameterIuiv_pointer = GLContext.getFunctionAddress("glGetSamplerParameterIuiv");
        return bl2 & this.ARB_sampler_objects_glDeleteSamplers_pointer != 0L & this.ARB_sampler_objects_glIsSampler_pointer != 0L & this.ARB_sampler_objects_glBindSampler_pointer != 0L & this.ARB_sampler_objects_glSamplerParameteri_pointer != 0L & this.ARB_sampler_objects_glSamplerParameterf_pointer != 0L & this.ARB_sampler_objects_glSamplerParameteriv_pointer != 0L & this.ARB_sampler_objects_glSamplerParameterfv_pointer != 0L & this.ARB_sampler_objects_glSamplerParameterIiv_pointer != 0L & this.ARB_sampler_objects_glSamplerParameterIuiv_pointer != 0L & this.ARB_sampler_objects_glGetSamplerParameteriv_pointer != 0L & this.ARB_sampler_objects_glGetSamplerParameterfv_pointer != 0L & this.ARB_sampler_objects_glGetSamplerParameterIiv_pointer != 0L & this.ARB_sampler_objects_glGetSamplerParameterIuiv_pointer != 0L;
    }

    private boolean ARB_shader_objects_initNativeFunctionAddresses() {
        this.ARB_shader_objects_glDeleteObjectARB_pointer = GLContext.getFunctionAddress("glDeleteObjectARB");
        boolean bl2 = this.ARB_shader_objects_glDeleteObjectARB_pointer != 0L;
        this.ARB_shader_objects_glGetHandleARB_pointer = GLContext.getFunctionAddress("glGetHandleARB");
        this.ARB_shader_objects_glDetachObjectARB_pointer = GLContext.getFunctionAddress("glDetachObjectARB");
        this.ARB_shader_objects_glCreateShaderObjectARB_pointer = GLContext.getFunctionAddress("glCreateShaderObjectARB");
        this.ARB_shader_objects_glShaderSourceARB_pointer = GLContext.getFunctionAddress("glShaderSourceARB");
        this.ARB_shader_objects_glCompileShaderARB_pointer = GLContext.getFunctionAddress("glCompileShaderARB");
        this.ARB_shader_objects_glCreateProgramObjectARB_pointer = GLContext.getFunctionAddress("glCreateProgramObjectARB");
        this.ARB_shader_objects_glAttachObjectARB_pointer = GLContext.getFunctionAddress("glAttachObjectARB");
        this.ARB_shader_objects_glLinkProgramARB_pointer = GLContext.getFunctionAddress("glLinkProgramARB");
        this.ARB_shader_objects_glUseProgramObjectARB_pointer = GLContext.getFunctionAddress("glUseProgramObjectARB");
        this.ARB_shader_objects_glValidateProgramARB_pointer = GLContext.getFunctionAddress("glValidateProgramARB");
        this.ARB_shader_objects_glUniform1fARB_pointer = GLContext.getFunctionAddress("glUniform1fARB");
        this.ARB_shader_objects_glUniform2fARB_pointer = GLContext.getFunctionAddress("glUniform2fARB");
        this.ARB_shader_objects_glUniform3fARB_pointer = GLContext.getFunctionAddress("glUniform3fARB");
        this.ARB_shader_objects_glUniform4fARB_pointer = GLContext.getFunctionAddress("glUniform4fARB");
        this.ARB_shader_objects_glUniform1iARB_pointer = GLContext.getFunctionAddress("glUniform1iARB");
        this.ARB_shader_objects_glUniform2iARB_pointer = GLContext.getFunctionAddress("glUniform2iARB");
        this.ARB_shader_objects_glUniform3iARB_pointer = GLContext.getFunctionAddress("glUniform3iARB");
        this.ARB_shader_objects_glUniform4iARB_pointer = GLContext.getFunctionAddress("glUniform4iARB");
        this.ARB_shader_objects_glUniform1fvARB_pointer = GLContext.getFunctionAddress("glUniform1fvARB");
        this.ARB_shader_objects_glUniform2fvARB_pointer = GLContext.getFunctionAddress("glUniform2fvARB");
        this.ARB_shader_objects_glUniform3fvARB_pointer = GLContext.getFunctionAddress("glUniform3fvARB");
        this.ARB_shader_objects_glUniform4fvARB_pointer = GLContext.getFunctionAddress("glUniform4fvARB");
        this.ARB_shader_objects_glUniform1ivARB_pointer = GLContext.getFunctionAddress("glUniform1ivARB");
        this.ARB_shader_objects_glUniform2ivARB_pointer = GLContext.getFunctionAddress("glUniform2ivARB");
        this.ARB_shader_objects_glUniform3ivARB_pointer = GLContext.getFunctionAddress("glUniform3ivARB");
        this.ARB_shader_objects_glUniform4ivARB_pointer = GLContext.getFunctionAddress("glUniform4ivARB");
        this.ARB_shader_objects_glUniformMatrix2fvARB_pointer = GLContext.getFunctionAddress("glUniformMatrix2fvARB");
        this.ARB_shader_objects_glUniformMatrix3fvARB_pointer = GLContext.getFunctionAddress("glUniformMatrix3fvARB");
        this.ARB_shader_objects_glUniformMatrix4fvARB_pointer = GLContext.getFunctionAddress("glUniformMatrix4fvARB");
        this.ARB_shader_objects_glGetObjectParameterfvARB_pointer = GLContext.getFunctionAddress("glGetObjectParameterfvARB");
        this.ARB_shader_objects_glGetObjectParameterivARB_pointer = GLContext.getFunctionAddress("glGetObjectParameterivARB");
        this.ARB_shader_objects_glGetInfoLogARB_pointer = GLContext.getFunctionAddress("glGetInfoLogARB");
        this.ARB_shader_objects_glGetAttachedObjectsARB_pointer = GLContext.getFunctionAddress("glGetAttachedObjectsARB");
        this.ARB_shader_objects_glGetUniformLocationARB_pointer = GLContext.getFunctionAddress("glGetUniformLocationARB");
        this.ARB_shader_objects_glGetActiveUniformARB_pointer = GLContext.getFunctionAddress("glGetActiveUniformARB");
        this.ARB_shader_objects_glGetUniformfvARB_pointer = GLContext.getFunctionAddress("glGetUniformfvARB");
        this.ARB_shader_objects_glGetUniformivARB_pointer = GLContext.getFunctionAddress("glGetUniformivARB");
        this.ARB_shader_objects_glGetShaderSourceARB_pointer = GLContext.getFunctionAddress("glGetShaderSourceARB");
        return bl2 & this.ARB_shader_objects_glGetHandleARB_pointer != 0L & this.ARB_shader_objects_glDetachObjectARB_pointer != 0L & this.ARB_shader_objects_glCreateShaderObjectARB_pointer != 0L & this.ARB_shader_objects_glShaderSourceARB_pointer != 0L & this.ARB_shader_objects_glCompileShaderARB_pointer != 0L & this.ARB_shader_objects_glCreateProgramObjectARB_pointer != 0L & this.ARB_shader_objects_glAttachObjectARB_pointer != 0L & this.ARB_shader_objects_glLinkProgramARB_pointer != 0L & this.ARB_shader_objects_glUseProgramObjectARB_pointer != 0L & this.ARB_shader_objects_glValidateProgramARB_pointer != 0L & this.ARB_shader_objects_glUniform1fARB_pointer != 0L & this.ARB_shader_objects_glUniform2fARB_pointer != 0L & this.ARB_shader_objects_glUniform3fARB_pointer != 0L & this.ARB_shader_objects_glUniform4fARB_pointer != 0L & this.ARB_shader_objects_glUniform1iARB_pointer != 0L & this.ARB_shader_objects_glUniform2iARB_pointer != 0L & this.ARB_shader_objects_glUniform3iARB_pointer != 0L & this.ARB_shader_objects_glUniform4iARB_pointer != 0L & this.ARB_shader_objects_glUniform1fvARB_pointer != 0L & this.ARB_shader_objects_glUniform2fvARB_pointer != 0L & this.ARB_shader_objects_glUniform3fvARB_pointer != 0L & this.ARB_shader_objects_glUniform4fvARB_pointer != 0L & this.ARB_shader_objects_glUniform1ivARB_pointer != 0L & this.ARB_shader_objects_glUniform2ivARB_pointer != 0L & this.ARB_shader_objects_glUniform3ivARB_pointer != 0L & this.ARB_shader_objects_glUniform4ivARB_pointer != 0L & this.ARB_shader_objects_glUniformMatrix2fvARB_pointer != 0L & this.ARB_shader_objects_glUniformMatrix3fvARB_pointer != 0L & this.ARB_shader_objects_glUniformMatrix4fvARB_pointer != 0L & this.ARB_shader_objects_glGetObjectParameterfvARB_pointer != 0L & this.ARB_shader_objects_glGetObjectParameterivARB_pointer != 0L & this.ARB_shader_objects_glGetInfoLogARB_pointer != 0L & this.ARB_shader_objects_glGetAttachedObjectsARB_pointer != 0L & this.ARB_shader_objects_glGetUniformLocationARB_pointer != 0L & this.ARB_shader_objects_glGetActiveUniformARB_pointer != 0L & this.ARB_shader_objects_glGetUniformfvARB_pointer != 0L & this.ARB_shader_objects_glGetUniformivARB_pointer != 0L & this.ARB_shader_objects_glGetShaderSourceARB_pointer != 0L;
    }

    private boolean ARB_shader_subroutine_initNativeFunctionAddresses() {
        this.ARB_shader_subroutine_glGetSubroutineUniformLocation_pointer = GLContext.getFunctionAddress("glGetSubroutineUniformLocation");
        boolean bl2 = this.ARB_shader_subroutine_glGetSubroutineUniformLocation_pointer != 0L;
        this.ARB_shader_subroutine_glGetSubroutineIndex_pointer = GLContext.getFunctionAddress("glGetSubroutineIndex");
        this.ARB_shader_subroutine_glGetActiveSubroutineUniformiv_pointer = GLContext.getFunctionAddress("glGetActiveSubroutineUniformiv");
        this.ARB_shader_subroutine_glGetActiveSubroutineUniformName_pointer = GLContext.getFunctionAddress("glGetActiveSubroutineUniformName");
        this.ARB_shader_subroutine_glGetActiveSubroutineName_pointer = GLContext.getFunctionAddress("glGetActiveSubroutineName");
        this.ARB_shader_subroutine_glUniformSubroutinesuiv_pointer = GLContext.getFunctionAddress("glUniformSubroutinesuiv");
        this.ARB_shader_subroutine_glGetUniformSubroutineuiv_pointer = GLContext.getFunctionAddress("glGetUniformSubroutineuiv");
        this.ARB_shader_subroutine_glGetProgramStageiv_pointer = GLContext.getFunctionAddress("glGetProgramStageiv");
        return bl2 & this.ARB_shader_subroutine_glGetSubroutineIndex_pointer != 0L & this.ARB_shader_subroutine_glGetActiveSubroutineUniformiv_pointer != 0L & this.ARB_shader_subroutine_glGetActiveSubroutineUniformName_pointer != 0L & this.ARB_shader_subroutine_glGetActiveSubroutineName_pointer != 0L & this.ARB_shader_subroutine_glUniformSubroutinesuiv_pointer != 0L & this.ARB_shader_subroutine_glGetUniformSubroutineuiv_pointer != 0L & this.ARB_shader_subroutine_glGetProgramStageiv_pointer != 0L;
    }

    private boolean ARB_shading_language_include_initNativeFunctionAddresses() {
        this.ARB_shading_language_include_glNamedStringARB_pointer = GLContext.getFunctionAddress("glNamedStringARB");
        boolean bl2 = this.ARB_shading_language_include_glNamedStringARB_pointer != 0L;
        this.ARB_shading_language_include_glDeleteNamedStringARB_pointer = GLContext.getFunctionAddress("glDeleteNamedStringARB");
        this.ARB_shading_language_include_glCompileShaderIncludeARB_pointer = GLContext.getFunctionAddress("glCompileShaderIncludeARB");
        this.ARB_shading_language_include_glIsNamedStringARB_pointer = GLContext.getFunctionAddress("glIsNamedStringARB");
        this.ARB_shading_language_include_glGetNamedStringARB_pointer = GLContext.getFunctionAddress("glGetNamedStringARB");
        this.ARB_shading_language_include_glGetNamedStringivARB_pointer = GLContext.getFunctionAddress("glGetNamedStringivARB");
        return bl2 & this.ARB_shading_language_include_glDeleteNamedStringARB_pointer != 0L & this.ARB_shading_language_include_glCompileShaderIncludeARB_pointer != 0L & this.ARB_shading_language_include_glIsNamedStringARB_pointer != 0L & this.ARB_shading_language_include_glGetNamedStringARB_pointer != 0L & this.ARB_shading_language_include_glGetNamedStringivARB_pointer != 0L;
    }

    private boolean ARB_sync_initNativeFunctionAddresses() {
        this.ARB_sync_glFenceSync_pointer = GLContext.getFunctionAddress("glFenceSync");
        boolean bl2 = this.ARB_sync_glFenceSync_pointer != 0L;
        this.ARB_sync_glIsSync_pointer = GLContext.getFunctionAddress("glIsSync");
        this.ARB_sync_glDeleteSync_pointer = GLContext.getFunctionAddress("glDeleteSync");
        this.ARB_sync_glClientWaitSync_pointer = GLContext.getFunctionAddress("glClientWaitSync");
        this.ARB_sync_glWaitSync_pointer = GLContext.getFunctionAddress("glWaitSync");
        this.ARB_sync_glGetInteger64v_pointer = GLContext.getFunctionAddress("glGetInteger64v");
        this.ARB_sync_glGetSynciv_pointer = GLContext.getFunctionAddress("glGetSynciv");
        return bl2 & this.ARB_sync_glIsSync_pointer != 0L & this.ARB_sync_glDeleteSync_pointer != 0L & this.ARB_sync_glClientWaitSync_pointer != 0L & this.ARB_sync_glWaitSync_pointer != 0L & this.ARB_sync_glGetInteger64v_pointer != 0L & this.ARB_sync_glGetSynciv_pointer != 0L;
    }

    private boolean ARB_tessellation_shader_initNativeFunctionAddresses() {
        this.ARB_tessellation_shader_glPatchParameteri_pointer = GLContext.getFunctionAddress("glPatchParameteri");
        boolean bl2 = this.ARB_tessellation_shader_glPatchParameteri_pointer != 0L;
        this.ARB_tessellation_shader_glPatchParameterfv_pointer = GLContext.getFunctionAddress("glPatchParameterfv");
        return bl2 & this.ARB_tessellation_shader_glPatchParameterfv_pointer != 0L;
    }

    private boolean ARB_texture_buffer_object_initNativeFunctionAddresses() {
        this.ARB_texture_buffer_object_glTexBufferARB_pointer = GLContext.getFunctionAddress("glTexBufferARB");
        return this.ARB_texture_buffer_object_glTexBufferARB_pointer != 0L;
    }

    private boolean ARB_texture_compression_initNativeFunctionAddresses() {
        this.ARB_texture_compression_glCompressedTexImage1DARB_pointer = GLContext.getFunctionAddress("glCompressedTexImage1DARB");
        boolean bl2 = this.ARB_texture_compression_glCompressedTexImage1DARB_pointer != 0L;
        this.ARB_texture_compression_glCompressedTexImage2DARB_pointer = GLContext.getFunctionAddress("glCompressedTexImage2DARB");
        this.ARB_texture_compression_glCompressedTexImage3DARB_pointer = GLContext.getFunctionAddress("glCompressedTexImage3DARB");
        this.ARB_texture_compression_glCompressedTexSubImage1DARB_pointer = GLContext.getFunctionAddress("glCompressedTexSubImage1DARB");
        this.ARB_texture_compression_glCompressedTexSubImage2DARB_pointer = GLContext.getFunctionAddress("glCompressedTexSubImage2DARB");
        this.ARB_texture_compression_glCompressedTexSubImage3DARB_pointer = GLContext.getFunctionAddress("glCompressedTexSubImage3DARB");
        this.ARB_texture_compression_glGetCompressedTexImageARB_pointer = GLContext.getFunctionAddress("glGetCompressedTexImageARB");
        return bl2 & this.ARB_texture_compression_glCompressedTexImage2DARB_pointer != 0L & this.ARB_texture_compression_glCompressedTexImage3DARB_pointer != 0L & this.ARB_texture_compression_glCompressedTexSubImage1DARB_pointer != 0L & this.ARB_texture_compression_glCompressedTexSubImage2DARB_pointer != 0L & this.ARB_texture_compression_glCompressedTexSubImage3DARB_pointer != 0L & this.ARB_texture_compression_glGetCompressedTexImageARB_pointer != 0L;
    }

    private boolean ARB_texture_multisample_initNativeFunctionAddresses() {
        this.ARB_texture_multisample_glTexImage2DMultisample_pointer = GLContext.getFunctionAddress("glTexImage2DMultisample");
        boolean bl2 = this.ARB_texture_multisample_glTexImage2DMultisample_pointer != 0L;
        this.ARB_texture_multisample_glTexImage3DMultisample_pointer = GLContext.getFunctionAddress("glTexImage3DMultisample");
        this.ARB_texture_multisample_glGetMultisamplefv_pointer = GLContext.getFunctionAddress("glGetMultisamplefv");
        this.ARB_texture_multisample_glSampleMaski_pointer = GLContext.getFunctionAddress("glSampleMaski");
        return bl2 & this.ARB_texture_multisample_glTexImage3DMultisample_pointer != 0L & this.ARB_texture_multisample_glGetMultisamplefv_pointer != 0L & this.ARB_texture_multisample_glSampleMaski_pointer != 0L;
    }

    private boolean ARB_timer_query_initNativeFunctionAddresses() {
        this.ARB_timer_query_glQueryCounter_pointer = GLContext.getFunctionAddress("glQueryCounter");
        boolean bl2 = this.ARB_timer_query_glQueryCounter_pointer != 0L;
        this.ARB_timer_query_glGetQueryObjecti64v_pointer = GLContext.getFunctionAddress("glGetQueryObjecti64v");
        this.ARB_timer_query_glGetQueryObjectui64v_pointer = GLContext.getFunctionAddress("glGetQueryObjectui64v");
        return bl2 & this.ARB_timer_query_glGetQueryObjecti64v_pointer != 0L & this.ARB_timer_query_glGetQueryObjectui64v_pointer != 0L;
    }

    private boolean ARB_transform_feedback2_initNativeFunctionAddresses() {
        this.ARB_transform_feedback2_glBindTransformFeedback_pointer = GLContext.getFunctionAddress("glBindTransformFeedback");
        boolean bl2 = this.ARB_transform_feedback2_glBindTransformFeedback_pointer != 0L;
        this.ARB_transform_feedback2_glDeleteTransformFeedbacks_pointer = GLContext.getFunctionAddress("glDeleteTransformFeedbacks");
        this.ARB_transform_feedback2_glGenTransformFeedbacks_pointer = GLContext.getFunctionAddress("glGenTransformFeedbacks");
        this.ARB_transform_feedback2_glIsTransformFeedback_pointer = GLContext.getFunctionAddress("glIsTransformFeedback");
        this.ARB_transform_feedback2_glPauseTransformFeedback_pointer = GLContext.getFunctionAddress("glPauseTransformFeedback");
        this.ARB_transform_feedback2_glResumeTransformFeedback_pointer = GLContext.getFunctionAddress("glResumeTransformFeedback");
        this.ARB_transform_feedback2_glDrawTransformFeedback_pointer = GLContext.getFunctionAddress("glDrawTransformFeedback");
        return bl2 & this.ARB_transform_feedback2_glDeleteTransformFeedbacks_pointer != 0L & this.ARB_transform_feedback2_glGenTransformFeedbacks_pointer != 0L & this.ARB_transform_feedback2_glIsTransformFeedback_pointer != 0L & this.ARB_transform_feedback2_glPauseTransformFeedback_pointer != 0L & this.ARB_transform_feedback2_glResumeTransformFeedback_pointer != 0L & this.ARB_transform_feedback2_glDrawTransformFeedback_pointer != 0L;
    }

    private boolean ARB_transform_feedback3_initNativeFunctionAddresses() {
        this.ARB_transform_feedback3_glDrawTransformFeedbackStream_pointer = GLContext.getFunctionAddress("glDrawTransformFeedbackStream");
        boolean bl2 = this.ARB_transform_feedback3_glDrawTransformFeedbackStream_pointer != 0L;
        this.ARB_transform_feedback3_glBeginQueryIndexed_pointer = GLContext.getFunctionAddress("glBeginQueryIndexed");
        this.ARB_transform_feedback3_glEndQueryIndexed_pointer = GLContext.getFunctionAddress("glEndQueryIndexed");
        this.ARB_transform_feedback3_glGetQueryIndexediv_pointer = GLContext.getFunctionAddress("glGetQueryIndexediv");
        return bl2 & this.ARB_transform_feedback3_glBeginQueryIndexed_pointer != 0L & this.ARB_transform_feedback3_glEndQueryIndexed_pointer != 0L & this.ARB_transform_feedback3_glGetQueryIndexediv_pointer != 0L;
    }

    private boolean ARB_transpose_matrix_initNativeFunctionAddresses() {
        this.ARB_transpose_matrix_glLoadTransposeMatrixfARB_pointer = GLContext.getFunctionAddress("glLoadTransposeMatrixfARB");
        boolean bl2 = this.ARB_transpose_matrix_glLoadTransposeMatrixfARB_pointer != 0L;
        this.ARB_transpose_matrix_glMultTransposeMatrixfARB_pointer = GLContext.getFunctionAddress("glMultTransposeMatrixfARB");
        return bl2 & this.ARB_transpose_matrix_glMultTransposeMatrixfARB_pointer != 0L;
    }

    private boolean ARB_uniform_buffer_object_initNativeFunctionAddresses() {
        this.ARB_uniform_buffer_object_glGetUniformIndices_pointer = GLContext.getFunctionAddress("glGetUniformIndices");
        boolean bl2 = this.ARB_uniform_buffer_object_glGetUniformIndices_pointer != 0L;
        this.ARB_uniform_buffer_object_glGetActiveUniformsiv_pointer = GLContext.getFunctionAddress("glGetActiveUniformsiv");
        this.ARB_uniform_buffer_object_glGetActiveUniformName_pointer = GLContext.getFunctionAddress("glGetActiveUniformName");
        this.ARB_uniform_buffer_object_glGetUniformBlockIndex_pointer = GLContext.getFunctionAddress("glGetUniformBlockIndex");
        this.ARB_uniform_buffer_object_glGetActiveUniformBlockiv_pointer = GLContext.getFunctionAddress("glGetActiveUniformBlockiv");
        this.ARB_uniform_buffer_object_glGetActiveUniformBlockName_pointer = GLContext.getFunctionAddress("glGetActiveUniformBlockName");
        this.ARB_uniform_buffer_object_glBindBufferRange_pointer = GLContext.getFunctionAddress("glBindBufferRange");
        this.ARB_uniform_buffer_object_glBindBufferBase_pointer = GLContext.getFunctionAddress("glBindBufferBase");
        this.ARB_uniform_buffer_object_glGetIntegeri_v_pointer = GLContext.getFunctionAddress("glGetIntegeri_v");
        this.ARB_uniform_buffer_object_glUniformBlockBinding_pointer = GLContext.getFunctionAddress("glUniformBlockBinding");
        return bl2 & this.ARB_uniform_buffer_object_glGetActiveUniformsiv_pointer != 0L & this.ARB_uniform_buffer_object_glGetActiveUniformName_pointer != 0L & this.ARB_uniform_buffer_object_glGetUniformBlockIndex_pointer != 0L & this.ARB_uniform_buffer_object_glGetActiveUniformBlockiv_pointer != 0L & this.ARB_uniform_buffer_object_glGetActiveUniformBlockName_pointer != 0L & this.ARB_uniform_buffer_object_glBindBufferRange_pointer != 0L & this.ARB_uniform_buffer_object_glBindBufferBase_pointer != 0L & this.ARB_uniform_buffer_object_glGetIntegeri_v_pointer != 0L & this.ARB_uniform_buffer_object_glUniformBlockBinding_pointer != 0L;
    }

    private boolean ARB_vertex_array_object_initNativeFunctionAddresses() {
        this.ARB_vertex_array_object_glBindVertexArray_pointer = GLContext.getFunctionAddress("glBindVertexArray");
        boolean bl2 = this.ARB_vertex_array_object_glBindVertexArray_pointer != 0L;
        this.ARB_vertex_array_object_glDeleteVertexArrays_pointer = GLContext.getFunctionAddress("glDeleteVertexArrays");
        this.ARB_vertex_array_object_glGenVertexArrays_pointer = GLContext.getFunctionAddress("glGenVertexArrays");
        this.ARB_vertex_array_object_glIsVertexArray_pointer = GLContext.getFunctionAddress("glIsVertexArray");
        return bl2 & this.ARB_vertex_array_object_glDeleteVertexArrays_pointer != 0L & this.ARB_vertex_array_object_glGenVertexArrays_pointer != 0L & this.ARB_vertex_array_object_glIsVertexArray_pointer != 0L;
    }

    private boolean ARB_vertex_blend_initNativeFunctionAddresses() {
        this.ARB_vertex_blend_glWeightbvARB_pointer = GLContext.getFunctionAddress("glWeightbvARB");
        boolean bl2 = this.ARB_vertex_blend_glWeightbvARB_pointer != 0L;
        this.ARB_vertex_blend_glWeightsvARB_pointer = GLContext.getFunctionAddress("glWeightsvARB");
        this.ARB_vertex_blend_glWeightivARB_pointer = GLContext.getFunctionAddress("glWeightivARB");
        this.ARB_vertex_blend_glWeightfvARB_pointer = GLContext.getFunctionAddress("glWeightfvARB");
        this.ARB_vertex_blend_glWeightdvARB_pointer = GLContext.getFunctionAddress("glWeightdvARB");
        this.ARB_vertex_blend_glWeightubvARB_pointer = GLContext.getFunctionAddress("glWeightubvARB");
        this.ARB_vertex_blend_glWeightusvARB_pointer = GLContext.getFunctionAddress("glWeightusvARB");
        this.ARB_vertex_blend_glWeightuivARB_pointer = GLContext.getFunctionAddress("glWeightuivARB");
        this.ARB_vertex_blend_glWeightPointerARB_pointer = GLContext.getFunctionAddress("glWeightPointerARB");
        this.ARB_vertex_blend_glVertexBlendARB_pointer = GLContext.getFunctionAddress("glVertexBlendARB");
        return bl2 & this.ARB_vertex_blend_glWeightsvARB_pointer != 0L & this.ARB_vertex_blend_glWeightivARB_pointer != 0L & this.ARB_vertex_blend_glWeightfvARB_pointer != 0L & this.ARB_vertex_blend_glWeightdvARB_pointer != 0L & this.ARB_vertex_blend_glWeightubvARB_pointer != 0L & this.ARB_vertex_blend_glWeightusvARB_pointer != 0L & this.ARB_vertex_blend_glWeightuivARB_pointer != 0L & this.ARB_vertex_blend_glWeightPointerARB_pointer != 0L & this.ARB_vertex_blend_glVertexBlendARB_pointer != 0L;
    }

    private boolean ARB_vertex_program_initNativeFunctionAddresses() {
        this.ARB_vertex_program_glVertexAttrib1sARB_pointer = GLContext.getFunctionAddress("glVertexAttrib1sARB");
        boolean bl2 = this.ARB_vertex_program_glVertexAttrib1sARB_pointer != 0L;
        this.ARB_vertex_program_glVertexAttrib1fARB_pointer = GLContext.getFunctionAddress("glVertexAttrib1fARB");
        this.ARB_vertex_program_glVertexAttrib1dARB_pointer = GLContext.getFunctionAddress("glVertexAttrib1dARB");
        this.ARB_vertex_program_glVertexAttrib2sARB_pointer = GLContext.getFunctionAddress("glVertexAttrib2sARB");
        this.ARB_vertex_program_glVertexAttrib2fARB_pointer = GLContext.getFunctionAddress("glVertexAttrib2fARB");
        this.ARB_vertex_program_glVertexAttrib2dARB_pointer = GLContext.getFunctionAddress("glVertexAttrib2dARB");
        this.ARB_vertex_program_glVertexAttrib3sARB_pointer = GLContext.getFunctionAddress("glVertexAttrib3sARB");
        this.ARB_vertex_program_glVertexAttrib3fARB_pointer = GLContext.getFunctionAddress("glVertexAttrib3fARB");
        this.ARB_vertex_program_glVertexAttrib3dARB_pointer = GLContext.getFunctionAddress("glVertexAttrib3dARB");
        this.ARB_vertex_program_glVertexAttrib4sARB_pointer = GLContext.getFunctionAddress("glVertexAttrib4sARB");
        this.ARB_vertex_program_glVertexAttrib4fARB_pointer = GLContext.getFunctionAddress("glVertexAttrib4fARB");
        this.ARB_vertex_program_glVertexAttrib4dARB_pointer = GLContext.getFunctionAddress("glVertexAttrib4dARB");
        this.ARB_vertex_program_glVertexAttrib4NubARB_pointer = GLContext.getFunctionAddress("glVertexAttrib4NubARB");
        this.ARB_vertex_program_glVertexAttribPointerARB_pointer = GLContext.getFunctionAddress("glVertexAttribPointerARB");
        this.ARB_vertex_program_glEnableVertexAttribArrayARB_pointer = GLContext.getFunctionAddress("glEnableVertexAttribArrayARB");
        this.ARB_vertex_program_glDisableVertexAttribArrayARB_pointer = GLContext.getFunctionAddress("glDisableVertexAttribArrayARB");
        this.ARB_vertex_program_glGetVertexAttribfvARB_pointer = GLContext.getFunctionAddress("glGetVertexAttribfvARB");
        this.ARB_vertex_program_glGetVertexAttribdvARB_pointer = GLContext.getFunctionAddress("glGetVertexAttribdvARB");
        this.ARB_vertex_program_glGetVertexAttribivARB_pointer = GLContext.getFunctionAddress("glGetVertexAttribivARB");
        this.ARB_vertex_program_glGetVertexAttribPointervARB_pointer = GLContext.getFunctionAddress("glGetVertexAttribPointervARB");
        return bl2 & this.ARB_vertex_program_glVertexAttrib1fARB_pointer != 0L & this.ARB_vertex_program_glVertexAttrib1dARB_pointer != 0L & this.ARB_vertex_program_glVertexAttrib2sARB_pointer != 0L & this.ARB_vertex_program_glVertexAttrib2fARB_pointer != 0L & this.ARB_vertex_program_glVertexAttrib2dARB_pointer != 0L & this.ARB_vertex_program_glVertexAttrib3sARB_pointer != 0L & this.ARB_vertex_program_glVertexAttrib3fARB_pointer != 0L & this.ARB_vertex_program_glVertexAttrib3dARB_pointer != 0L & this.ARB_vertex_program_glVertexAttrib4sARB_pointer != 0L & this.ARB_vertex_program_glVertexAttrib4fARB_pointer != 0L & this.ARB_vertex_program_glVertexAttrib4dARB_pointer != 0L & this.ARB_vertex_program_glVertexAttrib4NubARB_pointer != 0L & this.ARB_vertex_program_glVertexAttribPointerARB_pointer != 0L & this.ARB_vertex_program_glEnableVertexAttribArrayARB_pointer != 0L & this.ARB_vertex_program_glDisableVertexAttribArrayARB_pointer != 0L & this.ARB_vertex_program_glGetVertexAttribfvARB_pointer != 0L & this.ARB_vertex_program_glGetVertexAttribdvARB_pointer != 0L & this.ARB_vertex_program_glGetVertexAttribivARB_pointer != 0L & this.ARB_vertex_program_glGetVertexAttribPointervARB_pointer != 0L;
    }

    private boolean ARB_vertex_shader_initNativeFunctionAddresses() {
        this.ARB_vertex_shader_glVertexAttrib1sARB_pointer = GLContext.getFunctionAddress("glVertexAttrib1sARB");
        boolean bl2 = this.ARB_vertex_shader_glVertexAttrib1sARB_pointer != 0L;
        this.ARB_vertex_shader_glVertexAttrib1fARB_pointer = GLContext.getFunctionAddress("glVertexAttrib1fARB");
        this.ARB_vertex_shader_glVertexAttrib1dARB_pointer = GLContext.getFunctionAddress("glVertexAttrib1dARB");
        this.ARB_vertex_shader_glVertexAttrib2sARB_pointer = GLContext.getFunctionAddress("glVertexAttrib2sARB");
        this.ARB_vertex_shader_glVertexAttrib2fARB_pointer = GLContext.getFunctionAddress("glVertexAttrib2fARB");
        this.ARB_vertex_shader_glVertexAttrib2dARB_pointer = GLContext.getFunctionAddress("glVertexAttrib2dARB");
        this.ARB_vertex_shader_glVertexAttrib3sARB_pointer = GLContext.getFunctionAddress("glVertexAttrib3sARB");
        this.ARB_vertex_shader_glVertexAttrib3fARB_pointer = GLContext.getFunctionAddress("glVertexAttrib3fARB");
        this.ARB_vertex_shader_glVertexAttrib3dARB_pointer = GLContext.getFunctionAddress("glVertexAttrib3dARB");
        this.ARB_vertex_shader_glVertexAttrib4sARB_pointer = GLContext.getFunctionAddress("glVertexAttrib4sARB");
        this.ARB_vertex_shader_glVertexAttrib4fARB_pointer = GLContext.getFunctionAddress("glVertexAttrib4fARB");
        this.ARB_vertex_shader_glVertexAttrib4dARB_pointer = GLContext.getFunctionAddress("glVertexAttrib4dARB");
        this.ARB_vertex_shader_glVertexAttrib4NubARB_pointer = GLContext.getFunctionAddress("glVertexAttrib4NubARB");
        this.ARB_vertex_shader_glVertexAttribPointerARB_pointer = GLContext.getFunctionAddress("glVertexAttribPointerARB");
        this.ARB_vertex_shader_glEnableVertexAttribArrayARB_pointer = GLContext.getFunctionAddress("glEnableVertexAttribArrayARB");
        this.ARB_vertex_shader_glDisableVertexAttribArrayARB_pointer = GLContext.getFunctionAddress("glDisableVertexAttribArrayARB");
        this.ARB_vertex_shader_glBindAttribLocationARB_pointer = GLContext.getFunctionAddress("glBindAttribLocationARB");
        this.ARB_vertex_shader_glGetActiveAttribARB_pointer = GLContext.getFunctionAddress("glGetActiveAttribARB");
        this.ARB_vertex_shader_glGetAttribLocationARB_pointer = GLContext.getFunctionAddress("glGetAttribLocationARB");
        this.ARB_vertex_shader_glGetVertexAttribfvARB_pointer = GLContext.getFunctionAddress("glGetVertexAttribfvARB");
        this.ARB_vertex_shader_glGetVertexAttribdvARB_pointer = GLContext.getFunctionAddress("glGetVertexAttribdvARB");
        this.ARB_vertex_shader_glGetVertexAttribivARB_pointer = GLContext.getFunctionAddress("glGetVertexAttribivARB");
        this.ARB_vertex_shader_glGetVertexAttribPointervARB_pointer = GLContext.getFunctionAddress("glGetVertexAttribPointervARB");
        return bl2 & this.ARB_vertex_shader_glVertexAttrib1fARB_pointer != 0L & this.ARB_vertex_shader_glVertexAttrib1dARB_pointer != 0L & this.ARB_vertex_shader_glVertexAttrib2sARB_pointer != 0L & this.ARB_vertex_shader_glVertexAttrib2fARB_pointer != 0L & this.ARB_vertex_shader_glVertexAttrib2dARB_pointer != 0L & this.ARB_vertex_shader_glVertexAttrib3sARB_pointer != 0L & this.ARB_vertex_shader_glVertexAttrib3fARB_pointer != 0L & this.ARB_vertex_shader_glVertexAttrib3dARB_pointer != 0L & this.ARB_vertex_shader_glVertexAttrib4sARB_pointer != 0L & this.ARB_vertex_shader_glVertexAttrib4fARB_pointer != 0L & this.ARB_vertex_shader_glVertexAttrib4dARB_pointer != 0L & this.ARB_vertex_shader_glVertexAttrib4NubARB_pointer != 0L & this.ARB_vertex_shader_glVertexAttribPointerARB_pointer != 0L & this.ARB_vertex_shader_glEnableVertexAttribArrayARB_pointer != 0L & this.ARB_vertex_shader_glDisableVertexAttribArrayARB_pointer != 0L & this.ARB_vertex_shader_glBindAttribLocationARB_pointer != 0L & this.ARB_vertex_shader_glGetActiveAttribARB_pointer != 0L & this.ARB_vertex_shader_glGetAttribLocationARB_pointer != 0L & this.ARB_vertex_shader_glGetVertexAttribfvARB_pointer != 0L & this.ARB_vertex_shader_glGetVertexAttribdvARB_pointer != 0L & this.ARB_vertex_shader_glGetVertexAttribivARB_pointer != 0L & this.ARB_vertex_shader_glGetVertexAttribPointervARB_pointer != 0L;
    }

    private boolean ARB_vertex_type_2_10_10_10_rev_initNativeFunctionAddresses() {
        this.ARB_vertex_type_2_10_10_10_rev_glVertexP2ui_pointer = GLContext.getFunctionAddress("glVertexP2ui");
        boolean bl2 = this.ARB_vertex_type_2_10_10_10_rev_glVertexP2ui_pointer != 0L;
        this.ARB_vertex_type_2_10_10_10_rev_glVertexP3ui_pointer = GLContext.getFunctionAddress("glVertexP3ui");
        this.ARB_vertex_type_2_10_10_10_rev_glVertexP4ui_pointer = GLContext.getFunctionAddress("glVertexP4ui");
        this.ARB_vertex_type_2_10_10_10_rev_glVertexP2uiv_pointer = GLContext.getFunctionAddress("glVertexP2uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glVertexP3uiv_pointer = GLContext.getFunctionAddress("glVertexP3uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glVertexP4uiv_pointer = GLContext.getFunctionAddress("glVertexP4uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP1ui_pointer = GLContext.getFunctionAddress("glTexCoordP1ui");
        this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP2ui_pointer = GLContext.getFunctionAddress("glTexCoordP2ui");
        this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP3ui_pointer = GLContext.getFunctionAddress("glTexCoordP3ui");
        this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP4ui_pointer = GLContext.getFunctionAddress("glTexCoordP4ui");
        this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP1uiv_pointer = GLContext.getFunctionAddress("glTexCoordP1uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP2uiv_pointer = GLContext.getFunctionAddress("glTexCoordP2uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP3uiv_pointer = GLContext.getFunctionAddress("glTexCoordP3uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP4uiv_pointer = GLContext.getFunctionAddress("glTexCoordP4uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP1ui_pointer = GLContext.getFunctionAddress("glMultiTexCoordP1ui");
        this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP2ui_pointer = GLContext.getFunctionAddress("glMultiTexCoordP2ui");
        this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP3ui_pointer = GLContext.getFunctionAddress("glMultiTexCoordP3ui");
        this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP4ui_pointer = GLContext.getFunctionAddress("glMultiTexCoordP4ui");
        this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP1uiv_pointer = GLContext.getFunctionAddress("glMultiTexCoordP1uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP2uiv_pointer = GLContext.getFunctionAddress("glMultiTexCoordP2uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP3uiv_pointer = GLContext.getFunctionAddress("glMultiTexCoordP3uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP4uiv_pointer = GLContext.getFunctionAddress("glMultiTexCoordP4uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glNormalP3ui_pointer = GLContext.getFunctionAddress("glNormalP3ui");
        this.ARB_vertex_type_2_10_10_10_rev_glNormalP3uiv_pointer = GLContext.getFunctionAddress("glNormalP3uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glColorP3ui_pointer = GLContext.getFunctionAddress("glColorP3ui");
        this.ARB_vertex_type_2_10_10_10_rev_glColorP4ui_pointer = GLContext.getFunctionAddress("glColorP4ui");
        this.ARB_vertex_type_2_10_10_10_rev_glColorP3uiv_pointer = GLContext.getFunctionAddress("glColorP3uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glColorP4uiv_pointer = GLContext.getFunctionAddress("glColorP4uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glSecondaryColorP3ui_pointer = GLContext.getFunctionAddress("glSecondaryColorP3ui");
        this.ARB_vertex_type_2_10_10_10_rev_glSecondaryColorP3uiv_pointer = GLContext.getFunctionAddress("glSecondaryColorP3uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP1ui_pointer = GLContext.getFunctionAddress("glVertexAttribP1ui");
        this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP2ui_pointer = GLContext.getFunctionAddress("glVertexAttribP2ui");
        this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP3ui_pointer = GLContext.getFunctionAddress("glVertexAttribP3ui");
        this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP4ui_pointer = GLContext.getFunctionAddress("glVertexAttribP4ui");
        this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP1uiv_pointer = GLContext.getFunctionAddress("glVertexAttribP1uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP2uiv_pointer = GLContext.getFunctionAddress("glVertexAttribP2uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP3uiv_pointer = GLContext.getFunctionAddress("glVertexAttribP3uiv");
        this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP4uiv_pointer = GLContext.getFunctionAddress("glVertexAttribP4uiv");
        return bl2 & this.ARB_vertex_type_2_10_10_10_rev_glVertexP3ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glVertexP4ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glVertexP2uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glVertexP3uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glVertexP4uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP1ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP2ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP3ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP4ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP1uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP2uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP3uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glTexCoordP4uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP1ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP2ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP3ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP4ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP1uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP2uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP3uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP4uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glNormalP3ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glNormalP3uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glColorP3ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glColorP4ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glColorP3uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glColorP4uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glSecondaryColorP3ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glSecondaryColorP3uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP1ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP2ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP3ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP4ui_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP1uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP2uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP3uiv_pointer != 0L & this.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP4uiv_pointer != 0L;
    }

    private boolean ARB_window_pos_initNativeFunctionAddresses(boolean forwardCompatible) {
        return (forwardCompatible || (this.ARB_window_pos_glWindowPos2fARB_pointer = GLContext.getFunctionAddress("glWindowPos2fARB")) != 0L) & (forwardCompatible || (this.ARB_window_pos_glWindowPos2dARB_pointer = GLContext.getFunctionAddress("glWindowPos2dARB")) != 0L) & (forwardCompatible || (this.ARB_window_pos_glWindowPos2iARB_pointer = GLContext.getFunctionAddress("glWindowPos2iARB")) != 0L) & (forwardCompatible || (this.ARB_window_pos_glWindowPos2sARB_pointer = GLContext.getFunctionAddress("glWindowPos2sARB")) != 0L) & (forwardCompatible || (this.ARB_window_pos_glWindowPos3fARB_pointer = GLContext.getFunctionAddress("glWindowPos3fARB")) != 0L) & (forwardCompatible || (this.ARB_window_pos_glWindowPos3dARB_pointer = GLContext.getFunctionAddress("glWindowPos3dARB")) != 0L) & (forwardCompatible || (this.ARB_window_pos_glWindowPos3iARB_pointer = GLContext.getFunctionAddress("glWindowPos3iARB")) != 0L) & (forwardCompatible || (this.ARB_window_pos_glWindowPos3sARB_pointer = GLContext.getFunctionAddress("glWindowPos3sARB")) != 0L);
    }

    private boolean ATI_draw_buffers_initNativeFunctionAddresses() {
        this.ATI_draw_buffers_glDrawBuffersATI_pointer = GLContext.getFunctionAddress("glDrawBuffersATI");
        return this.ATI_draw_buffers_glDrawBuffersATI_pointer != 0L;
    }

    private boolean ATI_element_array_initNativeFunctionAddresses() {
        this.ATI_element_array_glElementPointerATI_pointer = GLContext.getFunctionAddress("glElementPointerATI");
        boolean bl2 = this.ATI_element_array_glElementPointerATI_pointer != 0L;
        this.ATI_element_array_glDrawElementArrayATI_pointer = GLContext.getFunctionAddress("glDrawElementArrayATI");
        this.ATI_element_array_glDrawRangeElementArrayATI_pointer = GLContext.getFunctionAddress("glDrawRangeElementArrayATI");
        return bl2 & this.ATI_element_array_glDrawElementArrayATI_pointer != 0L & this.ATI_element_array_glDrawRangeElementArrayATI_pointer != 0L;
    }

    private boolean ATI_envmap_bumpmap_initNativeFunctionAddresses() {
        this.ATI_envmap_bumpmap_glTexBumpParameterfvATI_pointer = GLContext.getFunctionAddress("glTexBumpParameterfvATI");
        boolean bl2 = this.ATI_envmap_bumpmap_glTexBumpParameterfvATI_pointer != 0L;
        this.ATI_envmap_bumpmap_glTexBumpParameterivATI_pointer = GLContext.getFunctionAddress("glTexBumpParameterivATI");
        this.ATI_envmap_bumpmap_glGetTexBumpParameterfvATI_pointer = GLContext.getFunctionAddress("glGetTexBumpParameterfvATI");
        this.ATI_envmap_bumpmap_glGetTexBumpParameterivATI_pointer = GLContext.getFunctionAddress("glGetTexBumpParameterivATI");
        return bl2 & this.ATI_envmap_bumpmap_glTexBumpParameterivATI_pointer != 0L & this.ATI_envmap_bumpmap_glGetTexBumpParameterfvATI_pointer != 0L & this.ATI_envmap_bumpmap_glGetTexBumpParameterivATI_pointer != 0L;
    }

    private boolean ATI_fragment_shader_initNativeFunctionAddresses() {
        this.ATI_fragment_shader_glGenFragmentShadersATI_pointer = GLContext.getFunctionAddress("glGenFragmentShadersATI");
        boolean bl2 = this.ATI_fragment_shader_glGenFragmentShadersATI_pointer != 0L;
        this.ATI_fragment_shader_glBindFragmentShaderATI_pointer = GLContext.getFunctionAddress("glBindFragmentShaderATI");
        this.ATI_fragment_shader_glDeleteFragmentShaderATI_pointer = GLContext.getFunctionAddress("glDeleteFragmentShaderATI");
        this.ATI_fragment_shader_glBeginFragmentShaderATI_pointer = GLContext.getFunctionAddress("glBeginFragmentShaderATI");
        this.ATI_fragment_shader_glEndFragmentShaderATI_pointer = GLContext.getFunctionAddress("glEndFragmentShaderATI");
        this.ATI_fragment_shader_glPassTexCoordATI_pointer = GLContext.getFunctionAddress("glPassTexCoordATI");
        this.ATI_fragment_shader_glSampleMapATI_pointer = GLContext.getFunctionAddress("glSampleMapATI");
        this.ATI_fragment_shader_glColorFragmentOp1ATI_pointer = GLContext.getFunctionAddress("glColorFragmentOp1ATI");
        this.ATI_fragment_shader_glColorFragmentOp2ATI_pointer = GLContext.getFunctionAddress("glColorFragmentOp2ATI");
        this.ATI_fragment_shader_glColorFragmentOp3ATI_pointer = GLContext.getFunctionAddress("glColorFragmentOp3ATI");
        this.ATI_fragment_shader_glAlphaFragmentOp1ATI_pointer = GLContext.getFunctionAddress("glAlphaFragmentOp1ATI");
        this.ATI_fragment_shader_glAlphaFragmentOp2ATI_pointer = GLContext.getFunctionAddress("glAlphaFragmentOp2ATI");
        this.ATI_fragment_shader_glAlphaFragmentOp3ATI_pointer = GLContext.getFunctionAddress("glAlphaFragmentOp3ATI");
        this.ATI_fragment_shader_glSetFragmentShaderConstantATI_pointer = GLContext.getFunctionAddress("glSetFragmentShaderConstantATI");
        return bl2 & this.ATI_fragment_shader_glBindFragmentShaderATI_pointer != 0L & this.ATI_fragment_shader_glDeleteFragmentShaderATI_pointer != 0L & this.ATI_fragment_shader_glBeginFragmentShaderATI_pointer != 0L & this.ATI_fragment_shader_glEndFragmentShaderATI_pointer != 0L & this.ATI_fragment_shader_glPassTexCoordATI_pointer != 0L & this.ATI_fragment_shader_glSampleMapATI_pointer != 0L & this.ATI_fragment_shader_glColorFragmentOp1ATI_pointer != 0L & this.ATI_fragment_shader_glColorFragmentOp2ATI_pointer != 0L & this.ATI_fragment_shader_glColorFragmentOp3ATI_pointer != 0L & this.ATI_fragment_shader_glAlphaFragmentOp1ATI_pointer != 0L & this.ATI_fragment_shader_glAlphaFragmentOp2ATI_pointer != 0L & this.ATI_fragment_shader_glAlphaFragmentOp3ATI_pointer != 0L & this.ATI_fragment_shader_glSetFragmentShaderConstantATI_pointer != 0L;
    }

    private boolean ATI_map_object_buffer_initNativeFunctionAddresses() {
        this.ATI_map_object_buffer_glMapObjectBufferATI_pointer = GLContext.getFunctionAddress("glMapObjectBufferATI");
        boolean bl2 = this.ATI_map_object_buffer_glMapObjectBufferATI_pointer != 0L;
        this.ATI_map_object_buffer_glUnmapObjectBufferATI_pointer = GLContext.getFunctionAddress("glUnmapObjectBufferATI");
        return bl2 & this.ATI_map_object_buffer_glUnmapObjectBufferATI_pointer != 0L;
    }

    private boolean ATI_pn_triangles_initNativeFunctionAddresses() {
        this.ATI_pn_triangles_glPNTrianglesfATI_pointer = GLContext.getFunctionAddress("glPNTrianglesfATI");
        boolean bl2 = this.ATI_pn_triangles_glPNTrianglesfATI_pointer != 0L;
        this.ATI_pn_triangles_glPNTrianglesiATI_pointer = GLContext.getFunctionAddress("glPNTrianglesiATI");
        return bl2 & this.ATI_pn_triangles_glPNTrianglesiATI_pointer != 0L;
    }

    private boolean ATI_separate_stencil_initNativeFunctionAddresses() {
        this.ATI_separate_stencil_glStencilOpSeparateATI_pointer = GLContext.getFunctionAddress("glStencilOpSeparateATI");
        boolean bl2 = this.ATI_separate_stencil_glStencilOpSeparateATI_pointer != 0L;
        this.ATI_separate_stencil_glStencilFuncSeparateATI_pointer = GLContext.getFunctionAddress("glStencilFuncSeparateATI");
        return bl2 & this.ATI_separate_stencil_glStencilFuncSeparateATI_pointer != 0L;
    }

    private boolean ATI_vertex_array_object_initNativeFunctionAddresses() {
        this.ATI_vertex_array_object_glNewObjectBufferATI_pointer = GLContext.getFunctionAddress("glNewObjectBufferATI");
        boolean bl2 = this.ATI_vertex_array_object_glNewObjectBufferATI_pointer != 0L;
        this.ATI_vertex_array_object_glIsObjectBufferATI_pointer = GLContext.getFunctionAddress("glIsObjectBufferATI");
        this.ATI_vertex_array_object_glUpdateObjectBufferATI_pointer = GLContext.getFunctionAddress("glUpdateObjectBufferATI");
        this.ATI_vertex_array_object_glGetObjectBufferfvATI_pointer = GLContext.getFunctionAddress("glGetObjectBufferfvATI");
        this.ATI_vertex_array_object_glGetObjectBufferivATI_pointer = GLContext.getFunctionAddress("glGetObjectBufferivATI");
        this.ATI_vertex_array_object_glFreeObjectBufferATI_pointer = GLContext.getFunctionAddress("glFreeObjectBufferATI");
        this.ATI_vertex_array_object_glArrayObjectATI_pointer = GLContext.getFunctionAddress("glArrayObjectATI");
        this.ATI_vertex_array_object_glGetArrayObjectfvATI_pointer = GLContext.getFunctionAddress("glGetArrayObjectfvATI");
        this.ATI_vertex_array_object_glGetArrayObjectivATI_pointer = GLContext.getFunctionAddress("glGetArrayObjectivATI");
        this.ATI_vertex_array_object_glVariantArrayObjectATI_pointer = GLContext.getFunctionAddress("glVariantArrayObjectATI");
        this.ATI_vertex_array_object_glGetVariantArrayObjectfvATI_pointer = GLContext.getFunctionAddress("glGetVariantArrayObjectfvATI");
        this.ATI_vertex_array_object_glGetVariantArrayObjectivATI_pointer = GLContext.getFunctionAddress("glGetVariantArrayObjectivATI");
        return bl2 & this.ATI_vertex_array_object_glIsObjectBufferATI_pointer != 0L & this.ATI_vertex_array_object_glUpdateObjectBufferATI_pointer != 0L & this.ATI_vertex_array_object_glGetObjectBufferfvATI_pointer != 0L & this.ATI_vertex_array_object_glGetObjectBufferivATI_pointer != 0L & this.ATI_vertex_array_object_glFreeObjectBufferATI_pointer != 0L & this.ATI_vertex_array_object_glArrayObjectATI_pointer != 0L & this.ATI_vertex_array_object_glGetArrayObjectfvATI_pointer != 0L & this.ATI_vertex_array_object_glGetArrayObjectivATI_pointer != 0L & this.ATI_vertex_array_object_glVariantArrayObjectATI_pointer != 0L & this.ATI_vertex_array_object_glGetVariantArrayObjectfvATI_pointer != 0L & this.ATI_vertex_array_object_glGetVariantArrayObjectivATI_pointer != 0L;
    }

    private boolean ATI_vertex_attrib_array_object_initNativeFunctionAddresses() {
        this.ATI_vertex_attrib_array_object_glVertexAttribArrayObjectATI_pointer = GLContext.getFunctionAddress("glVertexAttribArrayObjectATI");
        boolean bl2 = this.ATI_vertex_attrib_array_object_glVertexAttribArrayObjectATI_pointer != 0L;
        this.ATI_vertex_attrib_array_object_glGetVertexAttribArrayObjectfvATI_pointer = GLContext.getFunctionAddress("glGetVertexAttribArrayObjectfvATI");
        this.ATI_vertex_attrib_array_object_glGetVertexAttribArrayObjectivATI_pointer = GLContext.getFunctionAddress("glGetVertexAttribArrayObjectivATI");
        return bl2 & this.ATI_vertex_attrib_array_object_glGetVertexAttribArrayObjectfvATI_pointer != 0L & this.ATI_vertex_attrib_array_object_glGetVertexAttribArrayObjectivATI_pointer != 0L;
    }

    private boolean ATI_vertex_streams_initNativeFunctionAddresses() {
        this.ATI_vertex_streams_glVertexStream2fATI_pointer = GLContext.getFunctionAddress("glVertexStream2fATI");
        boolean bl2 = this.ATI_vertex_streams_glVertexStream2fATI_pointer != 0L;
        this.ATI_vertex_streams_glVertexStream2dATI_pointer = GLContext.getFunctionAddress("glVertexStream2dATI");
        this.ATI_vertex_streams_glVertexStream2iATI_pointer = GLContext.getFunctionAddress("glVertexStream2iATI");
        this.ATI_vertex_streams_glVertexStream2sATI_pointer = GLContext.getFunctionAddress("glVertexStream2sATI");
        this.ATI_vertex_streams_glVertexStream3fATI_pointer = GLContext.getFunctionAddress("glVertexStream3fATI");
        this.ATI_vertex_streams_glVertexStream3dATI_pointer = GLContext.getFunctionAddress("glVertexStream3dATI");
        this.ATI_vertex_streams_glVertexStream3iATI_pointer = GLContext.getFunctionAddress("glVertexStream3iATI");
        this.ATI_vertex_streams_glVertexStream3sATI_pointer = GLContext.getFunctionAddress("glVertexStream3sATI");
        this.ATI_vertex_streams_glVertexStream4fATI_pointer = GLContext.getFunctionAddress("glVertexStream4fATI");
        this.ATI_vertex_streams_glVertexStream4dATI_pointer = GLContext.getFunctionAddress("glVertexStream4dATI");
        this.ATI_vertex_streams_glVertexStream4iATI_pointer = GLContext.getFunctionAddress("glVertexStream4iATI");
        this.ATI_vertex_streams_glVertexStream4sATI_pointer = GLContext.getFunctionAddress("glVertexStream4sATI");
        this.ATI_vertex_streams_glNormalStream3bATI_pointer = GLContext.getFunctionAddress("glNormalStream3bATI");
        this.ATI_vertex_streams_glNormalStream3fATI_pointer = GLContext.getFunctionAddress("glNormalStream3fATI");
        this.ATI_vertex_streams_glNormalStream3dATI_pointer = GLContext.getFunctionAddress("glNormalStream3dATI");
        this.ATI_vertex_streams_glNormalStream3iATI_pointer = GLContext.getFunctionAddress("glNormalStream3iATI");
        this.ATI_vertex_streams_glNormalStream3sATI_pointer = GLContext.getFunctionAddress("glNormalStream3sATI");
        this.ATI_vertex_streams_glClientActiveVertexStreamATI_pointer = GLContext.getFunctionAddress("glClientActiveVertexStreamATI");
        this.ATI_vertex_streams_glVertexBlendEnvfATI_pointer = GLContext.getFunctionAddress("glVertexBlendEnvfATI");
        this.ATI_vertex_streams_glVertexBlendEnviATI_pointer = GLContext.getFunctionAddress("glVertexBlendEnviATI");
        return bl2 & this.ATI_vertex_streams_glVertexStream2dATI_pointer != 0L & this.ATI_vertex_streams_glVertexStream2iATI_pointer != 0L & this.ATI_vertex_streams_glVertexStream2sATI_pointer != 0L & this.ATI_vertex_streams_glVertexStream3fATI_pointer != 0L & this.ATI_vertex_streams_glVertexStream3dATI_pointer != 0L & this.ATI_vertex_streams_glVertexStream3iATI_pointer != 0L & this.ATI_vertex_streams_glVertexStream3sATI_pointer != 0L & this.ATI_vertex_streams_glVertexStream4fATI_pointer != 0L & this.ATI_vertex_streams_glVertexStream4dATI_pointer != 0L & this.ATI_vertex_streams_glVertexStream4iATI_pointer != 0L & this.ATI_vertex_streams_glVertexStream4sATI_pointer != 0L & this.ATI_vertex_streams_glNormalStream3bATI_pointer != 0L & this.ATI_vertex_streams_glNormalStream3fATI_pointer != 0L & this.ATI_vertex_streams_glNormalStream3dATI_pointer != 0L & this.ATI_vertex_streams_glNormalStream3iATI_pointer != 0L & this.ATI_vertex_streams_glNormalStream3sATI_pointer != 0L & this.ATI_vertex_streams_glClientActiveVertexStreamATI_pointer != 0L & this.ATI_vertex_streams_glVertexBlendEnvfATI_pointer != 0L & this.ATI_vertex_streams_glVertexBlendEnviATI_pointer != 0L;
    }

    private boolean EXT_bindable_uniform_initNativeFunctionAddresses() {
        this.EXT_bindable_uniform_glUniformBufferEXT_pointer = GLContext.getFunctionAddress("glUniformBufferEXT");
        boolean bl2 = this.EXT_bindable_uniform_glUniformBufferEXT_pointer != 0L;
        this.EXT_bindable_uniform_glGetUniformBufferSizeEXT_pointer = GLContext.getFunctionAddress("glGetUniformBufferSizeEXT");
        this.EXT_bindable_uniform_glGetUniformOffsetEXT_pointer = GLContext.getFunctionAddress("glGetUniformOffsetEXT");
        return bl2 & this.EXT_bindable_uniform_glGetUniformBufferSizeEXT_pointer != 0L & this.EXT_bindable_uniform_glGetUniformOffsetEXT_pointer != 0L;
    }

    private boolean EXT_blend_color_initNativeFunctionAddresses() {
        this.EXT_blend_color_glBlendColorEXT_pointer = GLContext.getFunctionAddress("glBlendColorEXT");
        return this.EXT_blend_color_glBlendColorEXT_pointer != 0L;
    }

    private boolean EXT_blend_equation_separate_initNativeFunctionAddresses() {
        this.EXT_blend_equation_separate_glBlendEquationSeparateEXT_pointer = GLContext.getFunctionAddress("glBlendEquationSeparateEXT");
        return this.EXT_blend_equation_separate_glBlendEquationSeparateEXT_pointer != 0L;
    }

    private boolean EXT_blend_func_separate_initNativeFunctionAddresses() {
        this.EXT_blend_func_separate_glBlendFuncSeparateEXT_pointer = GLContext.getFunctionAddress("glBlendFuncSeparateEXT");
        return this.EXT_blend_func_separate_glBlendFuncSeparateEXT_pointer != 0L;
    }

    private boolean EXT_blend_minmax_initNativeFunctionAddresses() {
        this.EXT_blend_minmax_glBlendEquationEXT_pointer = GLContext.getFunctionAddress("glBlendEquationEXT");
        return this.EXT_blend_minmax_glBlendEquationEXT_pointer != 0L;
    }

    private boolean EXT_compiled_vertex_array_initNativeFunctionAddresses() {
        this.EXT_compiled_vertex_array_glLockArraysEXT_pointer = GLContext.getFunctionAddress("glLockArraysEXT");
        boolean bl2 = this.EXT_compiled_vertex_array_glLockArraysEXT_pointer != 0L;
        this.EXT_compiled_vertex_array_glUnlockArraysEXT_pointer = GLContext.getFunctionAddress("glUnlockArraysEXT");
        return bl2 & this.EXT_compiled_vertex_array_glUnlockArraysEXT_pointer != 0L;
    }

    private boolean EXT_depth_bounds_test_initNativeFunctionAddresses() {
        this.EXT_depth_bounds_test_glDepthBoundsEXT_pointer = GLContext.getFunctionAddress("glDepthBoundsEXT");
        return this.EXT_depth_bounds_test_glDepthBoundsEXT_pointer != 0L;
    }

    private boolean EXT_direct_state_access_initNativeFunctionAddresses(boolean forwardCompatible, Set supported_extensions) {
        boolean bl2 = (forwardCompatible || (this.EXT_direct_state_access_glClientAttribDefaultEXT_pointer = GLContext.getFunctionAddress("glClientAttribDefaultEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glPushClientAttribDefaultEXT_pointer = GLContext.getFunctionAddress("glPushClientAttribDefaultEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixLoadfEXT_pointer = GLContext.getFunctionAddress("glMatrixLoadfEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixLoaddEXT_pointer = GLContext.getFunctionAddress("glMatrixLoaddEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixMultfEXT_pointer = GLContext.getFunctionAddress("glMatrixMultfEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixMultdEXT_pointer = GLContext.getFunctionAddress("glMatrixMultdEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixLoadIdentityEXT_pointer = GLContext.getFunctionAddress("glMatrixLoadIdentityEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixRotatefEXT_pointer = GLContext.getFunctionAddress("glMatrixRotatefEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixRotatedEXT_pointer = GLContext.getFunctionAddress("glMatrixRotatedEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixScalefEXT_pointer = GLContext.getFunctionAddress("glMatrixScalefEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixScaledEXT_pointer = GLContext.getFunctionAddress("glMatrixScaledEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixTranslatefEXT_pointer = GLContext.getFunctionAddress("glMatrixTranslatefEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixTranslatedEXT_pointer = GLContext.getFunctionAddress("glMatrixTranslatedEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixOrthoEXT_pointer = GLContext.getFunctionAddress("glMatrixOrthoEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixFrustumEXT_pointer = GLContext.getFunctionAddress("glMatrixFrustumEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixPushEXT_pointer = GLContext.getFunctionAddress("glMatrixPushEXT")) != 0L) & (forwardCompatible || (this.EXT_direct_state_access_glMatrixPopEXT_pointer = GLContext.getFunctionAddress("glMatrixPopEXT")) != 0L);
        this.EXT_direct_state_access_glTextureParameteriEXT_pointer = GLContext.getFunctionAddress("glTextureParameteriEXT");
        this.EXT_direct_state_access_glTextureParameterivEXT_pointer = GLContext.getFunctionAddress("glTextureParameterivEXT");
        this.EXT_direct_state_access_glTextureParameterfEXT_pointer = GLContext.getFunctionAddress("glTextureParameterfEXT");
        this.EXT_direct_state_access_glTextureParameterfvEXT_pointer = GLContext.getFunctionAddress("glTextureParameterfvEXT");
        this.EXT_direct_state_access_glTextureImage1DEXT_pointer = GLContext.getFunctionAddress("glTextureImage1DEXT");
        this.EXT_direct_state_access_glTextureImage2DEXT_pointer = GLContext.getFunctionAddress("glTextureImage2DEXT");
        this.EXT_direct_state_access_glTextureSubImage1DEXT_pointer = GLContext.getFunctionAddress("glTextureSubImage1DEXT");
        this.EXT_direct_state_access_glTextureSubImage2DEXT_pointer = GLContext.getFunctionAddress("glTextureSubImage2DEXT");
        this.EXT_direct_state_access_glCopyTextureImage1DEXT_pointer = GLContext.getFunctionAddress("glCopyTextureImage1DEXT");
        this.EXT_direct_state_access_glCopyTextureImage2DEXT_pointer = GLContext.getFunctionAddress("glCopyTextureImage2DEXT");
        this.EXT_direct_state_access_glCopyTextureSubImage1DEXT_pointer = GLContext.getFunctionAddress("glCopyTextureSubImage1DEXT");
        this.EXT_direct_state_access_glCopyTextureSubImage2DEXT_pointer = GLContext.getFunctionAddress("glCopyTextureSubImage2DEXT");
        this.EXT_direct_state_access_glGetTextureImageEXT_pointer = GLContext.getFunctionAddress("glGetTextureImageEXT");
        this.EXT_direct_state_access_glGetTextureParameterfvEXT_pointer = GLContext.getFunctionAddress("glGetTextureParameterfvEXT");
        this.EXT_direct_state_access_glGetTextureParameterivEXT_pointer = GLContext.getFunctionAddress("glGetTextureParameterivEXT");
        this.EXT_direct_state_access_glGetTextureLevelParameterfvEXT_pointer = GLContext.getFunctionAddress("glGetTextureLevelParameterfvEXT");
        this.EXT_direct_state_access_glGetTextureLevelParameterivEXT_pointer = GLContext.getFunctionAddress("glGetTextureLevelParameterivEXT");
        boolean bl3 = bl2 & this.EXT_direct_state_access_glTextureParameteriEXT_pointer != 0L & this.EXT_direct_state_access_glTextureParameterivEXT_pointer != 0L & this.EXT_direct_state_access_glTextureParameterfEXT_pointer != 0L & this.EXT_direct_state_access_glTextureParameterfvEXT_pointer != 0L & this.EXT_direct_state_access_glTextureImage1DEXT_pointer != 0L & this.EXT_direct_state_access_glTextureImage2DEXT_pointer != 0L & this.EXT_direct_state_access_glTextureSubImage1DEXT_pointer != 0L & this.EXT_direct_state_access_glTextureSubImage2DEXT_pointer != 0L & this.EXT_direct_state_access_glCopyTextureImage1DEXT_pointer != 0L & this.EXT_direct_state_access_glCopyTextureImage2DEXT_pointer != 0L & this.EXT_direct_state_access_glCopyTextureSubImage1DEXT_pointer != 0L & this.EXT_direct_state_access_glCopyTextureSubImage2DEXT_pointer != 0L & this.EXT_direct_state_access_glGetTextureImageEXT_pointer != 0L & this.EXT_direct_state_access_glGetTextureParameterfvEXT_pointer != 0L & this.EXT_direct_state_access_glGetTextureParameterivEXT_pointer != 0L & this.EXT_direct_state_access_glGetTextureLevelParameterfvEXT_pointer != 0L & this.EXT_direct_state_access_glGetTextureLevelParameterivEXT_pointer != 0L & (!supported_extensions.contains("OpenGL12") || (this.EXT_direct_state_access_glTextureImage3DEXT_pointer = GLContext.getFunctionAddress("glTextureImage3DEXT")) != 0L) & (!supported_extensions.contains("OpenGL12") || (this.EXT_direct_state_access_glTextureSubImage3DEXT_pointer = GLContext.getFunctionAddress("glTextureSubImage3DEXT")) != 0L) & (!supported_extensions.contains("OpenGL12") || (this.EXT_direct_state_access_glCopyTextureSubImage3DEXT_pointer = GLContext.getFunctionAddress("glCopyTextureSubImage3DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glBindMultiTextureEXT_pointer = GLContext.getFunctionAddress("glBindMultiTextureEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexCoordPointerEXT_pointer = GLContext.getFunctionAddress("glMultiTexCoordPointerEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexEnvfEXT_pointer = GLContext.getFunctionAddress("glMultiTexEnvfEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexEnvfvEXT_pointer = GLContext.getFunctionAddress("glMultiTexEnvfvEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexEnviEXT_pointer = GLContext.getFunctionAddress("glMultiTexEnviEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexEnvivEXT_pointer = GLContext.getFunctionAddress("glMultiTexEnvivEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexGendEXT_pointer = GLContext.getFunctionAddress("glMultiTexGendEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexGendvEXT_pointer = GLContext.getFunctionAddress("glMultiTexGendvEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexGenfEXT_pointer = GLContext.getFunctionAddress("glMultiTexGenfEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexGenfvEXT_pointer = GLContext.getFunctionAddress("glMultiTexGenfvEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexGeniEXT_pointer = GLContext.getFunctionAddress("glMultiTexGeniEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexGenivEXT_pointer = GLContext.getFunctionAddress("glMultiTexGenivEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetMultiTexEnvfvEXT_pointer = GLContext.getFunctionAddress("glGetMultiTexEnvfvEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetMultiTexEnvivEXT_pointer = GLContext.getFunctionAddress("glGetMultiTexEnvivEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetMultiTexGendvEXT_pointer = GLContext.getFunctionAddress("glGetMultiTexGendvEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetMultiTexGenfvEXT_pointer = GLContext.getFunctionAddress("glGetMultiTexGenfvEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetMultiTexGenivEXT_pointer = GLContext.getFunctionAddress("glGetMultiTexGenivEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexParameteriEXT_pointer = GLContext.getFunctionAddress("glMultiTexParameteriEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexParameterivEXT_pointer = GLContext.getFunctionAddress("glMultiTexParameterivEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexParameterfEXT_pointer = GLContext.getFunctionAddress("glMultiTexParameterfEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexParameterfvEXT_pointer = GLContext.getFunctionAddress("glMultiTexParameterfvEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexImage1DEXT_pointer = GLContext.getFunctionAddress("glMultiTexImage1DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexImage2DEXT_pointer = GLContext.getFunctionAddress("glMultiTexImage2DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexSubImage1DEXT_pointer = GLContext.getFunctionAddress("glMultiTexSubImage1DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexSubImage2DEXT_pointer = GLContext.getFunctionAddress("glMultiTexSubImage2DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCopyMultiTexImage1DEXT_pointer = GLContext.getFunctionAddress("glCopyMultiTexImage1DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCopyMultiTexImage2DEXT_pointer = GLContext.getFunctionAddress("glCopyMultiTexImage2DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCopyMultiTexSubImage1DEXT_pointer = GLContext.getFunctionAddress("glCopyMultiTexSubImage1DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCopyMultiTexSubImage2DEXT_pointer = GLContext.getFunctionAddress("glCopyMultiTexSubImage2DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetMultiTexImageEXT_pointer = GLContext.getFunctionAddress("glGetMultiTexImageEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetMultiTexParameterfvEXT_pointer = GLContext.getFunctionAddress("glGetMultiTexParameterfvEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetMultiTexParameterivEXT_pointer = GLContext.getFunctionAddress("glGetMultiTexParameterivEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetMultiTexLevelParameterfvEXT_pointer = GLContext.getFunctionAddress("glGetMultiTexLevelParameterfvEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetMultiTexLevelParameterivEXT_pointer = GLContext.getFunctionAddress("glGetMultiTexLevelParameterivEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexImage3DEXT_pointer = GLContext.getFunctionAddress("glMultiTexImage3DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMultiTexSubImage3DEXT_pointer = GLContext.getFunctionAddress("glMultiTexSubImage3DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCopyMultiTexSubImage3DEXT_pointer = GLContext.getFunctionAddress("glCopyMultiTexSubImage3DEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glEnableClientStateIndexedEXT_pointer = GLContext.getFunctionAddress("glEnableClientStateIndexedEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glDisableClientStateIndexedEXT_pointer = GLContext.getFunctionAddress("glDisableClientStateIndexedEXT")) != 0L);
        if (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glEnableClientStateiEXT_pointer = GLContext.getFunctionAddress("glEnableClientStateiEXT")) == 0L) {
            // empty if block
        }
        boolean bl4 = bl3 & true;
        if (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glDisableClientStateiEXT_pointer = GLContext.getFunctionAddress("glDisableClientStateiEXT")) == 0L) {
            // empty if block
        }
        boolean bl5 = bl4 & true & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetFloatIndexedvEXT_pointer = GLContext.getFunctionAddress("glGetFloatIndexedvEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetDoubleIndexedvEXT_pointer = GLContext.getFunctionAddress("glGetDoubleIndexedvEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetPointerIndexedvEXT_pointer = GLContext.getFunctionAddress("glGetPointerIndexedvEXT")) != 0L);
        if (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glGetFloati_vEXT_pointer = GLContext.getFunctionAddress("glGetFloati_vEXT")) == 0L) {
            // empty if block
        }
        boolean bl6 = bl5 & true;
        if (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glGetDoublei_vEXT_pointer = GLContext.getFunctionAddress("glGetDoublei_vEXT")) == 0L) {
            // empty if block
        }
        boolean bl7 = bl6 & true;
        if (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glGetPointeri_vEXT_pointer = GLContext.getFunctionAddress("glGetPointeri_vEXT")) == 0L) {
            // empty if block
        }
        return bl7 & true & (!supported_extensions.contains("GL_EXT_draw_buffers2") || (this.EXT_direct_state_access_glEnableIndexedEXT_pointer = GLContext.getFunctionAddress("glEnableIndexedEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_draw_buffers2") || (this.EXT_direct_state_access_glDisableIndexedEXT_pointer = GLContext.getFunctionAddress("glDisableIndexedEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_draw_buffers2") || (this.EXT_direct_state_access_glIsEnabledIndexedEXT_pointer = GLContext.getFunctionAddress("glIsEnabledIndexedEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_draw_buffers2") || (this.EXT_direct_state_access_glGetIntegerIndexedvEXT_pointer = GLContext.getFunctionAddress("glGetIntegerIndexedvEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_draw_buffers2") || (this.EXT_direct_state_access_glGetBooleanIndexedvEXT_pointer = GLContext.getFunctionAddress("glGetBooleanIndexedvEXT")) != 0L) & (!supported_extensions.contains("GL_ARB_vertex_program") || (this.EXT_direct_state_access_glNamedProgramStringEXT_pointer = GLContext.getFunctionAddress("glNamedProgramStringEXT")) != 0L) & (!supported_extensions.contains("GL_ARB_vertex_program") || (this.EXT_direct_state_access_glNamedProgramLocalParameter4dEXT_pointer = GLContext.getFunctionAddress("glNamedProgramLocalParameter4dEXT")) != 0L) & (!supported_extensions.contains("GL_ARB_vertex_program") || (this.EXT_direct_state_access_glNamedProgramLocalParameter4dvEXT_pointer = GLContext.getFunctionAddress("glNamedProgramLocalParameter4dvEXT")) != 0L) & (!supported_extensions.contains("GL_ARB_vertex_program") || (this.EXT_direct_state_access_glNamedProgramLocalParameter4fEXT_pointer = GLContext.getFunctionAddress("glNamedProgramLocalParameter4fEXT")) != 0L) & (!supported_extensions.contains("GL_ARB_vertex_program") || (this.EXT_direct_state_access_glNamedProgramLocalParameter4fvEXT_pointer = GLContext.getFunctionAddress("glNamedProgramLocalParameter4fvEXT")) != 0L) & (!supported_extensions.contains("GL_ARB_vertex_program") || (this.EXT_direct_state_access_glGetNamedProgramLocalParameterdvEXT_pointer = GLContext.getFunctionAddress("glGetNamedProgramLocalParameterdvEXT")) != 0L) & (!supported_extensions.contains("GL_ARB_vertex_program") || (this.EXT_direct_state_access_glGetNamedProgramLocalParameterfvEXT_pointer = GLContext.getFunctionAddress("glGetNamedProgramLocalParameterfvEXT")) != 0L) & (!supported_extensions.contains("GL_ARB_vertex_program") || (this.EXT_direct_state_access_glGetNamedProgramivEXT_pointer = GLContext.getFunctionAddress("glGetNamedProgramivEXT")) != 0L) & (!supported_extensions.contains("GL_ARB_vertex_program") || (this.EXT_direct_state_access_glGetNamedProgramStringEXT_pointer = GLContext.getFunctionAddress("glGetNamedProgramStringEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCompressedTextureImage3DEXT_pointer = GLContext.getFunctionAddress("glCompressedTextureImage3DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCompressedTextureImage2DEXT_pointer = GLContext.getFunctionAddress("glCompressedTextureImage2DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCompressedTextureImage1DEXT_pointer = GLContext.getFunctionAddress("glCompressedTextureImage1DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCompressedTextureSubImage3DEXT_pointer = GLContext.getFunctionAddress("glCompressedTextureSubImage3DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCompressedTextureSubImage2DEXT_pointer = GLContext.getFunctionAddress("glCompressedTextureSubImage2DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCompressedTextureSubImage1DEXT_pointer = GLContext.getFunctionAddress("glCompressedTextureSubImage1DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetCompressedTextureImageEXT_pointer = GLContext.getFunctionAddress("glGetCompressedTextureImageEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCompressedMultiTexImage3DEXT_pointer = GLContext.getFunctionAddress("glCompressedMultiTexImage3DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCompressedMultiTexImage2DEXT_pointer = GLContext.getFunctionAddress("glCompressedMultiTexImage2DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCompressedMultiTexImage1DEXT_pointer = GLContext.getFunctionAddress("glCompressedMultiTexImage1DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCompressedMultiTexSubImage3DEXT_pointer = GLContext.getFunctionAddress("glCompressedMultiTexSubImage3DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCompressedMultiTexSubImage2DEXT_pointer = GLContext.getFunctionAddress("glCompressedMultiTexSubImage2DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glCompressedMultiTexSubImage1DEXT_pointer = GLContext.getFunctionAddress("glCompressedMultiTexSubImage1DEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetCompressedMultiTexImageEXT_pointer = GLContext.getFunctionAddress("glGetCompressedMultiTexImageEXT")) != 0L) & (!supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glGetCompressedTexImage_pointer = GLContext.getFunctionAddress("glGetCompressedTexImage")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMatrixLoadTransposefEXT_pointer = GLContext.getFunctionAddress("glMatrixLoadTransposefEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMatrixLoadTransposedEXT_pointer = GLContext.getFunctionAddress("glMatrixLoadTransposedEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMatrixMultTransposefEXT_pointer = GLContext.getFunctionAddress("glMatrixMultTransposefEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL13") || (this.EXT_direct_state_access_glMatrixMultTransposedEXT_pointer = GLContext.getFunctionAddress("glMatrixMultTransposedEXT")) != 0L) & (!supported_extensions.contains("OpenGL15") || (this.EXT_direct_state_access_glNamedBufferDataEXT_pointer = GLContext.getFunctionAddress("glNamedBufferDataEXT")) != 0L) & (!supported_extensions.contains("OpenGL15") || (this.EXT_direct_state_access_glNamedBufferSubDataEXT_pointer = GLContext.getFunctionAddress("glNamedBufferSubDataEXT")) != 0L) & (!supported_extensions.contains("OpenGL15") || (this.EXT_direct_state_access_glMapNamedBufferEXT_pointer = GLContext.getFunctionAddress("glMapNamedBufferEXT")) != 0L) & (!supported_extensions.contains("OpenGL15") || (this.EXT_direct_state_access_glUnmapNamedBufferEXT_pointer = GLContext.getFunctionAddress("glUnmapNamedBufferEXT")) != 0L) & (!supported_extensions.contains("OpenGL15") || (this.EXT_direct_state_access_glGetNamedBufferParameterivEXT_pointer = GLContext.getFunctionAddress("glGetNamedBufferParameterivEXT")) != 0L) & (!supported_extensions.contains("OpenGL15") || (this.EXT_direct_state_access_glGetNamedBufferPointervEXT_pointer = GLContext.getFunctionAddress("glGetNamedBufferPointervEXT")) != 0L) & (!supported_extensions.contains("OpenGL15") || (this.EXT_direct_state_access_glGetNamedBufferSubDataEXT_pointer = GLContext.getFunctionAddress("glGetNamedBufferSubDataEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform1fEXT_pointer = GLContext.getFunctionAddress("glProgramUniform1fEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform2fEXT_pointer = GLContext.getFunctionAddress("glProgramUniform2fEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform3fEXT_pointer = GLContext.getFunctionAddress("glProgramUniform3fEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform4fEXT_pointer = GLContext.getFunctionAddress("glProgramUniform4fEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform1iEXT_pointer = GLContext.getFunctionAddress("glProgramUniform1iEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform2iEXT_pointer = GLContext.getFunctionAddress("glProgramUniform2iEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform3iEXT_pointer = GLContext.getFunctionAddress("glProgramUniform3iEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform4iEXT_pointer = GLContext.getFunctionAddress("glProgramUniform4iEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform1fvEXT_pointer = GLContext.getFunctionAddress("glProgramUniform1fvEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform2fvEXT_pointer = GLContext.getFunctionAddress("glProgramUniform2fvEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform3fvEXT_pointer = GLContext.getFunctionAddress("glProgramUniform3fvEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform4fvEXT_pointer = GLContext.getFunctionAddress("glProgramUniform4fvEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform1ivEXT_pointer = GLContext.getFunctionAddress("glProgramUniform1ivEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform2ivEXT_pointer = GLContext.getFunctionAddress("glProgramUniform2ivEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform3ivEXT_pointer = GLContext.getFunctionAddress("glProgramUniform3ivEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniform4ivEXT_pointer = GLContext.getFunctionAddress("glProgramUniform4ivEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniformMatrix2fvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix2fvEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniformMatrix3fvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix3fvEXT")) != 0L) & (!supported_extensions.contains("OpenGL20") || (this.EXT_direct_state_access_glProgramUniformMatrix4fvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix4fvEXT")) != 0L) & (!supported_extensions.contains("OpenGL21") || (this.EXT_direct_state_access_glProgramUniformMatrix2x3fvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix2x3fvEXT")) != 0L) & (!supported_extensions.contains("OpenGL21") || (this.EXT_direct_state_access_glProgramUniformMatrix3x2fvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix3x2fvEXT")) != 0L) & (!supported_extensions.contains("OpenGL21") || (this.EXT_direct_state_access_glProgramUniformMatrix2x4fvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix2x4fvEXT")) != 0L) & (!supported_extensions.contains("OpenGL21") || (this.EXT_direct_state_access_glProgramUniformMatrix4x2fvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix4x2fvEXT")) != 0L) & (!supported_extensions.contains("OpenGL21") || (this.EXT_direct_state_access_glProgramUniformMatrix3x4fvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix3x4fvEXT")) != 0L) & (!supported_extensions.contains("OpenGL21") || (this.EXT_direct_state_access_glProgramUniformMatrix4x3fvEXT_pointer = GLContext.getFunctionAddress("glProgramUniformMatrix4x3fvEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_texture_buffer_object") || (this.EXT_direct_state_access_glTextureBufferEXT_pointer = GLContext.getFunctionAddress("glTextureBufferEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_texture_buffer_object") || (this.EXT_direct_state_access_glMultiTexBufferEXT_pointer = GLContext.getFunctionAddress("glMultiTexBufferEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_texture_integer") || (this.EXT_direct_state_access_glTextureParameterIivEXT_pointer = GLContext.getFunctionAddress("glTextureParameterIivEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_texture_integer") || (this.EXT_direct_state_access_glTextureParameterIuivEXT_pointer = GLContext.getFunctionAddress("glTextureParameterIuivEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_texture_integer") || (this.EXT_direct_state_access_glGetTextureParameterIivEXT_pointer = GLContext.getFunctionAddress("glGetTextureParameterIivEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_texture_integer") || (this.EXT_direct_state_access_glGetTextureParameterIuivEXT_pointer = GLContext.getFunctionAddress("glGetTextureParameterIuivEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_texture_integer") || (this.EXT_direct_state_access_glMultiTexParameterIivEXT_pointer = GLContext.getFunctionAddress("glMultiTexParameterIivEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_texture_integer") || (this.EXT_direct_state_access_glMultiTexParameterIuivEXT_pointer = GLContext.getFunctionAddress("glMultiTexParameterIuivEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_texture_integer") || (this.EXT_direct_state_access_glGetMultiTexParameterIivEXT_pointer = GLContext.getFunctionAddress("glGetMultiTexParameterIivEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_texture_integer") || (this.EXT_direct_state_access_glGetMultiTexParameterIuivEXT_pointer = GLContext.getFunctionAddress("glGetMultiTexParameterIuivEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_gpu_shader4") || (this.EXT_direct_state_access_glProgramUniform1uiEXT_pointer = GLContext.getFunctionAddress("glProgramUniform1uiEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_gpu_shader4") || (this.EXT_direct_state_access_glProgramUniform2uiEXT_pointer = GLContext.getFunctionAddress("glProgramUniform2uiEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_gpu_shader4") || (this.EXT_direct_state_access_glProgramUniform3uiEXT_pointer = GLContext.getFunctionAddress("glProgramUniform3uiEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_gpu_shader4") || (this.EXT_direct_state_access_glProgramUniform4uiEXT_pointer = GLContext.getFunctionAddress("glProgramUniform4uiEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_gpu_shader4") || (this.EXT_direct_state_access_glProgramUniform1uivEXT_pointer = GLContext.getFunctionAddress("glProgramUniform1uivEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_gpu_shader4") || (this.EXT_direct_state_access_glProgramUniform2uivEXT_pointer = GLContext.getFunctionAddress("glProgramUniform2uivEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_gpu_shader4") || (this.EXT_direct_state_access_glProgramUniform3uivEXT_pointer = GLContext.getFunctionAddress("glProgramUniform3uivEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_gpu_shader4") || (this.EXT_direct_state_access_glProgramUniform4uivEXT_pointer = GLContext.getFunctionAddress("glProgramUniform4uivEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_gpu_program_parameters") || (this.EXT_direct_state_access_glNamedProgramLocalParameters4fvEXT_pointer = GLContext.getFunctionAddress("glNamedProgramLocalParameters4fvEXT")) != 0L) & (!supported_extensions.contains("GL_NV_gpu_program4") || (this.EXT_direct_state_access_glNamedProgramLocalParameterI4iEXT_pointer = GLContext.getFunctionAddress("glNamedProgramLocalParameterI4iEXT")) != 0L) & (!supported_extensions.contains("GL_NV_gpu_program4") || (this.EXT_direct_state_access_glNamedProgramLocalParameterI4ivEXT_pointer = GLContext.getFunctionAddress("glNamedProgramLocalParameterI4ivEXT")) != 0L) & (!supported_extensions.contains("GL_NV_gpu_program4") || (this.EXT_direct_state_access_glNamedProgramLocalParametersI4ivEXT_pointer = GLContext.getFunctionAddress("glNamedProgramLocalParametersI4ivEXT")) != 0L) & (!supported_extensions.contains("GL_NV_gpu_program4") || (this.EXT_direct_state_access_glNamedProgramLocalParameterI4uiEXT_pointer = GLContext.getFunctionAddress("glNamedProgramLocalParameterI4uiEXT")) != 0L) & (!supported_extensions.contains("GL_NV_gpu_program4") || (this.EXT_direct_state_access_glNamedProgramLocalParameterI4uivEXT_pointer = GLContext.getFunctionAddress("glNamedProgramLocalParameterI4uivEXT")) != 0L) & (!supported_extensions.contains("GL_NV_gpu_program4") || (this.EXT_direct_state_access_glNamedProgramLocalParametersI4uivEXT_pointer = GLContext.getFunctionAddress("glNamedProgramLocalParametersI4uivEXT")) != 0L) & (!supported_extensions.contains("GL_NV_gpu_program4") || (this.EXT_direct_state_access_glGetNamedProgramLocalParameterIivEXT_pointer = GLContext.getFunctionAddress("glGetNamedProgramLocalParameterIivEXT")) != 0L) & (!supported_extensions.contains("GL_NV_gpu_program4") || (this.EXT_direct_state_access_glGetNamedProgramLocalParameterIuivEXT_pointer = GLContext.getFunctionAddress("glGetNamedProgramLocalParameterIuivEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_object") || (this.EXT_direct_state_access_glNamedRenderbufferStorageEXT_pointer = GLContext.getFunctionAddress("glNamedRenderbufferStorageEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_object") || (this.EXT_direct_state_access_glGetNamedRenderbufferParameterivEXT_pointer = GLContext.getFunctionAddress("glGetNamedRenderbufferParameterivEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_multisample") || (this.EXT_direct_state_access_glNamedRenderbufferStorageMultisampleEXT_pointer = GLContext.getFunctionAddress("glNamedRenderbufferStorageMultisampleEXT")) != 0L) & (!supported_extensions.contains("GL_NV_framebuffer_multisample_coverage") || (this.EXT_direct_state_access_glNamedRenderbufferStorageMultisampleCoverageEXT_pointer = GLContext.getFunctionAddress("glNamedRenderbufferStorageMultisampleCoverageEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_object") || (this.EXT_direct_state_access_glCheckNamedFramebufferStatusEXT_pointer = GLContext.getFunctionAddress("glCheckNamedFramebufferStatusEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_object") || (this.EXT_direct_state_access_glNamedFramebufferTexture1DEXT_pointer = GLContext.getFunctionAddress("glNamedFramebufferTexture1DEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_object") || (this.EXT_direct_state_access_glNamedFramebufferTexture2DEXT_pointer = GLContext.getFunctionAddress("glNamedFramebufferTexture2DEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_object") || (this.EXT_direct_state_access_glNamedFramebufferTexture3DEXT_pointer = GLContext.getFunctionAddress("glNamedFramebufferTexture3DEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_object") || (this.EXT_direct_state_access_glNamedFramebufferRenderbufferEXT_pointer = GLContext.getFunctionAddress("glNamedFramebufferRenderbufferEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_object") || (this.EXT_direct_state_access_glGetNamedFramebufferAttachmentParameterivEXT_pointer = GLContext.getFunctionAddress("glGetNamedFramebufferAttachmentParameterivEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_object") || (this.EXT_direct_state_access_glGenerateTextureMipmapEXT_pointer = GLContext.getFunctionAddress("glGenerateTextureMipmapEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_object") || (this.EXT_direct_state_access_glGenerateMultiTexMipmapEXT_pointer = GLContext.getFunctionAddress("glGenerateMultiTexMipmapEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_object") || (this.EXT_direct_state_access_glFramebufferDrawBufferEXT_pointer = GLContext.getFunctionAddress("glFramebufferDrawBufferEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_object") || (this.EXT_direct_state_access_glFramebufferDrawBuffersEXT_pointer = GLContext.getFunctionAddress("glFramebufferDrawBuffersEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_object") || (this.EXT_direct_state_access_glFramebufferReadBufferEXT_pointer = GLContext.getFunctionAddress("glFramebufferReadBufferEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") && !supported_extensions.contains("GL_EXT_framebuffer_object") || (this.EXT_direct_state_access_glGetFramebufferParameterivEXT_pointer = GLContext.getFunctionAddress("glGetFramebufferParameterivEXT")) != 0L) & (!supported_extensions.contains("OpenGL31") && !supported_extensions.contains("GL_ARB_copy_buffer") || (this.EXT_direct_state_access_glNamedCopyBufferSubDataEXT_pointer = GLContext.getFunctionAddress("glNamedCopyBufferSubDataEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_geometry_shader4") && !supported_extensions.contains("NV_geometry_program4") || (this.EXT_direct_state_access_glNamedFramebufferTextureEXT_pointer = GLContext.getFunctionAddress("glNamedFramebufferTextureEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_geometry_shader4") && !supported_extensions.contains("NV_geometry_program4") || (this.EXT_direct_state_access_glNamedFramebufferTextureLayerEXT_pointer = GLContext.getFunctionAddress("glNamedFramebufferTextureLayerEXT")) != 0L) & (!supported_extensions.contains("GL_EXT_geometry_shader4") && !supported_extensions.contains("NV_geometry_program4") || (this.EXT_direct_state_access_glNamedFramebufferTextureFaceEXT_pointer = GLContext.getFunctionAddress("glNamedFramebufferTextureFaceEXT")) != 0L) & (!supported_extensions.contains("GL_NV_explicit_multisample") || (this.EXT_direct_state_access_glTextureRenderbufferEXT_pointer = GLContext.getFunctionAddress("glTextureRenderbufferEXT")) != 0L) & (!supported_extensions.contains("GL_NV_explicit_multisample") || (this.EXT_direct_state_access_glMultiTexRenderbufferEXT_pointer = GLContext.getFunctionAddress("glMultiTexRenderbufferEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glVertexArrayVertexOffsetEXT_pointer = GLContext.getFunctionAddress("glVertexArrayVertexOffsetEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glVertexArrayColorOffsetEXT_pointer = GLContext.getFunctionAddress("glVertexArrayColorOffsetEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glVertexArrayEdgeFlagOffsetEXT_pointer = GLContext.getFunctionAddress("glVertexArrayEdgeFlagOffsetEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glVertexArrayIndexOffsetEXT_pointer = GLContext.getFunctionAddress("glVertexArrayIndexOffsetEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glVertexArrayNormalOffsetEXT_pointer = GLContext.getFunctionAddress("glVertexArrayNormalOffsetEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glVertexArrayTexCoordOffsetEXT_pointer = GLContext.getFunctionAddress("glVertexArrayTexCoordOffsetEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glVertexArrayMultiTexCoordOffsetEXT_pointer = GLContext.getFunctionAddress("glVertexArrayMultiTexCoordOffsetEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glVertexArrayFogCoordOffsetEXT_pointer = GLContext.getFunctionAddress("glVertexArrayFogCoordOffsetEXT")) != 0L) & (forwardCompatible || !supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glVertexArraySecondaryColorOffsetEXT_pointer = GLContext.getFunctionAddress("glVertexArraySecondaryColorOffsetEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glVertexArrayVertexAttribOffsetEXT_pointer = GLContext.getFunctionAddress("glVertexArrayVertexAttribOffsetEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glVertexArrayVertexAttribIOffsetEXT_pointer = GLContext.getFunctionAddress("glVertexArrayVertexAttribIOffsetEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glEnableVertexArrayEXT_pointer = GLContext.getFunctionAddress("glEnableVertexArrayEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glDisableVertexArrayEXT_pointer = GLContext.getFunctionAddress("glDisableVertexArrayEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glEnableVertexArrayAttribEXT_pointer = GLContext.getFunctionAddress("glEnableVertexArrayAttribEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glDisableVertexArrayAttribEXT_pointer = GLContext.getFunctionAddress("glDisableVertexArrayAttribEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glGetVertexArrayIntegervEXT_pointer = GLContext.getFunctionAddress("glGetVertexArrayIntegervEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glGetVertexArrayPointervEXT_pointer = GLContext.getFunctionAddress("glGetVertexArrayPointervEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glGetVertexArrayIntegeri_vEXT_pointer = GLContext.getFunctionAddress("glGetVertexArrayIntegeri_vEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glGetVertexArrayPointeri_vEXT_pointer = GLContext.getFunctionAddress("glGetVertexArrayPointeri_vEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glMapNamedBufferRangeEXT_pointer = GLContext.getFunctionAddress("glMapNamedBufferRangeEXT")) != 0L) & (!supported_extensions.contains("OpenGL30") || (this.EXT_direct_state_access_glFlushMappedNamedBufferRangeEXT_pointer = GLContext.getFunctionAddress("glFlushMappedNamedBufferRangeEXT")) != 0L);
    }

    private boolean EXT_draw_buffers2_initNativeFunctionAddresses() {
        this.EXT_draw_buffers2_glColorMaskIndexedEXT_pointer = GLContext.getFunctionAddress("glColorMaskIndexedEXT");
        boolean bl2 = this.EXT_draw_buffers2_glColorMaskIndexedEXT_pointer != 0L;
        this.EXT_draw_buffers2_glGetBooleanIndexedvEXT_pointer = GLContext.getFunctionAddress("glGetBooleanIndexedvEXT");
        this.EXT_draw_buffers2_glGetIntegerIndexedvEXT_pointer = GLContext.getFunctionAddress("glGetIntegerIndexedvEXT");
        this.EXT_draw_buffers2_glEnableIndexedEXT_pointer = GLContext.getFunctionAddress("glEnableIndexedEXT");
        this.EXT_draw_buffers2_glDisableIndexedEXT_pointer = GLContext.getFunctionAddress("glDisableIndexedEXT");
        this.EXT_draw_buffers2_glIsEnabledIndexedEXT_pointer = GLContext.getFunctionAddress("glIsEnabledIndexedEXT");
        return bl2 & this.EXT_draw_buffers2_glGetBooleanIndexedvEXT_pointer != 0L & this.EXT_draw_buffers2_glGetIntegerIndexedvEXT_pointer != 0L & this.EXT_draw_buffers2_glEnableIndexedEXT_pointer != 0L & this.EXT_draw_buffers2_glDisableIndexedEXT_pointer != 0L & this.EXT_draw_buffers2_glIsEnabledIndexedEXT_pointer != 0L;
    }

    private boolean EXT_draw_instanced_initNativeFunctionAddresses() {
        this.EXT_draw_instanced_glDrawArraysInstancedEXT_pointer = GLContext.getFunctionAddress("glDrawArraysInstancedEXT");
        boolean bl2 = this.EXT_draw_instanced_glDrawArraysInstancedEXT_pointer != 0L;
        this.EXT_draw_instanced_glDrawElementsInstancedEXT_pointer = GLContext.getFunctionAddress("glDrawElementsInstancedEXT");
        return bl2 & this.EXT_draw_instanced_glDrawElementsInstancedEXT_pointer != 0L;
    }

    private boolean EXT_draw_range_elements_initNativeFunctionAddresses() {
        this.EXT_draw_range_elements_glDrawRangeElementsEXT_pointer = GLContext.getFunctionAddress("glDrawRangeElementsEXT");
        return this.EXT_draw_range_elements_glDrawRangeElementsEXT_pointer != 0L;
    }

    private boolean EXT_fog_coord_initNativeFunctionAddresses() {
        this.EXT_fog_coord_glFogCoordfEXT_pointer = GLContext.getFunctionAddress("glFogCoordfEXT");
        boolean bl2 = this.EXT_fog_coord_glFogCoordfEXT_pointer != 0L;
        this.EXT_fog_coord_glFogCoorddEXT_pointer = GLContext.getFunctionAddress("glFogCoorddEXT");
        this.EXT_fog_coord_glFogCoordPointerEXT_pointer = GLContext.getFunctionAddress("glFogCoordPointerEXT");
        return bl2 & this.EXT_fog_coord_glFogCoorddEXT_pointer != 0L & this.EXT_fog_coord_glFogCoordPointerEXT_pointer != 0L;
    }

    private boolean EXT_framebuffer_blit_initNativeFunctionAddresses() {
        this.EXT_framebuffer_blit_glBlitFramebufferEXT_pointer = GLContext.getFunctionAddress("glBlitFramebufferEXT");
        return this.EXT_framebuffer_blit_glBlitFramebufferEXT_pointer != 0L;
    }

    private boolean EXT_framebuffer_multisample_initNativeFunctionAddresses() {
        this.EXT_framebuffer_multisample_glRenderbufferStorageMultisampleEXT_pointer = GLContext.getFunctionAddress("glRenderbufferStorageMultisampleEXT");
        return this.EXT_framebuffer_multisample_glRenderbufferStorageMultisampleEXT_pointer != 0L;
    }

    private boolean EXT_framebuffer_object_initNativeFunctionAddresses() {
        this.EXT_framebuffer_object_glIsRenderbufferEXT_pointer = GLContext.getFunctionAddress("glIsRenderbufferEXT");
        boolean bl2 = this.EXT_framebuffer_object_glIsRenderbufferEXT_pointer != 0L;
        this.EXT_framebuffer_object_glBindRenderbufferEXT_pointer = GLContext.getFunctionAddress("glBindRenderbufferEXT");
        this.EXT_framebuffer_object_glDeleteRenderbuffersEXT_pointer = GLContext.getFunctionAddress("glDeleteRenderbuffersEXT");
        this.EXT_framebuffer_object_glGenRenderbuffersEXT_pointer = GLContext.getFunctionAddress("glGenRenderbuffersEXT");
        this.EXT_framebuffer_object_glRenderbufferStorageEXT_pointer = GLContext.getFunctionAddress("glRenderbufferStorageEXT");
        this.EXT_framebuffer_object_glGetRenderbufferParameterivEXT_pointer = GLContext.getFunctionAddress("glGetRenderbufferParameterivEXT");
        this.EXT_framebuffer_object_glIsFramebufferEXT_pointer = GLContext.getFunctionAddress("glIsFramebufferEXT");
        this.EXT_framebuffer_object_glBindFramebufferEXT_pointer = GLContext.getFunctionAddress("glBindFramebufferEXT");
        this.EXT_framebuffer_object_glDeleteFramebuffersEXT_pointer = GLContext.getFunctionAddress("glDeleteFramebuffersEXT");
        this.EXT_framebuffer_object_glGenFramebuffersEXT_pointer = GLContext.getFunctionAddress("glGenFramebuffersEXT");
        this.EXT_framebuffer_object_glCheckFramebufferStatusEXT_pointer = GLContext.getFunctionAddress("glCheckFramebufferStatusEXT");
        this.EXT_framebuffer_object_glFramebufferTexture1DEXT_pointer = GLContext.getFunctionAddress("glFramebufferTexture1DEXT");
        this.EXT_framebuffer_object_glFramebufferTexture2DEXT_pointer = GLContext.getFunctionAddress("glFramebufferTexture2DEXT");
        this.EXT_framebuffer_object_glFramebufferTexture3DEXT_pointer = GLContext.getFunctionAddress("glFramebufferTexture3DEXT");
        this.EXT_framebuffer_object_glFramebufferRenderbufferEXT_pointer = GLContext.getFunctionAddress("glFramebufferRenderbufferEXT");
        this.EXT_framebuffer_object_glGetFramebufferAttachmentParameterivEXT_pointer = GLContext.getFunctionAddress("glGetFramebufferAttachmentParameterivEXT");
        this.EXT_framebuffer_object_glGenerateMipmapEXT_pointer = GLContext.getFunctionAddress("glGenerateMipmapEXT");
        return bl2 & this.EXT_framebuffer_object_glBindRenderbufferEXT_pointer != 0L & this.EXT_framebuffer_object_glDeleteRenderbuffersEXT_pointer != 0L & this.EXT_framebuffer_object_glGenRenderbuffersEXT_pointer != 0L & this.EXT_framebuffer_object_glRenderbufferStorageEXT_pointer != 0L & this.EXT_framebuffer_object_glGetRenderbufferParameterivEXT_pointer != 0L & this.EXT_framebuffer_object_glIsFramebufferEXT_pointer != 0L & this.EXT_framebuffer_object_glBindFramebufferEXT_pointer != 0L & this.EXT_framebuffer_object_glDeleteFramebuffersEXT_pointer != 0L & this.EXT_framebuffer_object_glGenFramebuffersEXT_pointer != 0L & this.EXT_framebuffer_object_glCheckFramebufferStatusEXT_pointer != 0L & this.EXT_framebuffer_object_glFramebufferTexture1DEXT_pointer != 0L & this.EXT_framebuffer_object_glFramebufferTexture2DEXT_pointer != 0L & this.EXT_framebuffer_object_glFramebufferTexture3DEXT_pointer != 0L & this.EXT_framebuffer_object_glFramebufferRenderbufferEXT_pointer != 0L & this.EXT_framebuffer_object_glGetFramebufferAttachmentParameterivEXT_pointer != 0L & this.EXT_framebuffer_object_glGenerateMipmapEXT_pointer != 0L;
    }

    private boolean EXT_geometry_shader4_initNativeFunctionAddresses() {
        this.EXT_geometry_shader4_glProgramParameteriEXT_pointer = GLContext.getFunctionAddress("glProgramParameteriEXT");
        boolean bl2 = this.EXT_geometry_shader4_glProgramParameteriEXT_pointer != 0L;
        this.EXT_geometry_shader4_glFramebufferTextureEXT_pointer = GLContext.getFunctionAddress("glFramebufferTextureEXT");
        this.EXT_geometry_shader4_glFramebufferTextureLayerEXT_pointer = GLContext.getFunctionAddress("glFramebufferTextureLayerEXT");
        this.EXT_geometry_shader4_glFramebufferTextureFaceEXT_pointer = GLContext.getFunctionAddress("glFramebufferTextureFaceEXT");
        return bl2 & this.EXT_geometry_shader4_glFramebufferTextureEXT_pointer != 0L & this.EXT_geometry_shader4_glFramebufferTextureLayerEXT_pointer != 0L & this.EXT_geometry_shader4_glFramebufferTextureFaceEXT_pointer != 0L;
    }

    private boolean EXT_gpu_program_parameters_initNativeFunctionAddresses() {
        this.EXT_gpu_program_parameters_glProgramEnvParameters4fvEXT_pointer = GLContext.getFunctionAddress("glProgramEnvParameters4fvEXT");
        boolean bl2 = this.EXT_gpu_program_parameters_glProgramEnvParameters4fvEXT_pointer != 0L;
        this.EXT_gpu_program_parameters_glProgramLocalParameters4fvEXT_pointer = GLContext.getFunctionAddress("glProgramLocalParameters4fvEXT");
        return bl2 & this.EXT_gpu_program_parameters_glProgramLocalParameters4fvEXT_pointer != 0L;
    }

    private boolean EXT_gpu_shader4_initNativeFunctionAddresses() {
        this.EXT_gpu_shader4_glVertexAttribI1iEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI1iEXT");
        boolean bl2 = this.EXT_gpu_shader4_glVertexAttribI1iEXT_pointer != 0L;
        this.EXT_gpu_shader4_glVertexAttribI2iEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI2iEXT");
        this.EXT_gpu_shader4_glVertexAttribI3iEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI3iEXT");
        this.EXT_gpu_shader4_glVertexAttribI4iEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI4iEXT");
        this.EXT_gpu_shader4_glVertexAttribI1uiEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI1uiEXT");
        this.EXT_gpu_shader4_glVertexAttribI2uiEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI2uiEXT");
        this.EXT_gpu_shader4_glVertexAttribI3uiEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI3uiEXT");
        this.EXT_gpu_shader4_glVertexAttribI4uiEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI4uiEXT");
        this.EXT_gpu_shader4_glVertexAttribI1ivEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI1ivEXT");
        this.EXT_gpu_shader4_glVertexAttribI2ivEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI2ivEXT");
        this.EXT_gpu_shader4_glVertexAttribI3ivEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI3ivEXT");
        this.EXT_gpu_shader4_glVertexAttribI4ivEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI4ivEXT");
        this.EXT_gpu_shader4_glVertexAttribI1uivEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI1uivEXT");
        this.EXT_gpu_shader4_glVertexAttribI2uivEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI2uivEXT");
        this.EXT_gpu_shader4_glVertexAttribI3uivEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI3uivEXT");
        this.EXT_gpu_shader4_glVertexAttribI4uivEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI4uivEXT");
        this.EXT_gpu_shader4_glVertexAttribI4bvEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI4bvEXT");
        this.EXT_gpu_shader4_glVertexAttribI4svEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI4svEXT");
        this.EXT_gpu_shader4_glVertexAttribI4ubvEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI4ubvEXT");
        this.EXT_gpu_shader4_glVertexAttribI4usvEXT_pointer = GLContext.getFunctionAddress("glVertexAttribI4usvEXT");
        this.EXT_gpu_shader4_glVertexAttribIPointerEXT_pointer = GLContext.getFunctionAddress("glVertexAttribIPointerEXT");
        this.EXT_gpu_shader4_glGetVertexAttribIivEXT_pointer = GLContext.getFunctionAddress("glGetVertexAttribIivEXT");
        this.EXT_gpu_shader4_glGetVertexAttribIuivEXT_pointer = GLContext.getFunctionAddress("glGetVertexAttribIuivEXT");
        this.EXT_gpu_shader4_glUniform1uiEXT_pointer = GLContext.getFunctionAddress("glUniform1uiEXT");
        this.EXT_gpu_shader4_glUniform2uiEXT_pointer = GLContext.getFunctionAddress("glUniform2uiEXT");
        this.EXT_gpu_shader4_glUniform3uiEXT_pointer = GLContext.getFunctionAddress("glUniform3uiEXT");
        this.EXT_gpu_shader4_glUniform4uiEXT_pointer = GLContext.getFunctionAddress("glUniform4uiEXT");
        this.EXT_gpu_shader4_glUniform1uivEXT_pointer = GLContext.getFunctionAddress("glUniform1uivEXT");
        this.EXT_gpu_shader4_glUniform2uivEXT_pointer = GLContext.getFunctionAddress("glUniform2uivEXT");
        this.EXT_gpu_shader4_glUniform3uivEXT_pointer = GLContext.getFunctionAddress("glUniform3uivEXT");
        this.EXT_gpu_shader4_glUniform4uivEXT_pointer = GLContext.getFunctionAddress("glUniform4uivEXT");
        this.EXT_gpu_shader4_glGetUniformuivEXT_pointer = GLContext.getFunctionAddress("glGetUniformuivEXT");
        this.EXT_gpu_shader4_glBindFragDataLocationEXT_pointer = GLContext.getFunctionAddress("glBindFragDataLocationEXT");
        this.EXT_gpu_shader4_glGetFragDataLocationEXT_pointer = GLContext.getFunctionAddress("glGetFragDataLocationEXT");
        return bl2 & this.EXT_gpu_shader4_glVertexAttribI2iEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI3iEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI4iEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI1uiEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI2uiEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI3uiEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI4uiEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI1ivEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI2ivEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI3ivEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI4ivEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI1uivEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI2uivEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI3uivEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI4uivEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI4bvEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI4svEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI4ubvEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribI4usvEXT_pointer != 0L & this.EXT_gpu_shader4_glVertexAttribIPointerEXT_pointer != 0L & this.EXT_gpu_shader4_glGetVertexAttribIivEXT_pointer != 0L & this.EXT_gpu_shader4_glGetVertexAttribIuivEXT_pointer != 0L & this.EXT_gpu_shader4_glUniform1uiEXT_pointer != 0L & this.EXT_gpu_shader4_glUniform2uiEXT_pointer != 0L & this.EXT_gpu_shader4_glUniform3uiEXT_pointer != 0L & this.EXT_gpu_shader4_glUniform4uiEXT_pointer != 0L & this.EXT_gpu_shader4_glUniform1uivEXT_pointer != 0L & this.EXT_gpu_shader4_glUniform2uivEXT_pointer != 0L & this.EXT_gpu_shader4_glUniform3uivEXT_pointer != 0L & this.EXT_gpu_shader4_glUniform4uivEXT_pointer != 0L & this.EXT_gpu_shader4_glGetUniformuivEXT_pointer != 0L & this.EXT_gpu_shader4_glBindFragDataLocationEXT_pointer != 0L & this.EXT_gpu_shader4_glGetFragDataLocationEXT_pointer != 0L;
    }

    private boolean EXT_multi_draw_arrays_initNativeFunctionAddresses() {
        this.EXT_multi_draw_arrays_glMultiDrawArraysEXT_pointer = GLContext.getFunctionAddress("glMultiDrawArraysEXT");
        return this.EXT_multi_draw_arrays_glMultiDrawArraysEXT_pointer != 0L;
    }

    private boolean EXT_paletted_texture_initNativeFunctionAddresses() {
        this.EXT_paletted_texture_glColorTableEXT_pointer = GLContext.getFunctionAddress("glColorTableEXT");
        boolean bl2 = this.EXT_paletted_texture_glColorTableEXT_pointer != 0L;
        this.EXT_paletted_texture_glColorSubTableEXT_pointer = GLContext.getFunctionAddress("glColorSubTableEXT");
        this.EXT_paletted_texture_glGetColorTableEXT_pointer = GLContext.getFunctionAddress("glGetColorTableEXT");
        this.EXT_paletted_texture_glGetColorTableParameterivEXT_pointer = GLContext.getFunctionAddress("glGetColorTableParameterivEXT");
        this.EXT_paletted_texture_glGetColorTableParameterfvEXT_pointer = GLContext.getFunctionAddress("glGetColorTableParameterfvEXT");
        return bl2 & this.EXT_paletted_texture_glColorSubTableEXT_pointer != 0L & this.EXT_paletted_texture_glGetColorTableEXT_pointer != 0L & this.EXT_paletted_texture_glGetColorTableParameterivEXT_pointer != 0L & this.EXT_paletted_texture_glGetColorTableParameterfvEXT_pointer != 0L;
    }

    private boolean EXT_point_parameters_initNativeFunctionAddresses() {
        this.EXT_point_parameters_glPointParameterfEXT_pointer = GLContext.getFunctionAddress("glPointParameterfEXT");
        boolean bl2 = this.EXT_point_parameters_glPointParameterfEXT_pointer != 0L;
        this.EXT_point_parameters_glPointParameterfvEXT_pointer = GLContext.getFunctionAddress("glPointParameterfvEXT");
        return bl2 & this.EXT_point_parameters_glPointParameterfvEXT_pointer != 0L;
    }

    private boolean EXT_provoking_vertex_initNativeFunctionAddresses() {
        this.EXT_provoking_vertex_glProvokingVertexEXT_pointer = GLContext.getFunctionAddress("glProvokingVertexEXT");
        return this.EXT_provoking_vertex_glProvokingVertexEXT_pointer != 0L;
    }

    private boolean EXT_secondary_color_initNativeFunctionAddresses() {
        this.EXT_secondary_color_glSecondaryColor3bEXT_pointer = GLContext.getFunctionAddress("glSecondaryColor3bEXT");
        boolean bl2 = this.EXT_secondary_color_glSecondaryColor3bEXT_pointer != 0L;
        this.EXT_secondary_color_glSecondaryColor3fEXT_pointer = GLContext.getFunctionAddress("glSecondaryColor3fEXT");
        this.EXT_secondary_color_glSecondaryColor3dEXT_pointer = GLContext.getFunctionAddress("glSecondaryColor3dEXT");
        this.EXT_secondary_color_glSecondaryColor3ubEXT_pointer = GLContext.getFunctionAddress("glSecondaryColor3ubEXT");
        this.EXT_secondary_color_glSecondaryColorPointerEXT_pointer = GLContext.getFunctionAddress("glSecondaryColorPointerEXT");
        return bl2 & this.EXT_secondary_color_glSecondaryColor3fEXT_pointer != 0L & this.EXT_secondary_color_glSecondaryColor3dEXT_pointer != 0L & this.EXT_secondary_color_glSecondaryColor3ubEXT_pointer != 0L & this.EXT_secondary_color_glSecondaryColorPointerEXT_pointer != 0L;
    }

    private boolean EXT_separate_shader_objects_initNativeFunctionAddresses() {
        this.EXT_separate_shader_objects_glUseShaderProgramEXT_pointer = GLContext.getFunctionAddress("glUseShaderProgramEXT");
        boolean bl2 = this.EXT_separate_shader_objects_glUseShaderProgramEXT_pointer != 0L;
        this.EXT_separate_shader_objects_glActiveProgramEXT_pointer = GLContext.getFunctionAddress("glActiveProgramEXT");
        this.EXT_separate_shader_objects_glCreateShaderProgramEXT_pointer = GLContext.getFunctionAddress("glCreateShaderProgramEXT");
        return bl2 & this.EXT_separate_shader_objects_glActiveProgramEXT_pointer != 0L & this.EXT_separate_shader_objects_glCreateShaderProgramEXT_pointer != 0L;
    }

    private boolean EXT_shader_image_load_store_initNativeFunctionAddresses() {
        this.EXT_shader_image_load_store_glBindImageTextureEXT_pointer = GLContext.getFunctionAddress("glBindImageTextureEXT");
        boolean bl2 = this.EXT_shader_image_load_store_glBindImageTextureEXT_pointer != 0L;
        this.EXT_shader_image_load_store_glMemoryBarrierEXT_pointer = GLContext.getFunctionAddress("glMemoryBarrierEXT");
        return bl2 & this.EXT_shader_image_load_store_glMemoryBarrierEXT_pointer != 0L;
    }

    private boolean EXT_stencil_clear_tag_initNativeFunctionAddresses() {
        this.EXT_stencil_clear_tag_glStencilClearTagEXT_pointer = GLContext.getFunctionAddress("glStencilClearTagEXT");
        return this.EXT_stencil_clear_tag_glStencilClearTagEXT_pointer != 0L;
    }

    private boolean EXT_stencil_two_side_initNativeFunctionAddresses() {
        this.EXT_stencil_two_side_glActiveStencilFaceEXT_pointer = GLContext.getFunctionAddress("glActiveStencilFaceEXT");
        return this.EXT_stencil_two_side_glActiveStencilFaceEXT_pointer != 0L;
    }

    private boolean EXT_texture_array_initNativeFunctionAddresses() {
        this.EXT_texture_array_glFramebufferTextureLayerEXT_pointer = GLContext.getFunctionAddress("glFramebufferTextureLayerEXT");
        return this.EXT_texture_array_glFramebufferTextureLayerEXT_pointer != 0L;
    }

    private boolean EXT_texture_buffer_object_initNativeFunctionAddresses() {
        this.EXT_texture_buffer_object_glTexBufferEXT_pointer = GLContext.getFunctionAddress("glTexBufferEXT");
        return this.EXT_texture_buffer_object_glTexBufferEXT_pointer != 0L;
    }

    private boolean EXT_texture_integer_initNativeFunctionAddresses() {
        this.EXT_texture_integer_glClearColorIiEXT_pointer = GLContext.getFunctionAddress("glClearColorIiEXT");
        boolean bl2 = this.EXT_texture_integer_glClearColorIiEXT_pointer != 0L;
        this.EXT_texture_integer_glClearColorIuiEXT_pointer = GLContext.getFunctionAddress("glClearColorIuiEXT");
        this.EXT_texture_integer_glTexParameterIivEXT_pointer = GLContext.getFunctionAddress("glTexParameterIivEXT");
        this.EXT_texture_integer_glTexParameterIuivEXT_pointer = GLContext.getFunctionAddress("glTexParameterIuivEXT");
        this.EXT_texture_integer_glGetTexParameterIivEXT_pointer = GLContext.getFunctionAddress("glGetTexParameterIivEXT");
        this.EXT_texture_integer_glGetTexParameterIuivEXT_pointer = GLContext.getFunctionAddress("glGetTexParameterIuivEXT");
        return bl2 & this.EXT_texture_integer_glClearColorIuiEXT_pointer != 0L & this.EXT_texture_integer_glTexParameterIivEXT_pointer != 0L & this.EXT_texture_integer_glTexParameterIuivEXT_pointer != 0L & this.EXT_texture_integer_glGetTexParameterIivEXT_pointer != 0L & this.EXT_texture_integer_glGetTexParameterIuivEXT_pointer != 0L;
    }

    private boolean EXT_timer_query_initNativeFunctionAddresses() {
        this.EXT_timer_query_glGetQueryObjecti64vEXT_pointer = GLContext.getFunctionAddress("glGetQueryObjecti64vEXT");
        boolean bl2 = this.EXT_timer_query_glGetQueryObjecti64vEXT_pointer != 0L;
        this.EXT_timer_query_glGetQueryObjectui64vEXT_pointer = GLContext.getFunctionAddress("glGetQueryObjectui64vEXT");
        return bl2 & this.EXT_timer_query_glGetQueryObjectui64vEXT_pointer != 0L;
    }

    private boolean EXT_transform_feedback_initNativeFunctionAddresses() {
        this.EXT_transform_feedback_glBindBufferRangeEXT_pointer = GLContext.getFunctionAddress("glBindBufferRangeEXT");
        boolean bl2 = this.EXT_transform_feedback_glBindBufferRangeEXT_pointer != 0L;
        this.EXT_transform_feedback_glBindBufferOffsetEXT_pointer = GLContext.getFunctionAddress("glBindBufferOffsetEXT");
        this.EXT_transform_feedback_glBindBufferBaseEXT_pointer = GLContext.getFunctionAddress("glBindBufferBaseEXT");
        this.EXT_transform_feedback_glBeginTransformFeedbackEXT_pointer = GLContext.getFunctionAddress("glBeginTransformFeedbackEXT");
        this.EXT_transform_feedback_glEndTransformFeedbackEXT_pointer = GLContext.getFunctionAddress("glEndTransformFeedbackEXT");
        this.EXT_transform_feedback_glTransformFeedbackVaryingsEXT_pointer = GLContext.getFunctionAddress("glTransformFeedbackVaryingsEXT");
        this.EXT_transform_feedback_glGetTransformFeedbackVaryingEXT_pointer = GLContext.getFunctionAddress("glGetTransformFeedbackVaryingEXT");
        return bl2 & this.EXT_transform_feedback_glBindBufferOffsetEXT_pointer != 0L & this.EXT_transform_feedback_glBindBufferBaseEXT_pointer != 0L & this.EXT_transform_feedback_glBeginTransformFeedbackEXT_pointer != 0L & this.EXT_transform_feedback_glEndTransformFeedbackEXT_pointer != 0L & this.EXT_transform_feedback_glTransformFeedbackVaryingsEXT_pointer != 0L & this.EXT_transform_feedback_glGetTransformFeedbackVaryingEXT_pointer != 0L;
    }

    private boolean EXT_vertex_attrib_64bit_initNativeFunctionAddresses(Set supported_extensions) {
        this.EXT_vertex_attrib_64bit_glVertexAttribL1dEXT_pointer = GLContext.getFunctionAddress("glVertexAttribL1dEXT");
        boolean bl2 = this.EXT_vertex_attrib_64bit_glVertexAttribL1dEXT_pointer != 0L;
        this.EXT_vertex_attrib_64bit_glVertexAttribL2dEXT_pointer = GLContext.getFunctionAddress("glVertexAttribL2dEXT");
        this.EXT_vertex_attrib_64bit_glVertexAttribL3dEXT_pointer = GLContext.getFunctionAddress("glVertexAttribL3dEXT");
        this.EXT_vertex_attrib_64bit_glVertexAttribL4dEXT_pointer = GLContext.getFunctionAddress("glVertexAttribL4dEXT");
        this.EXT_vertex_attrib_64bit_glVertexAttribL1dvEXT_pointer = GLContext.getFunctionAddress("glVertexAttribL1dvEXT");
        this.EXT_vertex_attrib_64bit_glVertexAttribL2dvEXT_pointer = GLContext.getFunctionAddress("glVertexAttribL2dvEXT");
        this.EXT_vertex_attrib_64bit_glVertexAttribL3dvEXT_pointer = GLContext.getFunctionAddress("glVertexAttribL3dvEXT");
        this.EXT_vertex_attrib_64bit_glVertexAttribL4dvEXT_pointer = GLContext.getFunctionAddress("glVertexAttribL4dvEXT");
        this.EXT_vertex_attrib_64bit_glVertexAttribLPointerEXT_pointer = GLContext.getFunctionAddress("glVertexAttribLPointerEXT");
        this.EXT_vertex_attrib_64bit_glGetVertexAttribLdvEXT_pointer = GLContext.getFunctionAddress("glGetVertexAttribLdvEXT");
        return bl2 & this.EXT_vertex_attrib_64bit_glVertexAttribL2dEXT_pointer != 0L & this.EXT_vertex_attrib_64bit_glVertexAttribL3dEXT_pointer != 0L & this.EXT_vertex_attrib_64bit_glVertexAttribL4dEXT_pointer != 0L & this.EXT_vertex_attrib_64bit_glVertexAttribL1dvEXT_pointer != 0L & this.EXT_vertex_attrib_64bit_glVertexAttribL2dvEXT_pointer != 0L & this.EXT_vertex_attrib_64bit_glVertexAttribL3dvEXT_pointer != 0L & this.EXT_vertex_attrib_64bit_glVertexAttribL4dvEXT_pointer != 0L & this.EXT_vertex_attrib_64bit_glVertexAttribLPointerEXT_pointer != 0L & this.EXT_vertex_attrib_64bit_glGetVertexAttribLdvEXT_pointer != 0L & (!supported_extensions.contains("EXT_direct_state_access") || (this.EXT_vertex_attrib_64bit_glVertexArrayVertexAttribLOffsetEXT_pointer = GLContext.getFunctionAddress("glVertexArrayVertexAttribLOffsetEXT")) != 0L);
    }

    private boolean EXT_vertex_shader_initNativeFunctionAddresses() {
        this.EXT_vertex_shader_glBeginVertexShaderEXT_pointer = GLContext.getFunctionAddress("glBeginVertexShaderEXT");
        boolean bl2 = this.EXT_vertex_shader_glBeginVertexShaderEXT_pointer != 0L;
        this.EXT_vertex_shader_glEndVertexShaderEXT_pointer = GLContext.getFunctionAddress("glEndVertexShaderEXT");
        this.EXT_vertex_shader_glBindVertexShaderEXT_pointer = GLContext.getFunctionAddress("glBindVertexShaderEXT");
        this.EXT_vertex_shader_glGenVertexShadersEXT_pointer = GLContext.getFunctionAddress("glGenVertexShadersEXT");
        this.EXT_vertex_shader_glDeleteVertexShaderEXT_pointer = GLContext.getFunctionAddress("glDeleteVertexShaderEXT");
        this.EXT_vertex_shader_glShaderOp1EXT_pointer = GLContext.getFunctionAddress("glShaderOp1EXT");
        this.EXT_vertex_shader_glShaderOp2EXT_pointer = GLContext.getFunctionAddress("glShaderOp2EXT");
        this.EXT_vertex_shader_glShaderOp3EXT_pointer = GLContext.getFunctionAddress("glShaderOp3EXT");
        this.EXT_vertex_shader_glSwizzleEXT_pointer = GLContext.getFunctionAddress("glSwizzleEXT");
        this.EXT_vertex_shader_glWriteMaskEXT_pointer = GLContext.getFunctionAddress("glWriteMaskEXT");
        this.EXT_vertex_shader_glInsertComponentEXT_pointer = GLContext.getFunctionAddress("glInsertComponentEXT");
        this.EXT_vertex_shader_glExtractComponentEXT_pointer = GLContext.getFunctionAddress("glExtractComponentEXT");
        this.EXT_vertex_shader_glGenSymbolsEXT_pointer = GLContext.getFunctionAddress("glGenSymbolsEXT");
        this.EXT_vertex_shader_glSetInvariantEXT_pointer = GLContext.getFunctionAddress("glSetInvariantEXT");
        this.EXT_vertex_shader_glSetLocalConstantEXT_pointer = GLContext.getFunctionAddress("glSetLocalConstantEXT");
        this.EXT_vertex_shader_glVariantbvEXT_pointer = GLContext.getFunctionAddress("glVariantbvEXT");
        this.EXT_vertex_shader_glVariantsvEXT_pointer = GLContext.getFunctionAddress("glVariantsvEXT");
        this.EXT_vertex_shader_glVariantivEXT_pointer = GLContext.getFunctionAddress("glVariantivEXT");
        this.EXT_vertex_shader_glVariantfvEXT_pointer = GLContext.getFunctionAddress("glVariantfvEXT");
        this.EXT_vertex_shader_glVariantdvEXT_pointer = GLContext.getFunctionAddress("glVariantdvEXT");
        this.EXT_vertex_shader_glVariantubvEXT_pointer = GLContext.getFunctionAddress("glVariantubvEXT");
        this.EXT_vertex_shader_glVariantusvEXT_pointer = GLContext.getFunctionAddress("glVariantusvEXT");
        this.EXT_vertex_shader_glVariantuivEXT_pointer = GLContext.getFunctionAddress("glVariantuivEXT");
        this.EXT_vertex_shader_glVariantPointerEXT_pointer = GLContext.getFunctionAddress("glVariantPointerEXT");
        this.EXT_vertex_shader_glEnableVariantClientStateEXT_pointer = GLContext.getFunctionAddress("glEnableVariantClientStateEXT");
        this.EXT_vertex_shader_glDisableVariantClientStateEXT_pointer = GLContext.getFunctionAddress("glDisableVariantClientStateEXT");
        this.EXT_vertex_shader_glBindLightParameterEXT_pointer = GLContext.getFunctionAddress("glBindLightParameterEXT");
        this.EXT_vertex_shader_glBindMaterialParameterEXT_pointer = GLContext.getFunctionAddress("glBindMaterialParameterEXT");
        this.EXT_vertex_shader_glBindTexGenParameterEXT_pointer = GLContext.getFunctionAddress("glBindTexGenParameterEXT");
        this.EXT_vertex_shader_glBindTextureUnitParameterEXT_pointer = GLContext.getFunctionAddress("glBindTextureUnitParameterEXT");
        this.EXT_vertex_shader_glBindParameterEXT_pointer = GLContext.getFunctionAddress("glBindParameterEXT");
        this.EXT_vertex_shader_glIsVariantEnabledEXT_pointer = GLContext.getFunctionAddress("glIsVariantEnabledEXT");
        this.EXT_vertex_shader_glGetVariantBooleanvEXT_pointer = GLContext.getFunctionAddress("glGetVariantBooleanvEXT");
        this.EXT_vertex_shader_glGetVariantIntegervEXT_pointer = GLContext.getFunctionAddress("glGetVariantIntegervEXT");
        this.EXT_vertex_shader_glGetVariantFloatvEXT_pointer = GLContext.getFunctionAddress("glGetVariantFloatvEXT");
        this.EXT_vertex_shader_glGetVariantPointervEXT_pointer = GLContext.getFunctionAddress("glGetVariantPointervEXT");
        this.EXT_vertex_shader_glGetInvariantBooleanvEXT_pointer = GLContext.getFunctionAddress("glGetInvariantBooleanvEXT");
        this.EXT_vertex_shader_glGetInvariantIntegervEXT_pointer = GLContext.getFunctionAddress("glGetInvariantIntegervEXT");
        this.EXT_vertex_shader_glGetInvariantFloatvEXT_pointer = GLContext.getFunctionAddress("glGetInvariantFloatvEXT");
        this.EXT_vertex_shader_glGetLocalConstantBooleanvEXT_pointer = GLContext.getFunctionAddress("glGetLocalConstantBooleanvEXT");
        this.EXT_vertex_shader_glGetLocalConstantIntegervEXT_pointer = GLContext.getFunctionAddress("glGetLocalConstantIntegervEXT");
        this.EXT_vertex_shader_glGetLocalConstantFloatvEXT_pointer = GLContext.getFunctionAddress("glGetLocalConstantFloatvEXT");
        return bl2 & this.EXT_vertex_shader_glEndVertexShaderEXT_pointer != 0L & this.EXT_vertex_shader_glBindVertexShaderEXT_pointer != 0L & this.EXT_vertex_shader_glGenVertexShadersEXT_pointer != 0L & this.EXT_vertex_shader_glDeleteVertexShaderEXT_pointer != 0L & this.EXT_vertex_shader_glShaderOp1EXT_pointer != 0L & this.EXT_vertex_shader_glShaderOp2EXT_pointer != 0L & this.EXT_vertex_shader_glShaderOp3EXT_pointer != 0L & this.EXT_vertex_shader_glSwizzleEXT_pointer != 0L & this.EXT_vertex_shader_glWriteMaskEXT_pointer != 0L & this.EXT_vertex_shader_glInsertComponentEXT_pointer != 0L & this.EXT_vertex_shader_glExtractComponentEXT_pointer != 0L & this.EXT_vertex_shader_glGenSymbolsEXT_pointer != 0L & this.EXT_vertex_shader_glSetInvariantEXT_pointer != 0L & this.EXT_vertex_shader_glSetLocalConstantEXT_pointer != 0L & this.EXT_vertex_shader_glVariantbvEXT_pointer != 0L & this.EXT_vertex_shader_glVariantsvEXT_pointer != 0L & this.EXT_vertex_shader_glVariantivEXT_pointer != 0L & this.EXT_vertex_shader_glVariantfvEXT_pointer != 0L & this.EXT_vertex_shader_glVariantdvEXT_pointer != 0L & this.EXT_vertex_shader_glVariantubvEXT_pointer != 0L & this.EXT_vertex_shader_glVariantusvEXT_pointer != 0L & this.EXT_vertex_shader_glVariantuivEXT_pointer != 0L & this.EXT_vertex_shader_glVariantPointerEXT_pointer != 0L & this.EXT_vertex_shader_glEnableVariantClientStateEXT_pointer != 0L & this.EXT_vertex_shader_glDisableVariantClientStateEXT_pointer != 0L & this.EXT_vertex_shader_glBindLightParameterEXT_pointer != 0L & this.EXT_vertex_shader_glBindMaterialParameterEXT_pointer != 0L & this.EXT_vertex_shader_glBindTexGenParameterEXT_pointer != 0L & this.EXT_vertex_shader_glBindTextureUnitParameterEXT_pointer != 0L & this.EXT_vertex_shader_glBindParameterEXT_pointer != 0L & this.EXT_vertex_shader_glIsVariantEnabledEXT_pointer != 0L & this.EXT_vertex_shader_glGetVariantBooleanvEXT_pointer != 0L & this.EXT_vertex_shader_glGetVariantIntegervEXT_pointer != 0L & this.EXT_vertex_shader_glGetVariantFloatvEXT_pointer != 0L & this.EXT_vertex_shader_glGetVariantPointervEXT_pointer != 0L & this.EXT_vertex_shader_glGetInvariantBooleanvEXT_pointer != 0L & this.EXT_vertex_shader_glGetInvariantIntegervEXT_pointer != 0L & this.EXT_vertex_shader_glGetInvariantFloatvEXT_pointer != 0L & this.EXT_vertex_shader_glGetLocalConstantBooleanvEXT_pointer != 0L & this.EXT_vertex_shader_glGetLocalConstantIntegervEXT_pointer != 0L & this.EXT_vertex_shader_glGetLocalConstantFloatvEXT_pointer != 0L;
    }

    private boolean EXT_vertex_weighting_initNativeFunctionAddresses() {
        this.EXT_vertex_weighting_glVertexWeightfEXT_pointer = GLContext.getFunctionAddress("glVertexWeightfEXT");
        boolean bl2 = this.EXT_vertex_weighting_glVertexWeightfEXT_pointer != 0L;
        this.EXT_vertex_weighting_glVertexWeightPointerEXT_pointer = GLContext.getFunctionAddress("glVertexWeightPointerEXT");
        return bl2 & this.EXT_vertex_weighting_glVertexWeightPointerEXT_pointer != 0L;
    }

    private boolean GL11_initNativeFunctionAddresses(boolean forwardCompatible) {
        boolean bl2 = (forwardCompatible || (this.GL11_glAccum_pointer = GLContext.getFunctionAddress("glAccum")) != 0L) & (forwardCompatible || (this.GL11_glAlphaFunc_pointer = GLContext.getFunctionAddress("glAlphaFunc")) != 0L);
        this.GL11_glClearColor_pointer = GLContext.getFunctionAddress("glClearColor");
        boolean bl3 = bl2 & this.GL11_glClearColor_pointer != 0L & (forwardCompatible || (this.GL11_glClearAccum_pointer = GLContext.getFunctionAddress("glClearAccum")) != 0L);
        this.GL11_glClear_pointer = GLContext.getFunctionAddress("glClear");
        boolean bl4 = bl3 & this.GL11_glClear_pointer != 0L & (forwardCompatible || (this.GL11_glCallLists_pointer = GLContext.getFunctionAddress("glCallLists")) != 0L) & (forwardCompatible || (this.GL11_glCallList_pointer = GLContext.getFunctionAddress("glCallList")) != 0L);
        this.GL11_glBlendFunc_pointer = GLContext.getFunctionAddress("glBlendFunc");
        boolean bl5 = bl4 & this.GL11_glBlendFunc_pointer != 0L & (forwardCompatible || (this.GL11_glBitmap_pointer = GLContext.getFunctionAddress("glBitmap")) != 0L);
        this.GL11_glBindTexture_pointer = GLContext.getFunctionAddress("glBindTexture");
        boolean bl6 = bl5 & this.GL11_glBindTexture_pointer != 0L & (forwardCompatible || (this.GL11_glPrioritizeTextures_pointer = GLContext.getFunctionAddress("glPrioritizeTextures")) != 0L) & (forwardCompatible || (this.GL11_glAreTexturesResident_pointer = GLContext.getFunctionAddress("glAreTexturesResident")) != 0L) & (forwardCompatible || (this.GL11_glBegin_pointer = GLContext.getFunctionAddress("glBegin")) != 0L) & (forwardCompatible || (this.GL11_glEnd_pointer = GLContext.getFunctionAddress("glEnd")) != 0L);
        this.GL11_glArrayElement_pointer = GLContext.getFunctionAddress("glArrayElement");
        this.GL11_glClearDepth_pointer = GLContext.getFunctionAddress("glClearDepth");
        boolean bl7 = bl6 & this.GL11_glArrayElement_pointer != 0L & this.GL11_glClearDepth_pointer != 0L & (forwardCompatible || (this.GL11_glDeleteLists_pointer = GLContext.getFunctionAddress("glDeleteLists")) != 0L);
        this.GL11_glDeleteTextures_pointer = GLContext.getFunctionAddress("glDeleteTextures");
        this.GL11_glCullFace_pointer = GLContext.getFunctionAddress("glCullFace");
        this.GL11_glCopyTexSubImage2D_pointer = GLContext.getFunctionAddress("glCopyTexSubImage2D");
        this.GL11_glCopyTexSubImage1D_pointer = GLContext.getFunctionAddress("glCopyTexSubImage1D");
        this.GL11_glCopyTexImage2D_pointer = GLContext.getFunctionAddress("glCopyTexImage2D");
        this.GL11_glCopyTexImage1D_pointer = GLContext.getFunctionAddress("glCopyTexImage1D");
        this.GL11_glCopyPixels_pointer = GLContext.getFunctionAddress("glCopyPixels");
        boolean bl8 = bl7 & this.GL11_glDeleteTextures_pointer != 0L & this.GL11_glCullFace_pointer != 0L & this.GL11_glCopyTexSubImage2D_pointer != 0L & this.GL11_glCopyTexSubImage1D_pointer != 0L & this.GL11_glCopyTexImage2D_pointer != 0L & this.GL11_glCopyTexImage1D_pointer != 0L & this.GL11_glCopyPixels_pointer != 0L & (forwardCompatible || (this.GL11_glColorPointer_pointer = GLContext.getFunctionAddress("glColorPointer")) != 0L) & (forwardCompatible || (this.GL11_glColorMaterial_pointer = GLContext.getFunctionAddress("glColorMaterial")) != 0L);
        this.GL11_glColorMask_pointer = GLContext.getFunctionAddress("glColorMask");
        boolean bl9 = bl8 & this.GL11_glColorMask_pointer != 0L & (forwardCompatible || (this.GL11_glColor3b_pointer = GLContext.getFunctionAddress("glColor3b")) != 0L) & (forwardCompatible || (this.GL11_glColor3f_pointer = GLContext.getFunctionAddress("glColor3f")) != 0L) & (forwardCompatible || (this.GL11_glColor3d_pointer = GLContext.getFunctionAddress("glColor3d")) != 0L) & (forwardCompatible || (this.GL11_glColor3ub_pointer = GLContext.getFunctionAddress("glColor3ub")) != 0L) & (forwardCompatible || (this.GL11_glColor4b_pointer = GLContext.getFunctionAddress("glColor4b")) != 0L) & (forwardCompatible || (this.GL11_glColor4f_pointer = GLContext.getFunctionAddress("glColor4f")) != 0L) & (forwardCompatible || (this.GL11_glColor4d_pointer = GLContext.getFunctionAddress("glColor4d")) != 0L) & (forwardCompatible || (this.GL11_glColor4ub_pointer = GLContext.getFunctionAddress("glColor4ub")) != 0L);
        this.GL11_glClipPlane_pointer = GLContext.getFunctionAddress("glClipPlane");
        this.GL11_glClearStencil_pointer = GLContext.getFunctionAddress("glClearStencil");
        boolean bl10 = bl9 & this.GL11_glClipPlane_pointer != 0L & this.GL11_glClearStencil_pointer != 0L & (forwardCompatible || (this.GL11_glEvalPoint1_pointer = GLContext.getFunctionAddress("glEvalPoint1")) != 0L) & (forwardCompatible || (this.GL11_glEvalPoint2_pointer = GLContext.getFunctionAddress("glEvalPoint2")) != 0L) & (forwardCompatible || (this.GL11_glEvalMesh1_pointer = GLContext.getFunctionAddress("glEvalMesh1")) != 0L) & (forwardCompatible || (this.GL11_glEvalMesh2_pointer = GLContext.getFunctionAddress("glEvalMesh2")) != 0L) & (forwardCompatible || (this.GL11_glEvalCoord1f_pointer = GLContext.getFunctionAddress("glEvalCoord1f")) != 0L) & (forwardCompatible || (this.GL11_glEvalCoord1d_pointer = GLContext.getFunctionAddress("glEvalCoord1d")) != 0L) & (forwardCompatible || (this.GL11_glEvalCoord2f_pointer = GLContext.getFunctionAddress("glEvalCoord2f")) != 0L) & (forwardCompatible || (this.GL11_glEvalCoord2d_pointer = GLContext.getFunctionAddress("glEvalCoord2d")) != 0L) & (forwardCompatible || (this.GL11_glEnableClientState_pointer = GLContext.getFunctionAddress("glEnableClientState")) != 0L) & (forwardCompatible || (this.GL11_glDisableClientState_pointer = GLContext.getFunctionAddress("glDisableClientState")) != 0L);
        this.GL11_glEnable_pointer = GLContext.getFunctionAddress("glEnable");
        this.GL11_glDisable_pointer = GLContext.getFunctionAddress("glDisable");
        boolean bl11 = bl10 & this.GL11_glEnable_pointer != 0L & this.GL11_glDisable_pointer != 0L & (forwardCompatible || (this.GL11_glEdgeFlagPointer_pointer = GLContext.getFunctionAddress("glEdgeFlagPointer")) != 0L) & (forwardCompatible || (this.GL11_glEdgeFlag_pointer = GLContext.getFunctionAddress("glEdgeFlag")) != 0L) & (forwardCompatible || (this.GL11_glDrawPixels_pointer = GLContext.getFunctionAddress("glDrawPixels")) != 0L);
        this.GL11_glDrawElements_pointer = GLContext.getFunctionAddress("glDrawElements");
        this.GL11_glDrawBuffer_pointer = GLContext.getFunctionAddress("glDrawBuffer");
        this.GL11_glDrawArrays_pointer = GLContext.getFunctionAddress("glDrawArrays");
        this.GL11_glDepthRange_pointer = GLContext.getFunctionAddress("glDepthRange");
        this.GL11_glDepthMask_pointer = GLContext.getFunctionAddress("glDepthMask");
        this.GL11_glDepthFunc_pointer = GLContext.getFunctionAddress("glDepthFunc");
        boolean bl12 = bl11 & this.GL11_glDrawElements_pointer != 0L & this.GL11_glDrawBuffer_pointer != 0L & this.GL11_glDrawArrays_pointer != 0L & this.GL11_glDepthRange_pointer != 0L & this.GL11_glDepthMask_pointer != 0L & this.GL11_glDepthFunc_pointer != 0L & (forwardCompatible || (this.GL11_glFeedbackBuffer_pointer = GLContext.getFunctionAddress("glFeedbackBuffer")) != 0L) & (forwardCompatible || (this.GL11_glGetPixelMapfv_pointer = GLContext.getFunctionAddress("glGetPixelMapfv")) != 0L) & (forwardCompatible || (this.GL11_glGetPixelMapuiv_pointer = GLContext.getFunctionAddress("glGetPixelMapuiv")) != 0L) & (forwardCompatible || (this.GL11_glGetPixelMapusv_pointer = GLContext.getFunctionAddress("glGetPixelMapusv")) != 0L) & (forwardCompatible || (this.GL11_glGetMaterialfv_pointer = GLContext.getFunctionAddress("glGetMaterialfv")) != 0L) & (forwardCompatible || (this.GL11_glGetMaterialiv_pointer = GLContext.getFunctionAddress("glGetMaterialiv")) != 0L) & (forwardCompatible || (this.GL11_glGetMapfv_pointer = GLContext.getFunctionAddress("glGetMapfv")) != 0L) & (forwardCompatible || (this.GL11_glGetMapdv_pointer = GLContext.getFunctionAddress("glGetMapdv")) != 0L) & (forwardCompatible || (this.GL11_glGetMapiv_pointer = GLContext.getFunctionAddress("glGetMapiv")) != 0L) & (forwardCompatible || (this.GL11_glGetLightfv_pointer = GLContext.getFunctionAddress("glGetLightfv")) != 0L) & (forwardCompatible || (this.GL11_glGetLightiv_pointer = GLContext.getFunctionAddress("glGetLightiv")) != 0L);
        this.GL11_glGetError_pointer = GLContext.getFunctionAddress("glGetError");
        this.GL11_glGetClipPlane_pointer = GLContext.getFunctionAddress("glGetClipPlane");
        this.GL11_glGetBooleanv_pointer = GLContext.getFunctionAddress("glGetBooleanv");
        this.GL11_glGetDoublev_pointer = GLContext.getFunctionAddress("glGetDoublev");
        this.GL11_glGetFloatv_pointer = GLContext.getFunctionAddress("glGetFloatv");
        this.GL11_glGetIntegerv_pointer = GLContext.getFunctionAddress("glGetIntegerv");
        this.GL11_glGenTextures_pointer = GLContext.getFunctionAddress("glGenTextures");
        boolean bl13 = bl12 & this.GL11_glGetError_pointer != 0L & this.GL11_glGetClipPlane_pointer != 0L & this.GL11_glGetBooleanv_pointer != 0L & this.GL11_glGetDoublev_pointer != 0L & this.GL11_glGetFloatv_pointer != 0L & this.GL11_glGetIntegerv_pointer != 0L & this.GL11_glGenTextures_pointer != 0L & (forwardCompatible || (this.GL11_glGenLists_pointer = GLContext.getFunctionAddress("glGenLists")) != 0L) & (forwardCompatible || (this.GL11_glFrustum_pointer = GLContext.getFunctionAddress("glFrustum")) != 0L);
        this.GL11_glFrontFace_pointer = GLContext.getFunctionAddress("glFrontFace");
        boolean bl14 = bl13 & this.GL11_glFrontFace_pointer != 0L & (forwardCompatible || (this.GL11_glFogf_pointer = GLContext.getFunctionAddress("glFogf")) != 0L) & (forwardCompatible || (this.GL11_glFogi_pointer = GLContext.getFunctionAddress("glFogi")) != 0L) & (forwardCompatible || (this.GL11_glFogfv_pointer = GLContext.getFunctionAddress("glFogfv")) != 0L) & (forwardCompatible || (this.GL11_glFogiv_pointer = GLContext.getFunctionAddress("glFogiv")) != 0L);
        this.GL11_glFlush_pointer = GLContext.getFunctionAddress("glFlush");
        this.GL11_glFinish_pointer = GLContext.getFunctionAddress("glFinish");
        this.GL11_glGetPointerv_pointer = GLContext.getFunctionAddress("glGetPointerv");
        this.GL11_glIsEnabled_pointer = GLContext.getFunctionAddress("glIsEnabled");
        this.GL11_glInterleavedArrays_pointer = GLContext.getFunctionAddress("glInterleavedArrays");
        boolean bl15 = bl14 & this.GL11_glFlush_pointer != 0L & this.GL11_glFinish_pointer != 0L & this.GL11_glGetPointerv_pointer != 0L & this.GL11_glIsEnabled_pointer != 0L & this.GL11_glInterleavedArrays_pointer != 0L & (forwardCompatible || (this.GL11_glInitNames_pointer = GLContext.getFunctionAddress("glInitNames")) != 0L);
        this.GL11_glHint_pointer = GLContext.getFunctionAddress("glHint");
        this.GL11_glGetTexParameterfv_pointer = GLContext.getFunctionAddress("glGetTexParameterfv");
        this.GL11_glGetTexParameteriv_pointer = GLContext.getFunctionAddress("glGetTexParameteriv");
        this.GL11_glGetTexLevelParameterfv_pointer = GLContext.getFunctionAddress("glGetTexLevelParameterfv");
        this.GL11_glGetTexLevelParameteriv_pointer = GLContext.getFunctionAddress("glGetTexLevelParameteriv");
        this.GL11_glGetTexImage_pointer = GLContext.getFunctionAddress("glGetTexImage");
        boolean bl16 = bl15 & this.GL11_glHint_pointer != 0L & this.GL11_glGetTexParameterfv_pointer != 0L & this.GL11_glGetTexParameteriv_pointer != 0L & this.GL11_glGetTexLevelParameterfv_pointer != 0L & this.GL11_glGetTexLevelParameteriv_pointer != 0L & this.GL11_glGetTexImage_pointer != 0L & (forwardCompatible || (this.GL11_glGetTexGeniv_pointer = GLContext.getFunctionAddress("glGetTexGeniv")) != 0L) & (forwardCompatible || (this.GL11_glGetTexGenfv_pointer = GLContext.getFunctionAddress("glGetTexGenfv")) != 0L) & (forwardCompatible || (this.GL11_glGetTexGendv_pointer = GLContext.getFunctionAddress("glGetTexGendv")) != 0L);
        this.GL11_glGetTexEnviv_pointer = GLContext.getFunctionAddress("glGetTexEnviv");
        this.GL11_glGetTexEnvfv_pointer = GLContext.getFunctionAddress("glGetTexEnvfv");
        this.GL11_glGetString_pointer = GLContext.getFunctionAddress("glGetString");
        boolean bl17 = bl16 & this.GL11_glGetTexEnviv_pointer != 0L & this.GL11_glGetTexEnvfv_pointer != 0L & this.GL11_glGetString_pointer != 0L & (forwardCompatible || (this.GL11_glGetPolygonStipple_pointer = GLContext.getFunctionAddress("glGetPolygonStipple")) != 0L) & (forwardCompatible || (this.GL11_glIsList_pointer = GLContext.getFunctionAddress("glIsList")) != 0L) & (forwardCompatible || (this.GL11_glMaterialf_pointer = GLContext.getFunctionAddress("glMaterialf")) != 0L) & (forwardCompatible || (this.GL11_glMateriali_pointer = GLContext.getFunctionAddress("glMateriali")) != 0L) & (forwardCompatible || (this.GL11_glMaterialfv_pointer = GLContext.getFunctionAddress("glMaterialfv")) != 0L) & (forwardCompatible || (this.GL11_glMaterialiv_pointer = GLContext.getFunctionAddress("glMaterialiv")) != 0L) & (forwardCompatible || (this.GL11_glMapGrid1f_pointer = GLContext.getFunctionAddress("glMapGrid1f")) != 0L) & (forwardCompatible || (this.GL11_glMapGrid1d_pointer = GLContext.getFunctionAddress("glMapGrid1d")) != 0L) & (forwardCompatible || (this.GL11_glMapGrid2f_pointer = GLContext.getFunctionAddress("glMapGrid2f")) != 0L) & (forwardCompatible || (this.GL11_glMapGrid2d_pointer = GLContext.getFunctionAddress("glMapGrid2d")) != 0L) & (forwardCompatible || (this.GL11_glMap2f_pointer = GLContext.getFunctionAddress("glMap2f")) != 0L) & (forwardCompatible || (this.GL11_glMap2d_pointer = GLContext.getFunctionAddress("glMap2d")) != 0L) & (forwardCompatible || (this.GL11_glMap1f_pointer = GLContext.getFunctionAddress("glMap1f")) != 0L) & (forwardCompatible || (this.GL11_glMap1d_pointer = GLContext.getFunctionAddress("glMap1d")) != 0L);
        this.GL11_glLogicOp_pointer = GLContext.getFunctionAddress("glLogicOp");
        boolean bl18 = bl17 & this.GL11_glLogicOp_pointer != 0L & (forwardCompatible || (this.GL11_glLoadName_pointer = GLContext.getFunctionAddress("glLoadName")) != 0L) & (forwardCompatible || (this.GL11_glLoadMatrixf_pointer = GLContext.getFunctionAddress("glLoadMatrixf")) != 0L) & (forwardCompatible || (this.GL11_glLoadMatrixd_pointer = GLContext.getFunctionAddress("glLoadMatrixd")) != 0L) & (forwardCompatible || (this.GL11_glLoadIdentity_pointer = GLContext.getFunctionAddress("glLoadIdentity")) != 0L) & (forwardCompatible || (this.GL11_glListBase_pointer = GLContext.getFunctionAddress("glListBase")) != 0L);
        this.GL11_glLineWidth_pointer = GLContext.getFunctionAddress("glLineWidth");
        boolean bl19 = bl18 & this.GL11_glLineWidth_pointer != 0L & (forwardCompatible || (this.GL11_glLineStipple_pointer = GLContext.getFunctionAddress("glLineStipple")) != 0L) & (forwardCompatible || (this.GL11_glLightModelf_pointer = GLContext.getFunctionAddress("glLightModelf")) != 0L) & (forwardCompatible || (this.GL11_glLightModeli_pointer = GLContext.getFunctionAddress("glLightModeli")) != 0L) & (forwardCompatible || (this.GL11_glLightModelfv_pointer = GLContext.getFunctionAddress("glLightModelfv")) != 0L) & (forwardCompatible || (this.GL11_glLightModeliv_pointer = GLContext.getFunctionAddress("glLightModeliv")) != 0L) & (forwardCompatible || (this.GL11_glLightf_pointer = GLContext.getFunctionAddress("glLightf")) != 0L) & (forwardCompatible || (this.GL11_glLighti_pointer = GLContext.getFunctionAddress("glLighti")) != 0L) & (forwardCompatible || (this.GL11_glLightfv_pointer = GLContext.getFunctionAddress("glLightfv")) != 0L) & (forwardCompatible || (this.GL11_glLightiv_pointer = GLContext.getFunctionAddress("glLightiv")) != 0L);
        this.GL11_glIsTexture_pointer = GLContext.getFunctionAddress("glIsTexture");
        boolean bl20 = bl19 & this.GL11_glIsTexture_pointer != 0L & (forwardCompatible || (this.GL11_glMatrixMode_pointer = GLContext.getFunctionAddress("glMatrixMode")) != 0L) & (forwardCompatible || (this.GL11_glPolygonStipple_pointer = GLContext.getFunctionAddress("glPolygonStipple")) != 0L);
        this.GL11_glPolygonOffset_pointer = GLContext.getFunctionAddress("glPolygonOffset");
        this.GL11_glPolygonMode_pointer = GLContext.getFunctionAddress("glPolygonMode");
        this.GL11_glPointSize_pointer = GLContext.getFunctionAddress("glPointSize");
        boolean bl21 = bl20 & this.GL11_glPolygonOffset_pointer != 0L & this.GL11_glPolygonMode_pointer != 0L & this.GL11_glPointSize_pointer != 0L & (forwardCompatible || (this.GL11_glPixelZoom_pointer = GLContext.getFunctionAddress("glPixelZoom")) != 0L) & (forwardCompatible || (this.GL11_glPixelTransferf_pointer = GLContext.getFunctionAddress("glPixelTransferf")) != 0L) & (forwardCompatible || (this.GL11_glPixelTransferi_pointer = GLContext.getFunctionAddress("glPixelTransferi")) != 0L);
        this.GL11_glPixelStoref_pointer = GLContext.getFunctionAddress("glPixelStoref");
        this.GL11_glPixelStorei_pointer = GLContext.getFunctionAddress("glPixelStorei");
        boolean bl22 = bl21 & this.GL11_glPixelStoref_pointer != 0L & this.GL11_glPixelStorei_pointer != 0L & (forwardCompatible || (this.GL11_glPixelMapfv_pointer = GLContext.getFunctionAddress("glPixelMapfv")) != 0L) & (forwardCompatible || (this.GL11_glPixelMapuiv_pointer = GLContext.getFunctionAddress("glPixelMapuiv")) != 0L) & (forwardCompatible || (this.GL11_glPixelMapusv_pointer = GLContext.getFunctionAddress("glPixelMapusv")) != 0L) & (forwardCompatible || (this.GL11_glPassThrough_pointer = GLContext.getFunctionAddress("glPassThrough")) != 0L) & (forwardCompatible || (this.GL11_glOrtho_pointer = GLContext.getFunctionAddress("glOrtho")) != 0L) & (forwardCompatible || (this.GL11_glNormalPointer_pointer = GLContext.getFunctionAddress("glNormalPointer")) != 0L) & (forwardCompatible || (this.GL11_glNormal3b_pointer = GLContext.getFunctionAddress("glNormal3b")) != 0L) & (forwardCompatible || (this.GL11_glNormal3f_pointer = GLContext.getFunctionAddress("glNormal3f")) != 0L) & (forwardCompatible || (this.GL11_glNormal3d_pointer = GLContext.getFunctionAddress("glNormal3d")) != 0L) & (forwardCompatible || (this.GL11_glNormal3i_pointer = GLContext.getFunctionAddress("glNormal3i")) != 0L) & (forwardCompatible || (this.GL11_glNewList_pointer = GLContext.getFunctionAddress("glNewList")) != 0L) & (forwardCompatible || (this.GL11_glEndList_pointer = GLContext.getFunctionAddress("glEndList")) != 0L) & (forwardCompatible || (this.GL11_glMultMatrixf_pointer = GLContext.getFunctionAddress("glMultMatrixf")) != 0L) & (forwardCompatible || (this.GL11_glMultMatrixd_pointer = GLContext.getFunctionAddress("glMultMatrixd")) != 0L);
        this.GL11_glShadeModel_pointer = GLContext.getFunctionAddress("glShadeModel");
        boolean bl23 = bl22 & this.GL11_glShadeModel_pointer != 0L & (forwardCompatible || (this.GL11_glSelectBuffer_pointer = GLContext.getFunctionAddress("glSelectBuffer")) != 0L);
        this.GL11_glScissor_pointer = GLContext.getFunctionAddress("glScissor");
        boolean bl24 = bl23 & this.GL11_glScissor_pointer != 0L & (forwardCompatible || (this.GL11_glScalef_pointer = GLContext.getFunctionAddress("glScalef")) != 0L) & (forwardCompatible || (this.GL11_glScaled_pointer = GLContext.getFunctionAddress("glScaled")) != 0L) & (forwardCompatible || (this.GL11_glRotatef_pointer = GLContext.getFunctionAddress("glRotatef")) != 0L) & (forwardCompatible || (this.GL11_glRenderMode_pointer = GLContext.getFunctionAddress("glRenderMode")) != 0L) & (forwardCompatible || (this.GL11_glRectf_pointer = GLContext.getFunctionAddress("glRectf")) != 0L) & (forwardCompatible || (this.GL11_glRectd_pointer = GLContext.getFunctionAddress("glRectd")) != 0L) & (forwardCompatible || (this.GL11_glRecti_pointer = GLContext.getFunctionAddress("glRecti")) != 0L);
        this.GL11_glReadPixels_pointer = GLContext.getFunctionAddress("glReadPixels");
        this.GL11_glReadBuffer_pointer = GLContext.getFunctionAddress("glReadBuffer");
        boolean bl25 = bl24 & this.GL11_glReadPixels_pointer != 0L & this.GL11_glReadBuffer_pointer != 0L & (forwardCompatible || (this.GL11_glRasterPos2f_pointer = GLContext.getFunctionAddress("glRasterPos2f")) != 0L) & (forwardCompatible || (this.GL11_glRasterPos2d_pointer = GLContext.getFunctionAddress("glRasterPos2d")) != 0L) & (forwardCompatible || (this.GL11_glRasterPos2i_pointer = GLContext.getFunctionAddress("glRasterPos2i")) != 0L) & (forwardCompatible || (this.GL11_glRasterPos3f_pointer = GLContext.getFunctionAddress("glRasterPos3f")) != 0L) & (forwardCompatible || (this.GL11_glRasterPos3d_pointer = GLContext.getFunctionAddress("glRasterPos3d")) != 0L) & (forwardCompatible || (this.GL11_glRasterPos3i_pointer = GLContext.getFunctionAddress("glRasterPos3i")) != 0L) & (forwardCompatible || (this.GL11_glRasterPos4f_pointer = GLContext.getFunctionAddress("glRasterPos4f")) != 0L) & (forwardCompatible || (this.GL11_glRasterPos4d_pointer = GLContext.getFunctionAddress("glRasterPos4d")) != 0L) & (forwardCompatible || (this.GL11_glRasterPos4i_pointer = GLContext.getFunctionAddress("glRasterPos4i")) != 0L) & (forwardCompatible || (this.GL11_glPushName_pointer = GLContext.getFunctionAddress("glPushName")) != 0L) & (forwardCompatible || (this.GL11_glPopName_pointer = GLContext.getFunctionAddress("glPopName")) != 0L) & (forwardCompatible || (this.GL11_glPushMatrix_pointer = GLContext.getFunctionAddress("glPushMatrix")) != 0L) & (forwardCompatible || (this.GL11_glPopMatrix_pointer = GLContext.getFunctionAddress("glPopMatrix")) != 0L) & (forwardCompatible || (this.GL11_glPushClientAttrib_pointer = GLContext.getFunctionAddress("glPushClientAttrib")) != 0L) & (forwardCompatible || (this.GL11_glPopClientAttrib_pointer = GLContext.getFunctionAddress("glPopClientAttrib")) != 0L) & (forwardCompatible || (this.GL11_glPushAttrib_pointer = GLContext.getFunctionAddress("glPushAttrib")) != 0L) & (forwardCompatible || (this.GL11_glPopAttrib_pointer = GLContext.getFunctionAddress("glPopAttrib")) != 0L);
        this.GL11_glStencilFunc_pointer = GLContext.getFunctionAddress("glStencilFunc");
        boolean bl26 = bl25 & this.GL11_glStencilFunc_pointer != 0L & (forwardCompatible || (this.GL11_glVertexPointer_pointer = GLContext.getFunctionAddress("glVertexPointer")) != 0L) & (forwardCompatible || (this.GL11_glVertex2f_pointer = GLContext.getFunctionAddress("glVertex2f")) != 0L) & (forwardCompatible || (this.GL11_glVertex2d_pointer = GLContext.getFunctionAddress("glVertex2d")) != 0L) & (forwardCompatible || (this.GL11_glVertex2i_pointer = GLContext.getFunctionAddress("glVertex2i")) != 0L) & (forwardCompatible || (this.GL11_glVertex3f_pointer = GLContext.getFunctionAddress("glVertex3f")) != 0L) & (forwardCompatible || (this.GL11_glVertex3d_pointer = GLContext.getFunctionAddress("glVertex3d")) != 0L) & (forwardCompatible || (this.GL11_glVertex3i_pointer = GLContext.getFunctionAddress("glVertex3i")) != 0L) & (forwardCompatible || (this.GL11_glVertex4f_pointer = GLContext.getFunctionAddress("glVertex4f")) != 0L) & (forwardCompatible || (this.GL11_glVertex4d_pointer = GLContext.getFunctionAddress("glVertex4d")) != 0L) & (forwardCompatible || (this.GL11_glVertex4i_pointer = GLContext.getFunctionAddress("glVertex4i")) != 0L) & (forwardCompatible || (this.GL11_glTranslatef_pointer = GLContext.getFunctionAddress("glTranslatef")) != 0L) & (forwardCompatible || (this.GL11_glTranslated_pointer = GLContext.getFunctionAddress("glTranslated")) != 0L);
        this.GL11_glTexImage1D_pointer = GLContext.getFunctionAddress("glTexImage1D");
        this.GL11_glTexImage2D_pointer = GLContext.getFunctionAddress("glTexImage2D");
        this.GL11_glTexSubImage1D_pointer = GLContext.getFunctionAddress("glTexSubImage1D");
        this.GL11_glTexSubImage2D_pointer = GLContext.getFunctionAddress("glTexSubImage2D");
        this.GL11_glTexParameterf_pointer = GLContext.getFunctionAddress("glTexParameterf");
        this.GL11_glTexParameteri_pointer = GLContext.getFunctionAddress("glTexParameteri");
        this.GL11_glTexParameterfv_pointer = GLContext.getFunctionAddress("glTexParameterfv");
        this.GL11_glTexParameteriv_pointer = GLContext.getFunctionAddress("glTexParameteriv");
        boolean bl27 = bl26 & this.GL11_glTexImage1D_pointer != 0L & this.GL11_glTexImage2D_pointer != 0L & this.GL11_glTexSubImage1D_pointer != 0L & this.GL11_glTexSubImage2D_pointer != 0L & this.GL11_glTexParameterf_pointer != 0L & this.GL11_glTexParameteri_pointer != 0L & this.GL11_glTexParameterfv_pointer != 0L & this.GL11_glTexParameteriv_pointer != 0L & (forwardCompatible || (this.GL11_glTexGenf_pointer = GLContext.getFunctionAddress("glTexGenf")) != 0L) & (forwardCompatible || (this.GL11_glTexGend_pointer = GLContext.getFunctionAddress("glTexGend")) != 0L) & (forwardCompatible || (this.GL11_glTexGenfv_pointer = GLContext.getFunctionAddress("glTexGenfv")) != 0L) & (forwardCompatible || (this.GL11_glTexGendv_pointer = GLContext.getFunctionAddress("glTexGendv")) != 0L) & (forwardCompatible || (this.GL11_glTexGeni_pointer = GLContext.getFunctionAddress("glTexGeni")) != 0L) & (forwardCompatible || (this.GL11_glTexGeniv_pointer = GLContext.getFunctionAddress("glTexGeniv")) != 0L);
        this.GL11_glTexEnvf_pointer = GLContext.getFunctionAddress("glTexEnvf");
        this.GL11_glTexEnvi_pointer = GLContext.getFunctionAddress("glTexEnvi");
        this.GL11_glTexEnvfv_pointer = GLContext.getFunctionAddress("glTexEnvfv");
        this.GL11_glTexEnviv_pointer = GLContext.getFunctionAddress("glTexEnviv");
        boolean bl28 = bl27 & this.GL11_glTexEnvf_pointer != 0L & this.GL11_glTexEnvi_pointer != 0L & this.GL11_glTexEnvfv_pointer != 0L & this.GL11_glTexEnviv_pointer != 0L & (forwardCompatible || (this.GL11_glTexCoordPointer_pointer = GLContext.getFunctionAddress("glTexCoordPointer")) != 0L) & (forwardCompatible || (this.GL11_glTexCoord1f_pointer = GLContext.getFunctionAddress("glTexCoord1f")) != 0L) & (forwardCompatible || (this.GL11_glTexCoord1d_pointer = GLContext.getFunctionAddress("glTexCoord1d")) != 0L) & (forwardCompatible || (this.GL11_glTexCoord2f_pointer = GLContext.getFunctionAddress("glTexCoord2f")) != 0L) & (forwardCompatible || (this.GL11_glTexCoord2d_pointer = GLContext.getFunctionAddress("glTexCoord2d")) != 0L) & (forwardCompatible || (this.GL11_glTexCoord3f_pointer = GLContext.getFunctionAddress("glTexCoord3f")) != 0L) & (forwardCompatible || (this.GL11_glTexCoord3d_pointer = GLContext.getFunctionAddress("glTexCoord3d")) != 0L) & (forwardCompatible || (this.GL11_glTexCoord4f_pointer = GLContext.getFunctionAddress("glTexCoord4f")) != 0L) & (forwardCompatible || (this.GL11_glTexCoord4d_pointer = GLContext.getFunctionAddress("glTexCoord4d")) != 0L);
        this.GL11_glStencilOp_pointer = GLContext.getFunctionAddress("glStencilOp");
        this.GL11_glStencilMask_pointer = GLContext.getFunctionAddress("glStencilMask");
        this.GL11_glViewport_pointer = GLContext.getFunctionAddress("glViewport");
        return bl28 & this.GL11_glStencilOp_pointer != 0L & this.GL11_glStencilMask_pointer != 0L & this.GL11_glViewport_pointer != 0L;
    }

    private boolean GL12_initNativeFunctionAddresses() {
        this.GL12_glDrawRangeElements_pointer = GLContext.getFunctionAddress("glDrawRangeElements");
        boolean bl2 = this.GL12_glDrawRangeElements_pointer != 0L;
        this.GL12_glTexImage3D_pointer = GLContext.getFunctionAddress("glTexImage3D");
        this.GL12_glTexSubImage3D_pointer = GLContext.getFunctionAddress("glTexSubImage3D");
        this.GL12_glCopyTexSubImage3D_pointer = GLContext.getFunctionAddress("glCopyTexSubImage3D");
        return bl2 & this.GL12_glTexImage3D_pointer != 0L & this.GL12_glTexSubImage3D_pointer != 0L & this.GL12_glCopyTexSubImage3D_pointer != 0L;
    }

    private boolean GL13_initNativeFunctionAddresses(boolean forwardCompatible) {
        this.GL13_glActiveTexture_pointer = GLContext.getFunctionAddress("glActiveTexture");
        boolean bl2 = this.GL13_glActiveTexture_pointer != 0L & (forwardCompatible || (this.GL13_glClientActiveTexture_pointer = GLContext.getFunctionAddress("glClientActiveTexture")) != 0L);
        this.GL13_glCompressedTexImage1D_pointer = GLContext.getFunctionAddress("glCompressedTexImage1D");
        this.GL13_glCompressedTexImage2D_pointer = GLContext.getFunctionAddress("glCompressedTexImage2D");
        this.GL13_glCompressedTexImage3D_pointer = GLContext.getFunctionAddress("glCompressedTexImage3D");
        this.GL13_glCompressedTexSubImage1D_pointer = GLContext.getFunctionAddress("glCompressedTexSubImage1D");
        this.GL13_glCompressedTexSubImage2D_pointer = GLContext.getFunctionAddress("glCompressedTexSubImage2D");
        this.GL13_glCompressedTexSubImage3D_pointer = GLContext.getFunctionAddress("glCompressedTexSubImage3D");
        this.GL13_glGetCompressedTexImage_pointer = GLContext.getFunctionAddress("glGetCompressedTexImage");
        boolean bl3 = bl2 & this.GL13_glCompressedTexImage1D_pointer != 0L & this.GL13_glCompressedTexImage2D_pointer != 0L & this.GL13_glCompressedTexImage3D_pointer != 0L & this.GL13_glCompressedTexSubImage1D_pointer != 0L & this.GL13_glCompressedTexSubImage2D_pointer != 0L & this.GL13_glCompressedTexSubImage3D_pointer != 0L & this.GL13_glGetCompressedTexImage_pointer != 0L & (forwardCompatible || (this.GL13_glMultiTexCoord1f_pointer = GLContext.getFunctionAddress("glMultiTexCoord1f")) != 0L) & (forwardCompatible || (this.GL13_glMultiTexCoord1d_pointer = GLContext.getFunctionAddress("glMultiTexCoord1d")) != 0L) & (forwardCompatible || (this.GL13_glMultiTexCoord2f_pointer = GLContext.getFunctionAddress("glMultiTexCoord2f")) != 0L) & (forwardCompatible || (this.GL13_glMultiTexCoord2d_pointer = GLContext.getFunctionAddress("glMultiTexCoord2d")) != 0L) & (forwardCompatible || (this.GL13_glMultiTexCoord3f_pointer = GLContext.getFunctionAddress("glMultiTexCoord3f")) != 0L) & (forwardCompatible || (this.GL13_glMultiTexCoord3d_pointer = GLContext.getFunctionAddress("glMultiTexCoord3d")) != 0L) & (forwardCompatible || (this.GL13_glMultiTexCoord4f_pointer = GLContext.getFunctionAddress("glMultiTexCoord4f")) != 0L) & (forwardCompatible || (this.GL13_glMultiTexCoord4d_pointer = GLContext.getFunctionAddress("glMultiTexCoord4d")) != 0L) & (forwardCompatible || (this.GL13_glLoadTransposeMatrixf_pointer = GLContext.getFunctionAddress("glLoadTransposeMatrixf")) != 0L) & (forwardCompatible || (this.GL13_glLoadTransposeMatrixd_pointer = GLContext.getFunctionAddress("glLoadTransposeMatrixd")) != 0L) & (forwardCompatible || (this.GL13_glMultTransposeMatrixf_pointer = GLContext.getFunctionAddress("glMultTransposeMatrixf")) != 0L) & (forwardCompatible || (this.GL13_glMultTransposeMatrixd_pointer = GLContext.getFunctionAddress("glMultTransposeMatrixd")) != 0L);
        this.GL13_glSampleCoverage_pointer = GLContext.getFunctionAddress("glSampleCoverage");
        return bl3 & this.GL13_glSampleCoverage_pointer != 0L;
    }

    private boolean GL14_initNativeFunctionAddresses(boolean forwardCompatible) {
        this.GL14_glBlendEquation_pointer = GLContext.getFunctionAddress("glBlendEquation");
        boolean bl2 = this.GL14_glBlendEquation_pointer != 0L;
        this.GL14_glBlendColor_pointer = GLContext.getFunctionAddress("glBlendColor");
        boolean bl3 = bl2 & this.GL14_glBlendColor_pointer != 0L & (forwardCompatible || (this.GL14_glFogCoordf_pointer = GLContext.getFunctionAddress("glFogCoordf")) != 0L) & (forwardCompatible || (this.GL14_glFogCoordd_pointer = GLContext.getFunctionAddress("glFogCoordd")) != 0L) & (forwardCompatible || (this.GL14_glFogCoordPointer_pointer = GLContext.getFunctionAddress("glFogCoordPointer")) != 0L);
        this.GL14_glMultiDrawArrays_pointer = GLContext.getFunctionAddress("glMultiDrawArrays");
        this.GL14_glPointParameteri_pointer = GLContext.getFunctionAddress("glPointParameteri");
        this.GL14_glPointParameterf_pointer = GLContext.getFunctionAddress("glPointParameterf");
        this.GL14_glPointParameteriv_pointer = GLContext.getFunctionAddress("glPointParameteriv");
        this.GL14_glPointParameterfv_pointer = GLContext.getFunctionAddress("glPointParameterfv");
        boolean bl4 = bl3 & this.GL14_glMultiDrawArrays_pointer != 0L & this.GL14_glPointParameteri_pointer != 0L & this.GL14_glPointParameterf_pointer != 0L & this.GL14_glPointParameteriv_pointer != 0L & this.GL14_glPointParameterfv_pointer != 0L & (forwardCompatible || (this.GL14_glSecondaryColor3b_pointer = GLContext.getFunctionAddress("glSecondaryColor3b")) != 0L) & (forwardCompatible || (this.GL14_glSecondaryColor3f_pointer = GLContext.getFunctionAddress("glSecondaryColor3f")) != 0L) & (forwardCompatible || (this.GL14_glSecondaryColor3d_pointer = GLContext.getFunctionAddress("glSecondaryColor3d")) != 0L) & (forwardCompatible || (this.GL14_glSecondaryColor3ub_pointer = GLContext.getFunctionAddress("glSecondaryColor3ub")) != 0L) & (forwardCompatible || (this.GL14_glSecondaryColorPointer_pointer = GLContext.getFunctionAddress("glSecondaryColorPointer")) != 0L);
        this.GL14_glBlendFuncSeparate_pointer = GLContext.getFunctionAddress("glBlendFuncSeparate");
        return bl4 & this.GL14_glBlendFuncSeparate_pointer != 0L & (forwardCompatible || (this.GL14_glWindowPos2f_pointer = GLContext.getFunctionAddress("glWindowPos2f")) != 0L) & (forwardCompatible || (this.GL14_glWindowPos2d_pointer = GLContext.getFunctionAddress("glWindowPos2d")) != 0L) & (forwardCompatible || (this.GL14_glWindowPos2i_pointer = GLContext.getFunctionAddress("glWindowPos2i")) != 0L) & (forwardCompatible || (this.GL14_glWindowPos3f_pointer = GLContext.getFunctionAddress("glWindowPos3f")) != 0L) & (forwardCompatible || (this.GL14_glWindowPos3d_pointer = GLContext.getFunctionAddress("glWindowPos3d")) != 0L) & (forwardCompatible || (this.GL14_glWindowPos3i_pointer = GLContext.getFunctionAddress("glWindowPos3i")) != 0L);
    }

    private boolean GL15_initNativeFunctionAddresses() {
        this.GL15_glBindBuffer_pointer = GLContext.getFunctionAddress("glBindBuffer");
        boolean bl2 = this.GL15_glBindBuffer_pointer != 0L;
        this.GL15_glDeleteBuffers_pointer = GLContext.getFunctionAddress("glDeleteBuffers");
        this.GL15_glGenBuffers_pointer = GLContext.getFunctionAddress("glGenBuffers");
        this.GL15_glIsBuffer_pointer = GLContext.getFunctionAddress("glIsBuffer");
        this.GL15_glBufferData_pointer = GLContext.getFunctionAddress("glBufferData");
        this.GL15_glBufferSubData_pointer = GLContext.getFunctionAddress("glBufferSubData");
        this.GL15_glGetBufferSubData_pointer = GLContext.getFunctionAddress("glGetBufferSubData");
        this.GL15_glMapBuffer_pointer = GLContext.getFunctionAddress("glMapBuffer");
        this.GL15_glUnmapBuffer_pointer = GLContext.getFunctionAddress("glUnmapBuffer");
        this.GL15_glGetBufferParameteriv_pointer = GLContext.getFunctionAddress("glGetBufferParameteriv");
        this.GL15_glGetBufferPointerv_pointer = GLContext.getFunctionAddress("glGetBufferPointerv");
        this.GL15_glGenQueries_pointer = GLContext.getFunctionAddress("glGenQueries");
        this.GL15_glDeleteQueries_pointer = GLContext.getFunctionAddress("glDeleteQueries");
        this.GL15_glIsQuery_pointer = GLContext.getFunctionAddress("glIsQuery");
        this.GL15_glBeginQuery_pointer = GLContext.getFunctionAddress("glBeginQuery");
        this.GL15_glEndQuery_pointer = GLContext.getFunctionAddress("glEndQuery");
        this.GL15_glGetQueryiv_pointer = GLContext.getFunctionAddress("glGetQueryiv");
        this.GL15_glGetQueryObjectiv_pointer = GLContext.getFunctionAddress("glGetQueryObjectiv");
        this.GL15_glGetQueryObjectuiv_pointer = GLContext.getFunctionAddress("glGetQueryObjectuiv");
        return bl2 & this.GL15_glDeleteBuffers_pointer != 0L & this.GL15_glGenBuffers_pointer != 0L & this.GL15_glIsBuffer_pointer != 0L & this.GL15_glBufferData_pointer != 0L & this.GL15_glBufferSubData_pointer != 0L & this.GL15_glGetBufferSubData_pointer != 0L & this.GL15_glMapBuffer_pointer != 0L & this.GL15_glUnmapBuffer_pointer != 0L & this.GL15_glGetBufferParameteriv_pointer != 0L & this.GL15_glGetBufferPointerv_pointer != 0L & this.GL15_glGenQueries_pointer != 0L & this.GL15_glDeleteQueries_pointer != 0L & this.GL15_glIsQuery_pointer != 0L & this.GL15_glBeginQuery_pointer != 0L & this.GL15_glEndQuery_pointer != 0L & this.GL15_glGetQueryiv_pointer != 0L & this.GL15_glGetQueryObjectiv_pointer != 0L & this.GL15_glGetQueryObjectuiv_pointer != 0L;
    }

    private boolean GL20_initNativeFunctionAddresses() {
        this.GL20_glShaderSource_pointer = GLContext.getFunctionAddress("glShaderSource");
        boolean bl2 = this.GL20_glShaderSource_pointer != 0L;
        this.GL20_glCreateShader_pointer = GLContext.getFunctionAddress("glCreateShader");
        this.GL20_glIsShader_pointer = GLContext.getFunctionAddress("glIsShader");
        this.GL20_glCompileShader_pointer = GLContext.getFunctionAddress("glCompileShader");
        this.GL20_glDeleteShader_pointer = GLContext.getFunctionAddress("glDeleteShader");
        this.GL20_glCreateProgram_pointer = GLContext.getFunctionAddress("glCreateProgram");
        this.GL20_glIsProgram_pointer = GLContext.getFunctionAddress("glIsProgram");
        this.GL20_glAttachShader_pointer = GLContext.getFunctionAddress("glAttachShader");
        this.GL20_glDetachShader_pointer = GLContext.getFunctionAddress("glDetachShader");
        this.GL20_glLinkProgram_pointer = GLContext.getFunctionAddress("glLinkProgram");
        this.GL20_glUseProgram_pointer = GLContext.getFunctionAddress("glUseProgram");
        this.GL20_glValidateProgram_pointer = GLContext.getFunctionAddress("glValidateProgram");
        this.GL20_glDeleteProgram_pointer = GLContext.getFunctionAddress("glDeleteProgram");
        this.GL20_glUniform1f_pointer = GLContext.getFunctionAddress("glUniform1f");
        this.GL20_glUniform2f_pointer = GLContext.getFunctionAddress("glUniform2f");
        this.GL20_glUniform3f_pointer = GLContext.getFunctionAddress("glUniform3f");
        this.GL20_glUniform4f_pointer = GLContext.getFunctionAddress("glUniform4f");
        this.GL20_glUniform1i_pointer = GLContext.getFunctionAddress("glUniform1i");
        this.GL20_glUniform2i_pointer = GLContext.getFunctionAddress("glUniform2i");
        this.GL20_glUniform3i_pointer = GLContext.getFunctionAddress("glUniform3i");
        this.GL20_glUniform4i_pointer = GLContext.getFunctionAddress("glUniform4i");
        this.GL20_glUniform1fv_pointer = GLContext.getFunctionAddress("glUniform1fv");
        this.GL20_glUniform2fv_pointer = GLContext.getFunctionAddress("glUniform2fv");
        this.GL20_glUniform3fv_pointer = GLContext.getFunctionAddress("glUniform3fv");
        this.GL20_glUniform4fv_pointer = GLContext.getFunctionAddress("glUniform4fv");
        this.GL20_glUniform1iv_pointer = GLContext.getFunctionAddress("glUniform1iv");
        this.GL20_glUniform2iv_pointer = GLContext.getFunctionAddress("glUniform2iv");
        this.GL20_glUniform3iv_pointer = GLContext.getFunctionAddress("glUniform3iv");
        this.GL20_glUniform4iv_pointer = GLContext.getFunctionAddress("glUniform4iv");
        this.GL20_glUniformMatrix2fv_pointer = GLContext.getFunctionAddress("glUniformMatrix2fv");
        this.GL20_glUniformMatrix3fv_pointer = GLContext.getFunctionAddress("glUniformMatrix3fv");
        this.GL20_glUniformMatrix4fv_pointer = GLContext.getFunctionAddress("glUniformMatrix4fv");
        this.GL20_glGetShaderiv_pointer = GLContext.getFunctionAddress("glGetShaderiv");
        this.GL20_glGetProgramiv_pointer = GLContext.getFunctionAddress("glGetProgramiv");
        this.GL20_glGetShaderInfoLog_pointer = GLContext.getFunctionAddress("glGetShaderInfoLog");
        this.GL20_glGetProgramInfoLog_pointer = GLContext.getFunctionAddress("glGetProgramInfoLog");
        this.GL20_glGetAttachedShaders_pointer = GLContext.getFunctionAddress("glGetAttachedShaders");
        this.GL20_glGetUniformLocation_pointer = GLContext.getFunctionAddress("glGetUniformLocation");
        this.GL20_glGetActiveUniform_pointer = GLContext.getFunctionAddress("glGetActiveUniform");
        this.GL20_glGetUniformfv_pointer = GLContext.getFunctionAddress("glGetUniformfv");
        this.GL20_glGetUniformiv_pointer = GLContext.getFunctionAddress("glGetUniformiv");
        this.GL20_glGetShaderSource_pointer = GLContext.getFunctionAddress("glGetShaderSource");
        this.GL20_glVertexAttrib1s_pointer = GLContext.getFunctionAddress("glVertexAttrib1s");
        this.GL20_glVertexAttrib1f_pointer = GLContext.getFunctionAddress("glVertexAttrib1f");
        this.GL20_glVertexAttrib1d_pointer = GLContext.getFunctionAddress("glVertexAttrib1d");
        this.GL20_glVertexAttrib2s_pointer = GLContext.getFunctionAddress("glVertexAttrib2s");
        this.GL20_glVertexAttrib2f_pointer = GLContext.getFunctionAddress("glVertexAttrib2f");
        this.GL20_glVertexAttrib2d_pointer = GLContext.getFunctionAddress("glVertexAttrib2d");
        this.GL20_glVertexAttrib3s_pointer = GLContext.getFunctionAddress("glVertexAttrib3s");
        this.GL20_glVertexAttrib3f_pointer = GLContext.getFunctionAddress("glVertexAttrib3f");
        this.GL20_glVertexAttrib3d_pointer = GLContext.getFunctionAddress("glVertexAttrib3d");
        this.GL20_glVertexAttrib4s_pointer = GLContext.getFunctionAddress("glVertexAttrib4s");
        this.GL20_glVertexAttrib4f_pointer = GLContext.getFunctionAddress("glVertexAttrib4f");
        this.GL20_glVertexAttrib4d_pointer = GLContext.getFunctionAddress("glVertexAttrib4d");
        this.GL20_glVertexAttrib4Nub_pointer = GLContext.getFunctionAddress("glVertexAttrib4Nub");
        this.GL20_glVertexAttribPointer_pointer = GLContext.getFunctionAddress("glVertexAttribPointer");
        this.GL20_glEnableVertexAttribArray_pointer = GLContext.getFunctionAddress("glEnableVertexAttribArray");
        this.GL20_glDisableVertexAttribArray_pointer = GLContext.getFunctionAddress("glDisableVertexAttribArray");
        this.GL20_glGetVertexAttribfv_pointer = GLContext.getFunctionAddress("glGetVertexAttribfv");
        this.GL20_glGetVertexAttribdv_pointer = GLContext.getFunctionAddress("glGetVertexAttribdv");
        this.GL20_glGetVertexAttribiv_pointer = GLContext.getFunctionAddress("glGetVertexAttribiv");
        this.GL20_glGetVertexAttribPointerv_pointer = GLContext.getFunctionAddress("glGetVertexAttribPointerv");
        this.GL20_glBindAttribLocation_pointer = GLContext.getFunctionAddress("glBindAttribLocation");
        this.GL20_glGetActiveAttrib_pointer = GLContext.getFunctionAddress("glGetActiveAttrib");
        this.GL20_glGetAttribLocation_pointer = GLContext.getFunctionAddress("glGetAttribLocation");
        this.GL20_glDrawBuffers_pointer = GLContext.getFunctionAddress("glDrawBuffers");
        this.GL20_glStencilOpSeparate_pointer = GLContext.getFunctionAddress("glStencilOpSeparate");
        this.GL20_glStencilFuncSeparate_pointer = GLContext.getFunctionAddress("glStencilFuncSeparate");
        this.GL20_glStencilMaskSeparate_pointer = GLContext.getFunctionAddress("glStencilMaskSeparate");
        this.GL20_glBlendEquationSeparate_pointer = GLContext.getFunctionAddress("glBlendEquationSeparate");
        return bl2 & this.GL20_glCreateShader_pointer != 0L & this.GL20_glIsShader_pointer != 0L & this.GL20_glCompileShader_pointer != 0L & this.GL20_glDeleteShader_pointer != 0L & this.GL20_glCreateProgram_pointer != 0L & this.GL20_glIsProgram_pointer != 0L & this.GL20_glAttachShader_pointer != 0L & this.GL20_glDetachShader_pointer != 0L & this.GL20_glLinkProgram_pointer != 0L & this.GL20_glUseProgram_pointer != 0L & this.GL20_glValidateProgram_pointer != 0L & this.GL20_glDeleteProgram_pointer != 0L & this.GL20_glUniform1f_pointer != 0L & this.GL20_glUniform2f_pointer != 0L & this.GL20_glUniform3f_pointer != 0L & this.GL20_glUniform4f_pointer != 0L & this.GL20_glUniform1i_pointer != 0L & this.GL20_glUniform2i_pointer != 0L & this.GL20_glUniform3i_pointer != 0L & this.GL20_glUniform4i_pointer != 0L & this.GL20_glUniform1fv_pointer != 0L & this.GL20_glUniform2fv_pointer != 0L & this.GL20_glUniform3fv_pointer != 0L & this.GL20_glUniform4fv_pointer != 0L & this.GL20_glUniform1iv_pointer != 0L & this.GL20_glUniform2iv_pointer != 0L & this.GL20_glUniform3iv_pointer != 0L & this.GL20_glUniform4iv_pointer != 0L & this.GL20_glUniformMatrix2fv_pointer != 0L & this.GL20_glUniformMatrix3fv_pointer != 0L & this.GL20_glUniformMatrix4fv_pointer != 0L & this.GL20_glGetShaderiv_pointer != 0L & this.GL20_glGetProgramiv_pointer != 0L & this.GL20_glGetShaderInfoLog_pointer != 0L & this.GL20_glGetProgramInfoLog_pointer != 0L & this.GL20_glGetAttachedShaders_pointer != 0L & this.GL20_glGetUniformLocation_pointer != 0L & this.GL20_glGetActiveUniform_pointer != 0L & this.GL20_glGetUniformfv_pointer != 0L & this.GL20_glGetUniformiv_pointer != 0L & this.GL20_glGetShaderSource_pointer != 0L & this.GL20_glVertexAttrib1s_pointer != 0L & this.GL20_glVertexAttrib1f_pointer != 0L & this.GL20_glVertexAttrib1d_pointer != 0L & this.GL20_glVertexAttrib2s_pointer != 0L & this.GL20_glVertexAttrib2f_pointer != 0L & this.GL20_glVertexAttrib2d_pointer != 0L & this.GL20_glVertexAttrib3s_pointer != 0L & this.GL20_glVertexAttrib3f_pointer != 0L & this.GL20_glVertexAttrib3d_pointer != 0L & this.GL20_glVertexAttrib4s_pointer != 0L & this.GL20_glVertexAttrib4f_pointer != 0L & this.GL20_glVertexAttrib4d_pointer != 0L & this.GL20_glVertexAttrib4Nub_pointer != 0L & this.GL20_glVertexAttribPointer_pointer != 0L & this.GL20_glEnableVertexAttribArray_pointer != 0L & this.GL20_glDisableVertexAttribArray_pointer != 0L & this.GL20_glGetVertexAttribfv_pointer != 0L & this.GL20_glGetVertexAttribdv_pointer != 0L & this.GL20_glGetVertexAttribiv_pointer != 0L & this.GL20_glGetVertexAttribPointerv_pointer != 0L & this.GL20_glBindAttribLocation_pointer != 0L & this.GL20_glGetActiveAttrib_pointer != 0L & this.GL20_glGetAttribLocation_pointer != 0L & this.GL20_glDrawBuffers_pointer != 0L & this.GL20_glStencilOpSeparate_pointer != 0L & this.GL20_glStencilFuncSeparate_pointer != 0L & this.GL20_glStencilMaskSeparate_pointer != 0L & this.GL20_glBlendEquationSeparate_pointer != 0L;
    }

    private boolean GL21_initNativeFunctionAddresses() {
        this.GL21_glUniformMatrix2x3fv_pointer = GLContext.getFunctionAddress("glUniformMatrix2x3fv");
        boolean bl2 = this.GL21_glUniformMatrix2x3fv_pointer != 0L;
        this.GL21_glUniformMatrix3x2fv_pointer = GLContext.getFunctionAddress("glUniformMatrix3x2fv");
        this.GL21_glUniformMatrix2x4fv_pointer = GLContext.getFunctionAddress("glUniformMatrix2x4fv");
        this.GL21_glUniformMatrix4x2fv_pointer = GLContext.getFunctionAddress("glUniformMatrix4x2fv");
        this.GL21_glUniformMatrix3x4fv_pointer = GLContext.getFunctionAddress("glUniformMatrix3x4fv");
        this.GL21_glUniformMatrix4x3fv_pointer = GLContext.getFunctionAddress("glUniformMatrix4x3fv");
        return bl2 & this.GL21_glUniformMatrix3x2fv_pointer != 0L & this.GL21_glUniformMatrix2x4fv_pointer != 0L & this.GL21_glUniformMatrix4x2fv_pointer != 0L & this.GL21_glUniformMatrix3x4fv_pointer != 0L & this.GL21_glUniformMatrix4x3fv_pointer != 0L;
    }

    private boolean GL30_initNativeFunctionAddresses() {
        this.GL30_glGetStringi_pointer = GLContext.getFunctionAddress("glGetStringi");
        boolean bl2 = this.GL30_glGetStringi_pointer != 0L;
        this.GL30_glClearBufferfv_pointer = GLContext.getFunctionAddress("glClearBufferfv");
        this.GL30_glClearBufferiv_pointer = GLContext.getFunctionAddress("glClearBufferiv");
        this.GL30_glClearBufferuiv_pointer = GLContext.getFunctionAddress("glClearBufferuiv");
        this.GL30_glClearBufferfi_pointer = GLContext.getFunctionAddress("glClearBufferfi");
        this.GL30_glVertexAttribI1i_pointer = GLContext.getFunctionAddress("glVertexAttribI1i");
        this.GL30_glVertexAttribI2i_pointer = GLContext.getFunctionAddress("glVertexAttribI2i");
        this.GL30_glVertexAttribI3i_pointer = GLContext.getFunctionAddress("glVertexAttribI3i");
        this.GL30_glVertexAttribI4i_pointer = GLContext.getFunctionAddress("glVertexAttribI4i");
        this.GL30_glVertexAttribI1ui_pointer = GLContext.getFunctionAddress("glVertexAttribI1ui");
        this.GL30_glVertexAttribI2ui_pointer = GLContext.getFunctionAddress("glVertexAttribI2ui");
        this.GL30_glVertexAttribI3ui_pointer = GLContext.getFunctionAddress("glVertexAttribI3ui");
        this.GL30_glVertexAttribI4ui_pointer = GLContext.getFunctionAddress("glVertexAttribI4ui");
        this.GL30_glVertexAttribI1iv_pointer = GLContext.getFunctionAddress("glVertexAttribI1iv");
        this.GL30_glVertexAttribI2iv_pointer = GLContext.getFunctionAddress("glVertexAttribI2iv");
        this.GL30_glVertexAttribI3iv_pointer = GLContext.getFunctionAddress("glVertexAttribI3iv");
        this.GL30_glVertexAttribI4iv_pointer = GLContext.getFunctionAddress("glVertexAttribI4iv");
        this.GL30_glVertexAttribI1uiv_pointer = GLContext.getFunctionAddress("glVertexAttribI1uiv");
        this.GL30_glVertexAttribI2uiv_pointer = GLContext.getFunctionAddress("glVertexAttribI2uiv");
        this.GL30_glVertexAttribI3uiv_pointer = GLContext.getFunctionAddress("glVertexAttribI3uiv");
        this.GL30_glVertexAttribI4uiv_pointer = GLContext.getFunctionAddress("glVertexAttribI4uiv");
        this.GL30_glVertexAttribI4bv_pointer = GLContext.getFunctionAddress("glVertexAttribI4bv");
        this.GL30_glVertexAttribI4sv_pointer = GLContext.getFunctionAddress("glVertexAttribI4sv");
        this.GL30_glVertexAttribI4ubv_pointer = GLContext.getFunctionAddress("glVertexAttribI4ubv");
        this.GL30_glVertexAttribI4usv_pointer = GLContext.getFunctionAddress("glVertexAttribI4usv");
        this.GL30_glVertexAttribIPointer_pointer = GLContext.getFunctionAddress("glVertexAttribIPointer");
        this.GL30_glGetVertexAttribIiv_pointer = GLContext.getFunctionAddress("glGetVertexAttribIiv");
        this.GL30_glGetVertexAttribIuiv_pointer = GLContext.getFunctionAddress("glGetVertexAttribIuiv");
        this.GL30_glUniform1ui_pointer = GLContext.getFunctionAddress("glUniform1ui");
        this.GL30_glUniform2ui_pointer = GLContext.getFunctionAddress("glUniform2ui");
        this.GL30_glUniform3ui_pointer = GLContext.getFunctionAddress("glUniform3ui");
        this.GL30_glUniform4ui_pointer = GLContext.getFunctionAddress("glUniform4ui");
        this.GL30_glUniform1uiv_pointer = GLContext.getFunctionAddress("glUniform1uiv");
        this.GL30_glUniform2uiv_pointer = GLContext.getFunctionAddress("glUniform2uiv");
        this.GL30_glUniform3uiv_pointer = GLContext.getFunctionAddress("glUniform3uiv");
        this.GL30_glUniform4uiv_pointer = GLContext.getFunctionAddress("glUniform4uiv");
        this.GL30_glGetUniformuiv_pointer = GLContext.getFunctionAddress("glGetUniformuiv");
        this.GL30_glBindFragDataLocation_pointer = GLContext.getFunctionAddress("glBindFragDataLocation");
        this.GL30_glGetFragDataLocation_pointer = GLContext.getFunctionAddress("glGetFragDataLocation");
        this.GL30_glBeginConditionalRender_pointer = GLContext.getFunctionAddress("glBeginConditionalRender");
        this.GL30_glEndConditionalRender_pointer = GLContext.getFunctionAddress("glEndConditionalRender");
        this.GL30_glMapBufferRange_pointer = GLContext.getFunctionAddress("glMapBufferRange");
        this.GL30_glFlushMappedBufferRange_pointer = GLContext.getFunctionAddress("glFlushMappedBufferRange");
        this.GL30_glClampColor_pointer = GLContext.getFunctionAddress("glClampColor");
        this.GL30_glIsRenderbuffer_pointer = GLContext.getFunctionAddress("glIsRenderbuffer");
        this.GL30_glBindRenderbuffer_pointer = GLContext.getFunctionAddress("glBindRenderbuffer");
        this.GL30_glDeleteRenderbuffers_pointer = GLContext.getFunctionAddress("glDeleteRenderbuffers");
        this.GL30_glGenRenderbuffers_pointer = GLContext.getFunctionAddress("glGenRenderbuffers");
        this.GL30_glRenderbufferStorage_pointer = GLContext.getFunctionAddress("glRenderbufferStorage");
        this.GL30_glGetRenderbufferParameteriv_pointer = GLContext.getFunctionAddress("glGetRenderbufferParameteriv");
        this.GL30_glIsFramebuffer_pointer = GLContext.getFunctionAddress("glIsFramebuffer");
        this.GL30_glBindFramebuffer_pointer = GLContext.getFunctionAddress("glBindFramebuffer");
        this.GL30_glDeleteFramebuffers_pointer = GLContext.getFunctionAddress("glDeleteFramebuffers");
        this.GL30_glGenFramebuffers_pointer = GLContext.getFunctionAddress("glGenFramebuffers");
        this.GL30_glCheckFramebufferStatus_pointer = GLContext.getFunctionAddress("glCheckFramebufferStatus");
        this.GL30_glFramebufferTexture1D_pointer = GLContext.getFunctionAddress("glFramebufferTexture1D");
        this.GL30_glFramebufferTexture2D_pointer = GLContext.getFunctionAddress("glFramebufferTexture2D");
        this.GL30_glFramebufferTexture3D_pointer = GLContext.getFunctionAddress("glFramebufferTexture3D");
        this.GL30_glFramebufferRenderbuffer_pointer = GLContext.getFunctionAddress("glFramebufferRenderbuffer");
        this.GL30_glGetFramebufferAttachmentParameteriv_pointer = GLContext.getFunctionAddress("glGetFramebufferAttachmentParameteriv");
        this.GL30_glGenerateMipmap_pointer = GLContext.getFunctionAddress("glGenerateMipmap");
        this.GL30_glRenderbufferStorageMultisample_pointer = GLContext.getFunctionAddress("glRenderbufferStorageMultisample");
        this.GL30_glBlitFramebuffer_pointer = GLContext.getFunctionAddress("glBlitFramebuffer");
        this.GL30_glTexParameterIiv_pointer = GLContext.getFunctionAddress("glTexParameterIiv");
        this.GL30_glTexParameterIuiv_pointer = GLContext.getFunctionAddress("glTexParameterIuiv");
        this.GL30_glGetTexParameterIiv_pointer = GLContext.getFunctionAddress("glGetTexParameterIiv");
        this.GL30_glGetTexParameterIuiv_pointer = GLContext.getFunctionAddress("glGetTexParameterIuiv");
        this.GL30_glFramebufferTextureLayer_pointer = GLContext.getFunctionAddress("glFramebufferTextureLayer");
        this.GL30_glColorMaski_pointer = GLContext.getFunctionAddress("glColorMaski");
        this.GL30_glGetBooleani_v_pointer = GLContext.getFunctionAddress("glGetBooleani_v");
        this.GL30_glGetIntegeri_v_pointer = GLContext.getFunctionAddress("glGetIntegeri_v");
        this.GL30_glEnablei_pointer = GLContext.getFunctionAddress("glEnablei");
        this.GL30_glDisablei_pointer = GLContext.getFunctionAddress("glDisablei");
        this.GL30_glIsEnabledi_pointer = GLContext.getFunctionAddress("glIsEnabledi");
        this.GL30_glBindBufferRange_pointer = GLContext.getFunctionAddress("glBindBufferRange");
        this.GL30_glBindBufferBase_pointer = GLContext.getFunctionAddress("glBindBufferBase");
        this.GL30_glBeginTransformFeedback_pointer = GLContext.getFunctionAddress("glBeginTransformFeedback");
        this.GL30_glEndTransformFeedback_pointer = GLContext.getFunctionAddress("glEndTransformFeedback");
        this.GL30_glTransformFeedbackVaryings_pointer = GLContext.getFunctionAddress("glTransformFeedbackVaryings");
        this.GL30_glGetTransformFeedbackVarying_pointer = GLContext.getFunctionAddress("glGetTransformFeedbackVarying");
        this.GL30_glBindVertexArray_pointer = GLContext.getFunctionAddress("glBindVertexArray");
        this.GL30_glDeleteVertexArrays_pointer = GLContext.getFunctionAddress("glDeleteVertexArrays");
        this.GL30_glGenVertexArrays_pointer = GLContext.getFunctionAddress("glGenVertexArrays");
        this.GL30_glIsVertexArray_pointer = GLContext.getFunctionAddress("glIsVertexArray");
        return bl2 & this.GL30_glClearBufferfv_pointer != 0L & this.GL30_glClearBufferiv_pointer != 0L & this.GL30_glClearBufferuiv_pointer != 0L & this.GL30_glClearBufferfi_pointer != 0L & this.GL30_glVertexAttribI1i_pointer != 0L & this.GL30_glVertexAttribI2i_pointer != 0L & this.GL30_glVertexAttribI3i_pointer != 0L & this.GL30_glVertexAttribI4i_pointer != 0L & this.GL30_glVertexAttribI1ui_pointer != 0L & this.GL30_glVertexAttribI2ui_pointer != 0L & this.GL30_glVertexAttribI3ui_pointer != 0L & this.GL30_glVertexAttribI4ui_pointer != 0L & this.GL30_glVertexAttribI1iv_pointer != 0L & this.GL30_glVertexAttribI2iv_pointer != 0L & this.GL30_glVertexAttribI3iv_pointer != 0L & this.GL30_glVertexAttribI4iv_pointer != 0L & this.GL30_glVertexAttribI1uiv_pointer != 0L & this.GL30_glVertexAttribI2uiv_pointer != 0L & this.GL30_glVertexAttribI3uiv_pointer != 0L & this.GL30_glVertexAttribI4uiv_pointer != 0L & this.GL30_glVertexAttribI4bv_pointer != 0L & this.GL30_glVertexAttribI4sv_pointer != 0L & this.GL30_glVertexAttribI4ubv_pointer != 0L & this.GL30_glVertexAttribI4usv_pointer != 0L & this.GL30_glVertexAttribIPointer_pointer != 0L & this.GL30_glGetVertexAttribIiv_pointer != 0L & this.GL30_glGetVertexAttribIuiv_pointer != 0L & this.GL30_glUniform1ui_pointer != 0L & this.GL30_glUniform2ui_pointer != 0L & this.GL30_glUniform3ui_pointer != 0L & this.GL30_glUniform4ui_pointer != 0L & this.GL30_glUniform1uiv_pointer != 0L & this.GL30_glUniform2uiv_pointer != 0L & this.GL30_glUniform3uiv_pointer != 0L & this.GL30_glUniform4uiv_pointer != 0L & this.GL30_glGetUniformuiv_pointer != 0L & this.GL30_glBindFragDataLocation_pointer != 0L & this.GL30_glGetFragDataLocation_pointer != 0L & this.GL30_glBeginConditionalRender_pointer != 0L & this.GL30_glEndConditionalRender_pointer != 0L & this.GL30_glMapBufferRange_pointer != 0L & this.GL30_glFlushMappedBufferRange_pointer != 0L & this.GL30_glClampColor_pointer != 0L & this.GL30_glIsRenderbuffer_pointer != 0L & this.GL30_glBindRenderbuffer_pointer != 0L & this.GL30_glDeleteRenderbuffers_pointer != 0L & this.GL30_glGenRenderbuffers_pointer != 0L & this.GL30_glRenderbufferStorage_pointer != 0L & this.GL30_glGetRenderbufferParameteriv_pointer != 0L & this.GL30_glIsFramebuffer_pointer != 0L & this.GL30_glBindFramebuffer_pointer != 0L & this.GL30_glDeleteFramebuffers_pointer != 0L & this.GL30_glGenFramebuffers_pointer != 0L & this.GL30_glCheckFramebufferStatus_pointer != 0L & this.GL30_glFramebufferTexture1D_pointer != 0L & this.GL30_glFramebufferTexture2D_pointer != 0L & this.GL30_glFramebufferTexture3D_pointer != 0L & this.GL30_glFramebufferRenderbuffer_pointer != 0L & this.GL30_glGetFramebufferAttachmentParameteriv_pointer != 0L & this.GL30_glGenerateMipmap_pointer != 0L & this.GL30_glRenderbufferStorageMultisample_pointer != 0L & this.GL30_glBlitFramebuffer_pointer != 0L & this.GL30_glTexParameterIiv_pointer != 0L & this.GL30_glTexParameterIuiv_pointer != 0L & this.GL30_glGetTexParameterIiv_pointer != 0L & this.GL30_glGetTexParameterIuiv_pointer != 0L & this.GL30_glFramebufferTextureLayer_pointer != 0L & this.GL30_glColorMaski_pointer != 0L & this.GL30_glGetBooleani_v_pointer != 0L & this.GL30_glGetIntegeri_v_pointer != 0L & this.GL30_glEnablei_pointer != 0L & this.GL30_glDisablei_pointer != 0L & this.GL30_glIsEnabledi_pointer != 0L & this.GL30_glBindBufferRange_pointer != 0L & this.GL30_glBindBufferBase_pointer != 0L & this.GL30_glBeginTransformFeedback_pointer != 0L & this.GL30_glEndTransformFeedback_pointer != 0L & this.GL30_glTransformFeedbackVaryings_pointer != 0L & this.GL30_glGetTransformFeedbackVarying_pointer != 0L & this.GL30_glBindVertexArray_pointer != 0L & this.GL30_glDeleteVertexArrays_pointer != 0L & this.GL30_glGenVertexArrays_pointer != 0L & this.GL30_glIsVertexArray_pointer != 0L;
    }

    private boolean GL31_initNativeFunctionAddresses() {
        this.GL31_glDrawArraysInstanced_pointer = GLContext.getFunctionAddress("glDrawArraysInstanced");
        boolean bl2 = this.GL31_glDrawArraysInstanced_pointer != 0L;
        this.GL31_glDrawElementsInstanced_pointer = GLContext.getFunctionAddress("glDrawElementsInstanced");
        this.GL31_glCopyBufferSubData_pointer = GLContext.getFunctionAddress("glCopyBufferSubData");
        this.GL31_glPrimitiveRestartIndex_pointer = GLContext.getFunctionAddress("glPrimitiveRestartIndex");
        this.GL31_glTexBuffer_pointer = GLContext.getFunctionAddress("glTexBuffer");
        this.GL31_glGetUniformIndices_pointer = GLContext.getFunctionAddress("glGetUniformIndices");
        this.GL31_glGetActiveUniformsiv_pointer = GLContext.getFunctionAddress("glGetActiveUniformsiv");
        this.GL31_glGetActiveUniformName_pointer = GLContext.getFunctionAddress("glGetActiveUniformName");
        this.GL31_glGetUniformBlockIndex_pointer = GLContext.getFunctionAddress("glGetUniformBlockIndex");
        this.GL31_glGetActiveUniformBlockiv_pointer = GLContext.getFunctionAddress("glGetActiveUniformBlockiv");
        this.GL31_glGetActiveUniformBlockName_pointer = GLContext.getFunctionAddress("glGetActiveUniformBlockName");
        this.GL31_glUniformBlockBinding_pointer = GLContext.getFunctionAddress("glUniformBlockBinding");
        return bl2 & this.GL31_glDrawElementsInstanced_pointer != 0L & this.GL31_glCopyBufferSubData_pointer != 0L & this.GL31_glPrimitiveRestartIndex_pointer != 0L & this.GL31_glTexBuffer_pointer != 0L & this.GL31_glGetUniformIndices_pointer != 0L & this.GL31_glGetActiveUniformsiv_pointer != 0L & this.GL31_glGetActiveUniformName_pointer != 0L & this.GL31_glGetUniformBlockIndex_pointer != 0L & this.GL31_glGetActiveUniformBlockiv_pointer != 0L & this.GL31_glGetActiveUniformBlockName_pointer != 0L & this.GL31_glUniformBlockBinding_pointer != 0L;
    }

    private boolean GL32_initNativeFunctionAddresses() {
        this.GL32_glDrawElementsBaseVertex_pointer = GLContext.getFunctionAddress("glDrawElementsBaseVertex");
        boolean bl2 = this.GL32_glDrawElementsBaseVertex_pointer != 0L;
        this.GL32_glDrawRangeElementsBaseVertex_pointer = GLContext.getFunctionAddress("glDrawRangeElementsBaseVertex");
        this.GL32_glDrawElementsInstancedBaseVertex_pointer = GLContext.getFunctionAddress("glDrawElementsInstancedBaseVertex");
        this.GL32_glProvokingVertex_pointer = GLContext.getFunctionAddress("glProvokingVertex");
        this.GL32_glTexImage2DMultisample_pointer = GLContext.getFunctionAddress("glTexImage2DMultisample");
        this.GL32_glTexImage3DMultisample_pointer = GLContext.getFunctionAddress("glTexImage3DMultisample");
        this.GL32_glGetMultisamplefv_pointer = GLContext.getFunctionAddress("glGetMultisamplefv");
        this.GL32_glSampleMaski_pointer = GLContext.getFunctionAddress("glSampleMaski");
        this.GL32_glFramebufferTexture_pointer = GLContext.getFunctionAddress("glFramebufferTexture");
        this.GL32_glFramebufferTextureLayer_pointer = GLContext.getFunctionAddress("glFramebufferTextureLayer");
        this.GL32_glFenceSync_pointer = GLContext.getFunctionAddress("glFenceSync");
        this.GL32_glIsSync_pointer = GLContext.getFunctionAddress("glIsSync");
        this.GL32_glDeleteSync_pointer = GLContext.getFunctionAddress("glDeleteSync");
        this.GL32_glClientWaitSync_pointer = GLContext.getFunctionAddress("glClientWaitSync");
        this.GL32_glWaitSync_pointer = GLContext.getFunctionAddress("glWaitSync");
        this.GL32_glGetInteger64v_pointer = GLContext.getFunctionAddress("glGetInteger64v");
        boolean bl3 = bl2 & this.GL32_glDrawRangeElementsBaseVertex_pointer != 0L & this.GL32_glDrawElementsInstancedBaseVertex_pointer != 0L & this.GL32_glProvokingVertex_pointer != 0L & this.GL32_glTexImage2DMultisample_pointer != 0L & this.GL32_glTexImage3DMultisample_pointer != 0L & this.GL32_glGetMultisamplefv_pointer != 0L & this.GL32_glSampleMaski_pointer != 0L & this.GL32_glFramebufferTexture_pointer != 0L & this.GL32_glFramebufferTextureLayer_pointer != 0L & this.GL32_glFenceSync_pointer != 0L & this.GL32_glIsSync_pointer != 0L & this.GL32_glDeleteSync_pointer != 0L & this.GL32_glClientWaitSync_pointer != 0L & this.GL32_glWaitSync_pointer != 0L & this.GL32_glGetInteger64v_pointer != 0L;
        this.GL32_glGetInteger64i_v_pointer = GLContext.getFunctionAddress("glGetInteger64i_v");
        if (this.GL32_glGetInteger64i_v_pointer == 0L) {
            // empty if block
        }
        return bl3 & true & (this.GL32_glGetSynciv_pointer = GLContext.getFunctionAddress("glGetSynciv")) != 0L;
    }

    private boolean GL33_initNativeFunctionAddresses(boolean forwardCompatible) {
        this.GL33_glBindFragDataLocationIndexed_pointer = GLContext.getFunctionAddress("glBindFragDataLocationIndexed");
        boolean bl2 = this.GL33_glBindFragDataLocationIndexed_pointer != 0L;
        this.GL33_glGetFragDataIndex_pointer = GLContext.getFunctionAddress("glGetFragDataIndex");
        this.GL33_glGenSamplers_pointer = GLContext.getFunctionAddress("glGenSamplers");
        this.GL33_glDeleteSamplers_pointer = GLContext.getFunctionAddress("glDeleteSamplers");
        this.GL33_glIsSampler_pointer = GLContext.getFunctionAddress("glIsSampler");
        this.GL33_glBindSampler_pointer = GLContext.getFunctionAddress("glBindSampler");
        this.GL33_glSamplerParameteri_pointer = GLContext.getFunctionAddress("glSamplerParameteri");
        this.GL33_glSamplerParameterf_pointer = GLContext.getFunctionAddress("glSamplerParameterf");
        this.GL33_glSamplerParameteriv_pointer = GLContext.getFunctionAddress("glSamplerParameteriv");
        this.GL33_glSamplerParameterfv_pointer = GLContext.getFunctionAddress("glSamplerParameterfv");
        this.GL33_glSamplerParameterIiv_pointer = GLContext.getFunctionAddress("glSamplerParameterIiv");
        this.GL33_glSamplerParameterIuiv_pointer = GLContext.getFunctionAddress("glSamplerParameterIuiv");
        this.GL33_glGetSamplerParameteriv_pointer = GLContext.getFunctionAddress("glGetSamplerParameteriv");
        this.GL33_glGetSamplerParameterfv_pointer = GLContext.getFunctionAddress("glGetSamplerParameterfv");
        this.GL33_glGetSamplerParameterIiv_pointer = GLContext.getFunctionAddress("glGetSamplerParameterIiv");
        this.GL33_glGetSamplerParameterIuiv_pointer = GLContext.getFunctionAddress("glGetSamplerParameterIuiv");
        this.GL33_glQueryCounter_pointer = GLContext.getFunctionAddress("glQueryCounter");
        this.GL33_glGetQueryObjecti64v_pointer = GLContext.getFunctionAddress("glGetQueryObjecti64v");
        this.GL33_glGetQueryObjectui64v_pointer = GLContext.getFunctionAddress("glGetQueryObjectui64v");
        this.GL33_glVertexAttribDivisor_pointer = GLContext.getFunctionAddress("glVertexAttribDivisor");
        return bl2 & this.GL33_glGetFragDataIndex_pointer != 0L & this.GL33_glGenSamplers_pointer != 0L & this.GL33_glDeleteSamplers_pointer != 0L & this.GL33_glIsSampler_pointer != 0L & this.GL33_glBindSampler_pointer != 0L & this.GL33_glSamplerParameteri_pointer != 0L & this.GL33_glSamplerParameterf_pointer != 0L & this.GL33_glSamplerParameteriv_pointer != 0L & this.GL33_glSamplerParameterfv_pointer != 0L & this.GL33_glSamplerParameterIiv_pointer != 0L & this.GL33_glSamplerParameterIuiv_pointer != 0L & this.GL33_glGetSamplerParameteriv_pointer != 0L & this.GL33_glGetSamplerParameterfv_pointer != 0L & this.GL33_glGetSamplerParameterIiv_pointer != 0L & this.GL33_glGetSamplerParameterIuiv_pointer != 0L & this.GL33_glQueryCounter_pointer != 0L & this.GL33_glGetQueryObjecti64v_pointer != 0L & this.GL33_glGetQueryObjectui64v_pointer != 0L & this.GL33_glVertexAttribDivisor_pointer != 0L & (forwardCompatible || (this.GL33_glVertexP2ui_pointer = GLContext.getFunctionAddress("glVertexP2ui")) != 0L) & (forwardCompatible || (this.GL33_glVertexP3ui_pointer = GLContext.getFunctionAddress("glVertexP3ui")) != 0L) & (forwardCompatible || (this.GL33_glVertexP4ui_pointer = GLContext.getFunctionAddress("glVertexP4ui")) != 0L) & (forwardCompatible || (this.GL33_glVertexP2uiv_pointer = GLContext.getFunctionAddress("glVertexP2uiv")) != 0L) & (forwardCompatible || (this.GL33_glVertexP3uiv_pointer = GLContext.getFunctionAddress("glVertexP3uiv")) != 0L) & (forwardCompatible || (this.GL33_glVertexP4uiv_pointer = GLContext.getFunctionAddress("glVertexP4uiv")) != 0L) & (forwardCompatible || (this.GL33_glTexCoordP1ui_pointer = GLContext.getFunctionAddress("glTexCoordP1ui")) != 0L) & (forwardCompatible || (this.GL33_glTexCoordP2ui_pointer = GLContext.getFunctionAddress("glTexCoordP2ui")) != 0L) & (forwardCompatible || (this.GL33_glTexCoordP3ui_pointer = GLContext.getFunctionAddress("glTexCoordP3ui")) != 0L) & (forwardCompatible || (this.GL33_glTexCoordP4ui_pointer = GLContext.getFunctionAddress("glTexCoordP4ui")) != 0L) & (forwardCompatible || (this.GL33_glTexCoordP1uiv_pointer = GLContext.getFunctionAddress("glTexCoordP1uiv")) != 0L) & (forwardCompatible || (this.GL33_glTexCoordP2uiv_pointer = GLContext.getFunctionAddress("glTexCoordP2uiv")) != 0L) & (forwardCompatible || (this.GL33_glTexCoordP3uiv_pointer = GLContext.getFunctionAddress("glTexCoordP3uiv")) != 0L) & (forwardCompatible || (this.GL33_glTexCoordP4uiv_pointer = GLContext.getFunctionAddress("glTexCoordP4uiv")) != 0L) & (forwardCompatible || (this.GL33_glMultiTexCoordP1ui_pointer = GLContext.getFunctionAddress("glMultiTexCoordP1ui")) != 0L) & (forwardCompatible || (this.GL33_glMultiTexCoordP2ui_pointer = GLContext.getFunctionAddress("glMultiTexCoordP2ui")) != 0L) & (forwardCompatible || (this.GL33_glMultiTexCoordP3ui_pointer = GLContext.getFunctionAddress("glMultiTexCoordP3ui")) != 0L) & (forwardCompatible || (this.GL33_glMultiTexCoordP4ui_pointer = GLContext.getFunctionAddress("glMultiTexCoordP4ui")) != 0L) & (forwardCompatible || (this.GL33_glMultiTexCoordP1uiv_pointer = GLContext.getFunctionAddress("glMultiTexCoordP1uiv")) != 0L) & (forwardCompatible || (this.GL33_glMultiTexCoordP2uiv_pointer = GLContext.getFunctionAddress("glMultiTexCoordP2uiv")) != 0L) & (forwardCompatible || (this.GL33_glMultiTexCoordP3uiv_pointer = GLContext.getFunctionAddress("glMultiTexCoordP3uiv")) != 0L) & (forwardCompatible || (this.GL33_glMultiTexCoordP4uiv_pointer = GLContext.getFunctionAddress("glMultiTexCoordP4uiv")) != 0L) & (forwardCompatible || (this.GL33_glNormalP3ui_pointer = GLContext.getFunctionAddress("glNormalP3ui")) != 0L) & (forwardCompatible || (this.GL33_glNormalP3uiv_pointer = GLContext.getFunctionAddress("glNormalP3uiv")) != 0L) & (forwardCompatible || (this.GL33_glColorP3ui_pointer = GLContext.getFunctionAddress("glColorP3ui")) != 0L) & (forwardCompatible || (this.GL33_glColorP4ui_pointer = GLContext.getFunctionAddress("glColorP4ui")) != 0L) & (forwardCompatible || (this.GL33_glColorP3uiv_pointer = GLContext.getFunctionAddress("glColorP3uiv")) != 0L) & (forwardCompatible || (this.GL33_glColorP4uiv_pointer = GLContext.getFunctionAddress("glColorP4uiv")) != 0L) & (forwardCompatible || (this.GL33_glSecondaryColorP3ui_pointer = GLContext.getFunctionAddress("glSecondaryColorP3ui")) != 0L) & (forwardCompatible || (this.GL33_glSecondaryColorP3uiv_pointer = GLContext.getFunctionAddress("glSecondaryColorP3uiv")) != 0L) & (forwardCompatible || (this.GL33_glVertexAttribP1ui_pointer = GLContext.getFunctionAddress("glVertexAttribP1ui")) != 0L) & (forwardCompatible || (this.GL33_glVertexAttribP2ui_pointer = GLContext.getFunctionAddress("glVertexAttribP2ui")) != 0L) & (forwardCompatible || (this.GL33_glVertexAttribP3ui_pointer = GLContext.getFunctionAddress("glVertexAttribP3ui")) != 0L) & (forwardCompatible || (this.GL33_glVertexAttribP4ui_pointer = GLContext.getFunctionAddress("glVertexAttribP4ui")) != 0L) & (forwardCompatible || (this.GL33_glVertexAttribP1uiv_pointer = GLContext.getFunctionAddress("glVertexAttribP1uiv")) != 0L) & (forwardCompatible || (this.GL33_glVertexAttribP2uiv_pointer = GLContext.getFunctionAddress("glVertexAttribP2uiv")) != 0L) & (forwardCompatible || (this.GL33_glVertexAttribP3uiv_pointer = GLContext.getFunctionAddress("glVertexAttribP3uiv")) != 0L) & (forwardCompatible || (this.GL33_glVertexAttribP4uiv_pointer = GLContext.getFunctionAddress("glVertexAttribP4uiv")) != 0L);
    }

    private boolean GL40_initNativeFunctionAddresses() {
        this.GL40_glBlendEquationi_pointer = GLContext.getFunctionAddress("glBlendEquationi");
        if (this.GL40_glBlendEquationi_pointer == 0L) {
            // empty if block
        }
        if ((this.GL40_glBlendEquationSeparatei_pointer = GLContext.getFunctionAddress("glBlendEquationSeparatei")) == 0L) {
            // empty if block
        }
        if ((this.GL40_glBlendFunci_pointer = GLContext.getFunctionAddress("glBlendFunci")) == 0L) {
            // empty if block
        }
        if ((this.GL40_glBlendFuncSeparatei_pointer = GLContext.getFunctionAddress("glBlendFuncSeparatei")) == 0L) {
            // empty if block
        }
        boolean bl2 = true & true & true & true & (this.GL40_glDrawArraysIndirect_pointer = GLContext.getFunctionAddress("glDrawArraysIndirect")) != 0L;
        this.GL40_glDrawElementsIndirect_pointer = GLContext.getFunctionAddress("glDrawElementsIndirect");
        this.GL40_glUniform1d_pointer = GLContext.getFunctionAddress("glUniform1d");
        this.GL40_glUniform2d_pointer = GLContext.getFunctionAddress("glUniform2d");
        this.GL40_glUniform3d_pointer = GLContext.getFunctionAddress("glUniform3d");
        this.GL40_glUniform4d_pointer = GLContext.getFunctionAddress("glUniform4d");
        this.GL40_glUniform1dv_pointer = GLContext.getFunctionAddress("glUniform1dv");
        this.GL40_glUniform2dv_pointer = GLContext.getFunctionAddress("glUniform2dv");
        this.GL40_glUniform3dv_pointer = GLContext.getFunctionAddress("glUniform3dv");
        this.GL40_glUniform4dv_pointer = GLContext.getFunctionAddress("glUniform4dv");
        this.GL40_glUniformMatrix2dv_pointer = GLContext.getFunctionAddress("glUniformMatrix2dv");
        this.GL40_glUniformMatrix3dv_pointer = GLContext.getFunctionAddress("glUniformMatrix3dv");
        this.GL40_glUniformMatrix4dv_pointer = GLContext.getFunctionAddress("glUniformMatrix4dv");
        this.GL40_glUniformMatrix2x3dv_pointer = GLContext.getFunctionAddress("glUniformMatrix2x3dv");
        this.GL40_glUniformMatrix2x4dv_pointer = GLContext.getFunctionAddress("glUniformMatrix2x4dv");
        this.GL40_glUniformMatrix3x2dv_pointer = GLContext.getFunctionAddress("glUniformMatrix3x2dv");
        this.GL40_glUniformMatrix3x4dv_pointer = GLContext.getFunctionAddress("glUniformMatrix3x4dv");
        this.GL40_glUniformMatrix4x2dv_pointer = GLContext.getFunctionAddress("glUniformMatrix4x2dv");
        this.GL40_glUniformMatrix4x3dv_pointer = GLContext.getFunctionAddress("glUniformMatrix4x3dv");
        this.GL40_glGetUniformdv_pointer = GLContext.getFunctionAddress("glGetUniformdv");
        boolean bl3 = bl2 & this.GL40_glDrawElementsIndirect_pointer != 0L & this.GL40_glUniform1d_pointer != 0L & this.GL40_glUniform2d_pointer != 0L & this.GL40_glUniform3d_pointer != 0L & this.GL40_glUniform4d_pointer != 0L & this.GL40_glUniform1dv_pointer != 0L & this.GL40_glUniform2dv_pointer != 0L & this.GL40_glUniform3dv_pointer != 0L & this.GL40_glUniform4dv_pointer != 0L & this.GL40_glUniformMatrix2dv_pointer != 0L & this.GL40_glUniformMatrix3dv_pointer != 0L & this.GL40_glUniformMatrix4dv_pointer != 0L & this.GL40_glUniformMatrix2x3dv_pointer != 0L & this.GL40_glUniformMatrix2x4dv_pointer != 0L & this.GL40_glUniformMatrix3x2dv_pointer != 0L & this.GL40_glUniformMatrix3x4dv_pointer != 0L & this.GL40_glUniformMatrix4x2dv_pointer != 0L & this.GL40_glUniformMatrix4x3dv_pointer != 0L & this.GL40_glGetUniformdv_pointer != 0L;
        this.GL40_glMinSampleShading_pointer = GLContext.getFunctionAddress("glMinSampleShading");
        if (this.GL40_glMinSampleShading_pointer == 0L) {
            // empty if block
        }
        boolean bl4 = bl3 & true & (this.GL40_glGetSubroutineUniformLocation_pointer = GLContext.getFunctionAddress("glGetSubroutineUniformLocation")) != 0L;
        this.GL40_glGetSubroutineIndex_pointer = GLContext.getFunctionAddress("glGetSubroutineIndex");
        this.GL40_glGetActiveSubroutineUniformiv_pointer = GLContext.getFunctionAddress("glGetActiveSubroutineUniformiv");
        this.GL40_glGetActiveSubroutineUniformName_pointer = GLContext.getFunctionAddress("glGetActiveSubroutineUniformName");
        this.GL40_glGetActiveSubroutineName_pointer = GLContext.getFunctionAddress("glGetActiveSubroutineName");
        this.GL40_glUniformSubroutinesuiv_pointer = GLContext.getFunctionAddress("glUniformSubroutinesuiv");
        this.GL40_glGetUniformSubroutineuiv_pointer = GLContext.getFunctionAddress("glGetUniformSubroutineuiv");
        this.GL40_glGetProgramStageiv_pointer = GLContext.getFunctionAddress("glGetProgramStageiv");
        this.GL40_glPatchParameteri_pointer = GLContext.getFunctionAddress("glPatchParameteri");
        this.GL40_glPatchParameterfv_pointer = GLContext.getFunctionAddress("glPatchParameterfv");
        this.GL40_glBindTransformFeedback_pointer = GLContext.getFunctionAddress("glBindTransformFeedback");
        this.GL40_glDeleteTransformFeedbacks_pointer = GLContext.getFunctionAddress("glDeleteTransformFeedbacks");
        this.GL40_glGenTransformFeedbacks_pointer = GLContext.getFunctionAddress("glGenTransformFeedbacks");
        this.GL40_glIsTransformFeedback_pointer = GLContext.getFunctionAddress("glIsTransformFeedback");
        this.GL40_glPauseTransformFeedback_pointer = GLContext.getFunctionAddress("glPauseTransformFeedback");
        this.GL40_glResumeTransformFeedback_pointer = GLContext.getFunctionAddress("glResumeTransformFeedback");
        this.GL40_glDrawTransformFeedback_pointer = GLContext.getFunctionAddress("glDrawTransformFeedback");
        this.GL40_glDrawTransformFeedbackStream_pointer = GLContext.getFunctionAddress("glDrawTransformFeedbackStream");
        this.GL40_glBeginQueryIndexed_pointer = GLContext.getFunctionAddress("glBeginQueryIndexed");
        this.GL40_glEndQueryIndexed_pointer = GLContext.getFunctionAddress("glEndQueryIndexed");
        this.GL40_glGetQueryIndexediv_pointer = GLContext.getFunctionAddress("glGetQueryIndexediv");
        return bl4 & this.GL40_glGetSubroutineIndex_pointer != 0L & this.GL40_glGetActiveSubroutineUniformiv_pointer != 0L & this.GL40_glGetActiveSubroutineUniformName_pointer != 0L & this.GL40_glGetActiveSubroutineName_pointer != 0L & this.GL40_glUniformSubroutinesuiv_pointer != 0L & this.GL40_glGetUniformSubroutineuiv_pointer != 0L & this.GL40_glGetProgramStageiv_pointer != 0L & this.GL40_glPatchParameteri_pointer != 0L & this.GL40_glPatchParameterfv_pointer != 0L & this.GL40_glBindTransformFeedback_pointer != 0L & this.GL40_glDeleteTransformFeedbacks_pointer != 0L & this.GL40_glGenTransformFeedbacks_pointer != 0L & this.GL40_glIsTransformFeedback_pointer != 0L & this.GL40_glPauseTransformFeedback_pointer != 0L & this.GL40_glResumeTransformFeedback_pointer != 0L & this.GL40_glDrawTransformFeedback_pointer != 0L & this.GL40_glDrawTransformFeedbackStream_pointer != 0L & this.GL40_glBeginQueryIndexed_pointer != 0L & this.GL40_glEndQueryIndexed_pointer != 0L & this.GL40_glGetQueryIndexediv_pointer != 0L;
    }

    private boolean GREMEDY_string_marker_initNativeFunctionAddresses() {
        this.GREMEDY_string_marker_glStringMarkerGREMEDY_pointer = GLContext.getFunctionAddress("glStringMarkerGREMEDY");
        return this.GREMEDY_string_marker_glStringMarkerGREMEDY_pointer != 0L;
    }

    private boolean NV_conditional_render_initNativeFunctionAddresses() {
        this.NV_conditional_render_glBeginConditionalRenderNV_pointer = GLContext.getFunctionAddress("glBeginConditionalRenderNV");
        boolean bl2 = this.NV_conditional_render_glBeginConditionalRenderNV_pointer != 0L;
        this.NV_conditional_render_glEndConditionalRenderNV_pointer = GLContext.getFunctionAddress("glEndConditionalRenderNV");
        return bl2 & this.NV_conditional_render_glEndConditionalRenderNV_pointer != 0L;
    }

    private boolean NV_copy_image_initNativeFunctionAddresses() {
        this.NV_copy_image_glCopyImageSubDataNV_pointer = GLContext.getFunctionAddress("glCopyImageSubDataNV");
        return this.NV_copy_image_glCopyImageSubDataNV_pointer != 0L;
    }

    private boolean NV_depth_buffer_float_initNativeFunctionAddresses() {
        this.NV_depth_buffer_float_glDepthRangedNV_pointer = GLContext.getFunctionAddress("glDepthRangedNV");
        boolean bl2 = this.NV_depth_buffer_float_glDepthRangedNV_pointer != 0L;
        this.NV_depth_buffer_float_glClearDepthdNV_pointer = GLContext.getFunctionAddress("glClearDepthdNV");
        this.NV_depth_buffer_float_glDepthBoundsdNV_pointer = GLContext.getFunctionAddress("glDepthBoundsdNV");
        return bl2 & this.NV_depth_buffer_float_glClearDepthdNV_pointer != 0L & this.NV_depth_buffer_float_glDepthBoundsdNV_pointer != 0L;
    }

    private boolean NV_evaluators_initNativeFunctionAddresses() {
        this.NV_evaluators_glGetMapControlPointsNV_pointer = GLContext.getFunctionAddress("glGetMapControlPointsNV");
        boolean bl2 = this.NV_evaluators_glGetMapControlPointsNV_pointer != 0L;
        this.NV_evaluators_glMapControlPointsNV_pointer = GLContext.getFunctionAddress("glMapControlPointsNV");
        this.NV_evaluators_glMapParameterfvNV_pointer = GLContext.getFunctionAddress("glMapParameterfvNV");
        this.NV_evaluators_glMapParameterivNV_pointer = GLContext.getFunctionAddress("glMapParameterivNV");
        this.NV_evaluators_glGetMapParameterfvNV_pointer = GLContext.getFunctionAddress("glGetMapParameterfvNV");
        this.NV_evaluators_glGetMapParameterivNV_pointer = GLContext.getFunctionAddress("glGetMapParameterivNV");
        this.NV_evaluators_glGetMapAttribParameterfvNV_pointer = GLContext.getFunctionAddress("glGetMapAttribParameterfvNV");
        this.NV_evaluators_glGetMapAttribParameterivNV_pointer = GLContext.getFunctionAddress("glGetMapAttribParameterivNV");
        this.NV_evaluators_glEvalMapsNV_pointer = GLContext.getFunctionAddress("glEvalMapsNV");
        return bl2 & this.NV_evaluators_glMapControlPointsNV_pointer != 0L & this.NV_evaluators_glMapParameterfvNV_pointer != 0L & this.NV_evaluators_glMapParameterivNV_pointer != 0L & this.NV_evaluators_glGetMapParameterfvNV_pointer != 0L & this.NV_evaluators_glGetMapParameterivNV_pointer != 0L & this.NV_evaluators_glGetMapAttribParameterfvNV_pointer != 0L & this.NV_evaluators_glGetMapAttribParameterivNV_pointer != 0L & this.NV_evaluators_glEvalMapsNV_pointer != 0L;
    }

    private boolean NV_explicit_multisample_initNativeFunctionAddresses() {
        this.NV_explicit_multisample_glGetBooleanIndexedvEXT_pointer = GLContext.getFunctionAddress("glGetBooleanIndexedvEXT");
        boolean bl2 = this.NV_explicit_multisample_glGetBooleanIndexedvEXT_pointer != 0L;
        this.NV_explicit_multisample_glGetIntegerIndexedvEXT_pointer = GLContext.getFunctionAddress("glGetIntegerIndexedvEXT");
        this.NV_explicit_multisample_glGetMultisamplefvNV_pointer = GLContext.getFunctionAddress("glGetMultisamplefvNV");
        this.NV_explicit_multisample_glSampleMaskIndexedNV_pointer = GLContext.getFunctionAddress("glSampleMaskIndexedNV");
        this.NV_explicit_multisample_glTexRenderbufferNV_pointer = GLContext.getFunctionAddress("glTexRenderbufferNV");
        return bl2 & this.NV_explicit_multisample_glGetIntegerIndexedvEXT_pointer != 0L & this.NV_explicit_multisample_glGetMultisamplefvNV_pointer != 0L & this.NV_explicit_multisample_glSampleMaskIndexedNV_pointer != 0L & this.NV_explicit_multisample_glTexRenderbufferNV_pointer != 0L;
    }

    private boolean NV_fence_initNativeFunctionAddresses() {
        this.NV_fence_glGenFencesNV_pointer = GLContext.getFunctionAddress("glGenFencesNV");
        boolean bl2 = this.NV_fence_glGenFencesNV_pointer != 0L;
        this.NV_fence_glDeleteFencesNV_pointer = GLContext.getFunctionAddress("glDeleteFencesNV");
        this.NV_fence_glSetFenceNV_pointer = GLContext.getFunctionAddress("glSetFenceNV");
        this.NV_fence_glTestFenceNV_pointer = GLContext.getFunctionAddress("glTestFenceNV");
        this.NV_fence_glFinishFenceNV_pointer = GLContext.getFunctionAddress("glFinishFenceNV");
        this.NV_fence_glIsFenceNV_pointer = GLContext.getFunctionAddress("glIsFenceNV");
        this.NV_fence_glGetFenceivNV_pointer = GLContext.getFunctionAddress("glGetFenceivNV");
        return bl2 & this.NV_fence_glDeleteFencesNV_pointer != 0L & this.NV_fence_glSetFenceNV_pointer != 0L & this.NV_fence_glTestFenceNV_pointer != 0L & this.NV_fence_glFinishFenceNV_pointer != 0L & this.NV_fence_glIsFenceNV_pointer != 0L & this.NV_fence_glGetFenceivNV_pointer != 0L;
    }

    private boolean NV_fragment_program_initNativeFunctionAddresses() {
        this.NV_fragment_program_glProgramNamedParameter4fNV_pointer = GLContext.getFunctionAddress("glProgramNamedParameter4fNV");
        boolean bl2 = this.NV_fragment_program_glProgramNamedParameter4fNV_pointer != 0L;
        this.NV_fragment_program_glProgramNamedParameter4dNV_pointer = GLContext.getFunctionAddress("glProgramNamedParameter4dNV");
        this.NV_fragment_program_glGetProgramNamedParameterfvNV_pointer = GLContext.getFunctionAddress("glGetProgramNamedParameterfvNV");
        this.NV_fragment_program_glGetProgramNamedParameterdvNV_pointer = GLContext.getFunctionAddress("glGetProgramNamedParameterdvNV");
        return bl2 & this.NV_fragment_program_glProgramNamedParameter4dNV_pointer != 0L & this.NV_fragment_program_glGetProgramNamedParameterfvNV_pointer != 0L & this.NV_fragment_program_glGetProgramNamedParameterdvNV_pointer != 0L;
    }

    private boolean NV_framebuffer_multisample_coverage_initNativeFunctionAddresses() {
        this.NV_framebuffer_multisample_coverage_glRenderbufferStorageMultisampleCoverageNV_pointer = GLContext.getFunctionAddress("glRenderbufferStorageMultisampleCoverageNV");
        return this.NV_framebuffer_multisample_coverage_glRenderbufferStorageMultisampleCoverageNV_pointer != 0L;
    }

    private boolean NV_geometry_program4_initNativeFunctionAddresses() {
        this.NV_geometry_program4_glProgramVertexLimitNV_pointer = GLContext.getFunctionAddress("glProgramVertexLimitNV");
        boolean bl2 = this.NV_geometry_program4_glProgramVertexLimitNV_pointer != 0L;
        this.NV_geometry_program4_glFramebufferTextureEXT_pointer = GLContext.getFunctionAddress("glFramebufferTextureEXT");
        this.NV_geometry_program4_glFramebufferTextureLayerEXT_pointer = GLContext.getFunctionAddress("glFramebufferTextureLayerEXT");
        this.NV_geometry_program4_glFramebufferTextureFaceEXT_pointer = GLContext.getFunctionAddress("glFramebufferTextureFaceEXT");
        return bl2 & this.NV_geometry_program4_glFramebufferTextureEXT_pointer != 0L & this.NV_geometry_program4_glFramebufferTextureLayerEXT_pointer != 0L & this.NV_geometry_program4_glFramebufferTextureFaceEXT_pointer != 0L;
    }

    private boolean NV_gpu_program4_initNativeFunctionAddresses() {
        this.NV_gpu_program4_glProgramLocalParameterI4iNV_pointer = GLContext.getFunctionAddress("glProgramLocalParameterI4iNV");
        boolean bl2 = this.NV_gpu_program4_glProgramLocalParameterI4iNV_pointer != 0L;
        this.NV_gpu_program4_glProgramLocalParameterI4ivNV_pointer = GLContext.getFunctionAddress("glProgramLocalParameterI4ivNV");
        this.NV_gpu_program4_glProgramLocalParametersI4ivNV_pointer = GLContext.getFunctionAddress("glProgramLocalParametersI4ivNV");
        this.NV_gpu_program4_glProgramLocalParameterI4uiNV_pointer = GLContext.getFunctionAddress("glProgramLocalParameterI4uiNV");
        this.NV_gpu_program4_glProgramLocalParameterI4uivNV_pointer = GLContext.getFunctionAddress("glProgramLocalParameterI4uivNV");
        this.NV_gpu_program4_glProgramLocalParametersI4uivNV_pointer = GLContext.getFunctionAddress("glProgramLocalParametersI4uivNV");
        this.NV_gpu_program4_glProgramEnvParameterI4iNV_pointer = GLContext.getFunctionAddress("glProgramEnvParameterI4iNV");
        this.NV_gpu_program4_glProgramEnvParameterI4ivNV_pointer = GLContext.getFunctionAddress("glProgramEnvParameterI4ivNV");
        this.NV_gpu_program4_glProgramEnvParametersI4ivNV_pointer = GLContext.getFunctionAddress("glProgramEnvParametersI4ivNV");
        this.NV_gpu_program4_glProgramEnvParameterI4uiNV_pointer = GLContext.getFunctionAddress("glProgramEnvParameterI4uiNV");
        this.NV_gpu_program4_glProgramEnvParameterI4uivNV_pointer = GLContext.getFunctionAddress("glProgramEnvParameterI4uivNV");
        this.NV_gpu_program4_glProgramEnvParametersI4uivNV_pointer = GLContext.getFunctionAddress("glProgramEnvParametersI4uivNV");
        this.NV_gpu_program4_glGetProgramLocalParameterIivNV_pointer = GLContext.getFunctionAddress("glGetProgramLocalParameterIivNV");
        this.NV_gpu_program4_glGetProgramLocalParameterIuivNV_pointer = GLContext.getFunctionAddress("glGetProgramLocalParameterIuivNV");
        this.NV_gpu_program4_glGetProgramEnvParameterIivNV_pointer = GLContext.getFunctionAddress("glGetProgramEnvParameterIivNV");
        this.NV_gpu_program4_glGetProgramEnvParameterIuivNV_pointer = GLContext.getFunctionAddress("glGetProgramEnvParameterIuivNV");
        return bl2 & this.NV_gpu_program4_glProgramLocalParameterI4ivNV_pointer != 0L & this.NV_gpu_program4_glProgramLocalParametersI4ivNV_pointer != 0L & this.NV_gpu_program4_glProgramLocalParameterI4uiNV_pointer != 0L & this.NV_gpu_program4_glProgramLocalParameterI4uivNV_pointer != 0L & this.NV_gpu_program4_glProgramLocalParametersI4uivNV_pointer != 0L & this.NV_gpu_program4_glProgramEnvParameterI4iNV_pointer != 0L & this.NV_gpu_program4_glProgramEnvParameterI4ivNV_pointer != 0L & this.NV_gpu_program4_glProgramEnvParametersI4ivNV_pointer != 0L & this.NV_gpu_program4_glProgramEnvParameterI4uiNV_pointer != 0L & this.NV_gpu_program4_glProgramEnvParameterI4uivNV_pointer != 0L & this.NV_gpu_program4_glProgramEnvParametersI4uivNV_pointer != 0L & this.NV_gpu_program4_glGetProgramLocalParameterIivNV_pointer != 0L & this.NV_gpu_program4_glGetProgramLocalParameterIuivNV_pointer != 0L & this.NV_gpu_program4_glGetProgramEnvParameterIivNV_pointer != 0L & this.NV_gpu_program4_glGetProgramEnvParameterIuivNV_pointer != 0L;
    }

    private boolean NV_gpu_shader5_initNativeFunctionAddresses(Set supported_extensions) {
        this.NV_gpu_shader5_glUniform1i64NV_pointer = GLContext.getFunctionAddress("glUniform1i64NV");
        boolean bl2 = this.NV_gpu_shader5_glUniform1i64NV_pointer != 0L;
        this.NV_gpu_shader5_glUniform2i64NV_pointer = GLContext.getFunctionAddress("glUniform2i64NV");
        this.NV_gpu_shader5_glUniform3i64NV_pointer = GLContext.getFunctionAddress("glUniform3i64NV");
        this.NV_gpu_shader5_glUniform4i64NV_pointer = GLContext.getFunctionAddress("glUniform4i64NV");
        this.NV_gpu_shader5_glUniform1i64vNV_pointer = GLContext.getFunctionAddress("glUniform1i64vNV");
        this.NV_gpu_shader5_glUniform2i64vNV_pointer = GLContext.getFunctionAddress("glUniform2i64vNV");
        this.NV_gpu_shader5_glUniform3i64vNV_pointer = GLContext.getFunctionAddress("glUniform3i64vNV");
        this.NV_gpu_shader5_glUniform4i64vNV_pointer = GLContext.getFunctionAddress("glUniform4i64vNV");
        this.NV_gpu_shader5_glUniform1ui64NV_pointer = GLContext.getFunctionAddress("glUniform1ui64NV");
        this.NV_gpu_shader5_glUniform2ui64NV_pointer = GLContext.getFunctionAddress("glUniform2ui64NV");
        this.NV_gpu_shader5_glUniform3ui64NV_pointer = GLContext.getFunctionAddress("glUniform3ui64NV");
        this.NV_gpu_shader5_glUniform4ui64NV_pointer = GLContext.getFunctionAddress("glUniform4ui64NV");
        this.NV_gpu_shader5_glUniform1ui64vNV_pointer = GLContext.getFunctionAddress("glUniform1ui64vNV");
        this.NV_gpu_shader5_glUniform2ui64vNV_pointer = GLContext.getFunctionAddress("glUniform2ui64vNV");
        this.NV_gpu_shader5_glUniform3ui64vNV_pointer = GLContext.getFunctionAddress("glUniform3ui64vNV");
        this.NV_gpu_shader5_glUniform4ui64vNV_pointer = GLContext.getFunctionAddress("glUniform4ui64vNV");
        this.NV_gpu_shader5_glGetUniformi64vNV_pointer = GLContext.getFunctionAddress("glGetUniformi64vNV");
        this.NV_gpu_shader5_glGetUniformui64vNV_pointer = GLContext.getFunctionAddress("glGetUniformui64vNV");
        return bl2 & this.NV_gpu_shader5_glUniform2i64NV_pointer != 0L & this.NV_gpu_shader5_glUniform3i64NV_pointer != 0L & this.NV_gpu_shader5_glUniform4i64NV_pointer != 0L & this.NV_gpu_shader5_glUniform1i64vNV_pointer != 0L & this.NV_gpu_shader5_glUniform2i64vNV_pointer != 0L & this.NV_gpu_shader5_glUniform3i64vNV_pointer != 0L & this.NV_gpu_shader5_glUniform4i64vNV_pointer != 0L & this.NV_gpu_shader5_glUniform1ui64NV_pointer != 0L & this.NV_gpu_shader5_glUniform2ui64NV_pointer != 0L & this.NV_gpu_shader5_glUniform3ui64NV_pointer != 0L & this.NV_gpu_shader5_glUniform4ui64NV_pointer != 0L & this.NV_gpu_shader5_glUniform1ui64vNV_pointer != 0L & this.NV_gpu_shader5_glUniform2ui64vNV_pointer != 0L & this.NV_gpu_shader5_glUniform3ui64vNV_pointer != 0L & this.NV_gpu_shader5_glUniform4ui64vNV_pointer != 0L & this.NV_gpu_shader5_glGetUniformi64vNV_pointer != 0L & this.NV_gpu_shader5_glGetUniformui64vNV_pointer != 0L & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform1i64NV_pointer = GLContext.getFunctionAddress("glProgramUniform1i64NV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform2i64NV_pointer = GLContext.getFunctionAddress("glProgramUniform2i64NV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform3i64NV_pointer = GLContext.getFunctionAddress("glProgramUniform3i64NV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform4i64NV_pointer = GLContext.getFunctionAddress("glProgramUniform4i64NV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform1i64vNV_pointer = GLContext.getFunctionAddress("glProgramUniform1i64vNV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform2i64vNV_pointer = GLContext.getFunctionAddress("glProgramUniform2i64vNV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform3i64vNV_pointer = GLContext.getFunctionAddress("glProgramUniform3i64vNV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform4i64vNV_pointer = GLContext.getFunctionAddress("glProgramUniform4i64vNV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform1ui64NV_pointer = GLContext.getFunctionAddress("glProgramUniform1ui64NV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform2ui64NV_pointer = GLContext.getFunctionAddress("glProgramUniform2ui64NV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform3ui64NV_pointer = GLContext.getFunctionAddress("glProgramUniform3ui64NV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform4ui64NV_pointer = GLContext.getFunctionAddress("glProgramUniform4ui64NV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform1ui64vNV_pointer = GLContext.getFunctionAddress("glProgramUniform1ui64vNV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform2ui64vNV_pointer = GLContext.getFunctionAddress("glProgramUniform2ui64vNV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform3ui64vNV_pointer = GLContext.getFunctionAddress("glProgramUniform3ui64vNV")) != 0L) & (!supported_extensions.contains("EXT_direct_state_access") || (this.NV_gpu_shader5_glProgramUniform4ui64vNV_pointer = GLContext.getFunctionAddress("glProgramUniform4ui64vNV")) != 0L);
    }

    private boolean NV_half_float_initNativeFunctionAddresses() {
        this.NV_half_float_glVertex2hNV_pointer = GLContext.getFunctionAddress("glVertex2hNV");
        boolean bl2 = this.NV_half_float_glVertex2hNV_pointer != 0L;
        this.NV_half_float_glVertex3hNV_pointer = GLContext.getFunctionAddress("glVertex3hNV");
        this.NV_half_float_glVertex4hNV_pointer = GLContext.getFunctionAddress("glVertex4hNV");
        this.NV_half_float_glNormal3hNV_pointer = GLContext.getFunctionAddress("glNormal3hNV");
        this.NV_half_float_glColor3hNV_pointer = GLContext.getFunctionAddress("glColor3hNV");
        this.NV_half_float_glColor4hNV_pointer = GLContext.getFunctionAddress("glColor4hNV");
        this.NV_half_float_glTexCoord1hNV_pointer = GLContext.getFunctionAddress("glTexCoord1hNV");
        this.NV_half_float_glTexCoord2hNV_pointer = GLContext.getFunctionAddress("glTexCoord2hNV");
        this.NV_half_float_glTexCoord3hNV_pointer = GLContext.getFunctionAddress("glTexCoord3hNV");
        this.NV_half_float_glTexCoord4hNV_pointer = GLContext.getFunctionAddress("glTexCoord4hNV");
        this.NV_half_float_glMultiTexCoord1hNV_pointer = GLContext.getFunctionAddress("glMultiTexCoord1hNV");
        this.NV_half_float_glMultiTexCoord2hNV_pointer = GLContext.getFunctionAddress("glMultiTexCoord2hNV");
        this.NV_half_float_glMultiTexCoord3hNV_pointer = GLContext.getFunctionAddress("glMultiTexCoord3hNV");
        this.NV_half_float_glMultiTexCoord4hNV_pointer = GLContext.getFunctionAddress("glMultiTexCoord4hNV");
        this.NV_half_float_glFogCoordhNV_pointer = GLContext.getFunctionAddress("glFogCoordhNV");
        this.NV_half_float_glSecondaryColor3hNV_pointer = GLContext.getFunctionAddress("glSecondaryColor3hNV");
        boolean bl3 = bl2 & this.NV_half_float_glVertex3hNV_pointer != 0L & this.NV_half_float_glVertex4hNV_pointer != 0L & this.NV_half_float_glNormal3hNV_pointer != 0L & this.NV_half_float_glColor3hNV_pointer != 0L & this.NV_half_float_glColor4hNV_pointer != 0L & this.NV_half_float_glTexCoord1hNV_pointer != 0L & this.NV_half_float_glTexCoord2hNV_pointer != 0L & this.NV_half_float_glTexCoord3hNV_pointer != 0L & this.NV_half_float_glTexCoord4hNV_pointer != 0L & this.NV_half_float_glMultiTexCoord1hNV_pointer != 0L & this.NV_half_float_glMultiTexCoord2hNV_pointer != 0L & this.NV_half_float_glMultiTexCoord3hNV_pointer != 0L & this.NV_half_float_glMultiTexCoord4hNV_pointer != 0L & this.NV_half_float_glFogCoordhNV_pointer != 0L & this.NV_half_float_glSecondaryColor3hNV_pointer != 0L;
        this.NV_half_float_glVertexWeighthNV_pointer = GLContext.getFunctionAddress("glVertexWeighthNV");
        if (this.NV_half_float_glVertexWeighthNV_pointer == 0L) {
            // empty if block
        }
        boolean bl4 = bl3 & true;
        this.NV_half_float_glVertexAttrib1hNV_pointer = GLContext.getFunctionAddress("glVertexAttrib1hNV");
        if (this.NV_half_float_glVertexAttrib1hNV_pointer == 0L) {
            // empty if block
        }
        boolean bl5 = bl4 & true;
        this.NV_half_float_glVertexAttrib2hNV_pointer = GLContext.getFunctionAddress("glVertexAttrib2hNV");
        if (this.NV_half_float_glVertexAttrib2hNV_pointer == 0L) {
            // empty if block
        }
        boolean bl6 = bl5 & true;
        this.NV_half_float_glVertexAttrib3hNV_pointer = GLContext.getFunctionAddress("glVertexAttrib3hNV");
        if (this.NV_half_float_glVertexAttrib3hNV_pointer == 0L) {
            // empty if block
        }
        boolean bl7 = bl6 & true;
        this.NV_half_float_glVertexAttrib4hNV_pointer = GLContext.getFunctionAddress("glVertexAttrib4hNV");
        if (this.NV_half_float_glVertexAttrib4hNV_pointer == 0L) {
            // empty if block
        }
        boolean bl8 = bl7 & true;
        this.NV_half_float_glVertexAttribs1hvNV_pointer = GLContext.getFunctionAddress("glVertexAttribs1hvNV");
        if (this.NV_half_float_glVertexAttribs1hvNV_pointer == 0L) {
            // empty if block
        }
        boolean bl9 = bl8 & true;
        this.NV_half_float_glVertexAttribs2hvNV_pointer = GLContext.getFunctionAddress("glVertexAttribs2hvNV");
        if (this.NV_half_float_glVertexAttribs2hvNV_pointer == 0L) {
            // empty if block
        }
        boolean bl10 = bl9 & true;
        this.NV_half_float_glVertexAttribs3hvNV_pointer = GLContext.getFunctionAddress("glVertexAttribs3hvNV");
        if (this.NV_half_float_glVertexAttribs3hvNV_pointer == 0L) {
            // empty if block
        }
        boolean bl11 = bl10 & true;
        this.NV_half_float_glVertexAttribs4hvNV_pointer = GLContext.getFunctionAddress("glVertexAttribs4hvNV");
        if (this.NV_half_float_glVertexAttribs4hvNV_pointer == 0L) {
            // empty if block
        }
        return bl11 & true;
    }

    private boolean NV_occlusion_query_initNativeFunctionAddresses() {
        this.NV_occlusion_query_glGenOcclusionQueriesNV_pointer = GLContext.getFunctionAddress("glGenOcclusionQueriesNV");
        boolean bl2 = this.NV_occlusion_query_glGenOcclusionQueriesNV_pointer != 0L;
        this.NV_occlusion_query_glDeleteOcclusionQueriesNV_pointer = GLContext.getFunctionAddress("glDeleteOcclusionQueriesNV");
        this.NV_occlusion_query_glIsOcclusionQueryNV_pointer = GLContext.getFunctionAddress("glIsOcclusionQueryNV");
        this.NV_occlusion_query_glBeginOcclusionQueryNV_pointer = GLContext.getFunctionAddress("glBeginOcclusionQueryNV");
        this.NV_occlusion_query_glEndOcclusionQueryNV_pointer = GLContext.getFunctionAddress("glEndOcclusionQueryNV");
        this.NV_occlusion_query_glGetOcclusionQueryuivNV_pointer = GLContext.getFunctionAddress("glGetOcclusionQueryuivNV");
        this.NV_occlusion_query_glGetOcclusionQueryivNV_pointer = GLContext.getFunctionAddress("glGetOcclusionQueryivNV");
        return bl2 & this.NV_occlusion_query_glDeleteOcclusionQueriesNV_pointer != 0L & this.NV_occlusion_query_glIsOcclusionQueryNV_pointer != 0L & this.NV_occlusion_query_glBeginOcclusionQueryNV_pointer != 0L & this.NV_occlusion_query_glEndOcclusionQueryNV_pointer != 0L & this.NV_occlusion_query_glGetOcclusionQueryuivNV_pointer != 0L & this.NV_occlusion_query_glGetOcclusionQueryivNV_pointer != 0L;
    }

    private boolean NV_parameter_buffer_object_initNativeFunctionAddresses() {
        this.NV_parameter_buffer_object_glProgramBufferParametersfvNV_pointer = GLContext.getFunctionAddress("glProgramBufferParametersfvNV");
        boolean bl2 = this.NV_parameter_buffer_object_glProgramBufferParametersfvNV_pointer != 0L;
        this.NV_parameter_buffer_object_glProgramBufferParametersIivNV_pointer = GLContext.getFunctionAddress("glProgramBufferParametersIivNV");
        this.NV_parameter_buffer_object_glProgramBufferParametersIuivNV_pointer = GLContext.getFunctionAddress("glProgramBufferParametersIuivNV");
        return bl2 & this.NV_parameter_buffer_object_glProgramBufferParametersIivNV_pointer != 0L & this.NV_parameter_buffer_object_glProgramBufferParametersIuivNV_pointer != 0L;
    }

    private boolean NV_pixel_data_range_initNativeFunctionAddresses() {
        this.NV_pixel_data_range_glPixelDataRangeNV_pointer = GLContext.getFunctionAddress("glPixelDataRangeNV");
        boolean bl2 = this.NV_pixel_data_range_glPixelDataRangeNV_pointer != 0L;
        this.NV_pixel_data_range_glFlushPixelDataRangeNV_pointer = GLContext.getFunctionAddress("glFlushPixelDataRangeNV");
        return bl2 & this.NV_pixel_data_range_glFlushPixelDataRangeNV_pointer != 0L;
    }

    private boolean NV_point_sprite_initNativeFunctionAddresses() {
        this.NV_point_sprite_glPointParameteriNV_pointer = GLContext.getFunctionAddress("glPointParameteriNV");
        boolean bl2 = this.NV_point_sprite_glPointParameteriNV_pointer != 0L;
        this.NV_point_sprite_glPointParameterivNV_pointer = GLContext.getFunctionAddress("glPointParameterivNV");
        return bl2 & this.NV_point_sprite_glPointParameterivNV_pointer != 0L;
    }

    private boolean NV_primitive_restart_initNativeFunctionAddresses() {
        this.NV_primitive_restart_glPrimitiveRestartNV_pointer = GLContext.getFunctionAddress("glPrimitiveRestartNV");
        boolean bl2 = this.NV_primitive_restart_glPrimitiveRestartNV_pointer != 0L;
        this.NV_primitive_restart_glPrimitiveRestartIndexNV_pointer = GLContext.getFunctionAddress("glPrimitiveRestartIndexNV");
        return bl2 & this.NV_primitive_restart_glPrimitiveRestartIndexNV_pointer != 0L;
    }

    private boolean NV_program_initNativeFunctionAddresses() {
        this.NV_program_glLoadProgramNV_pointer = GLContext.getFunctionAddress("glLoadProgramNV");
        boolean bl2 = this.NV_program_glLoadProgramNV_pointer != 0L;
        this.NV_program_glBindProgramNV_pointer = GLContext.getFunctionAddress("glBindProgramNV");
        this.NV_program_glDeleteProgramsNV_pointer = GLContext.getFunctionAddress("glDeleteProgramsNV");
        this.NV_program_glGenProgramsNV_pointer = GLContext.getFunctionAddress("glGenProgramsNV");
        this.NV_program_glGetProgramivNV_pointer = GLContext.getFunctionAddress("glGetProgramivNV");
        this.NV_program_glGetProgramStringNV_pointer = GLContext.getFunctionAddress("glGetProgramStringNV");
        this.NV_program_glIsProgramNV_pointer = GLContext.getFunctionAddress("glIsProgramNV");
        this.NV_program_glAreProgramsResidentNV_pointer = GLContext.getFunctionAddress("glAreProgramsResidentNV");
        this.NV_program_glRequestResidentProgramsNV_pointer = GLContext.getFunctionAddress("glRequestResidentProgramsNV");
        return bl2 & this.NV_program_glBindProgramNV_pointer != 0L & this.NV_program_glDeleteProgramsNV_pointer != 0L & this.NV_program_glGenProgramsNV_pointer != 0L & this.NV_program_glGetProgramivNV_pointer != 0L & this.NV_program_glGetProgramStringNV_pointer != 0L & this.NV_program_glIsProgramNV_pointer != 0L & this.NV_program_glAreProgramsResidentNV_pointer != 0L & this.NV_program_glRequestResidentProgramsNV_pointer != 0L;
    }

    private boolean NV_register_combiners_initNativeFunctionAddresses() {
        this.NV_register_combiners_glCombinerParameterfNV_pointer = GLContext.getFunctionAddress("glCombinerParameterfNV");
        boolean bl2 = this.NV_register_combiners_glCombinerParameterfNV_pointer != 0L;
        this.NV_register_combiners_glCombinerParameterfvNV_pointer = GLContext.getFunctionAddress("glCombinerParameterfvNV");
        this.NV_register_combiners_glCombinerParameteriNV_pointer = GLContext.getFunctionAddress("glCombinerParameteriNV");
        this.NV_register_combiners_glCombinerParameterivNV_pointer = GLContext.getFunctionAddress("glCombinerParameterivNV");
        this.NV_register_combiners_glCombinerInputNV_pointer = GLContext.getFunctionAddress("glCombinerInputNV");
        this.NV_register_combiners_glCombinerOutputNV_pointer = GLContext.getFunctionAddress("glCombinerOutputNV");
        this.NV_register_combiners_glFinalCombinerInputNV_pointer = GLContext.getFunctionAddress("glFinalCombinerInputNV");
        this.NV_register_combiners_glGetCombinerInputParameterfvNV_pointer = GLContext.getFunctionAddress("glGetCombinerInputParameterfvNV");
        this.NV_register_combiners_glGetCombinerInputParameterivNV_pointer = GLContext.getFunctionAddress("glGetCombinerInputParameterivNV");
        this.NV_register_combiners_glGetCombinerOutputParameterfvNV_pointer = GLContext.getFunctionAddress("glGetCombinerOutputParameterfvNV");
        this.NV_register_combiners_glGetCombinerOutputParameterivNV_pointer = GLContext.getFunctionAddress("glGetCombinerOutputParameterivNV");
        this.NV_register_combiners_glGetFinalCombinerInputParameterfvNV_pointer = GLContext.getFunctionAddress("glGetFinalCombinerInputParameterfvNV");
        this.NV_register_combiners_glGetFinalCombinerInputParameterivNV_pointer = GLContext.getFunctionAddress("glGetFinalCombinerInputParameterivNV");
        return bl2 & this.NV_register_combiners_glCombinerParameterfvNV_pointer != 0L & this.NV_register_combiners_glCombinerParameteriNV_pointer != 0L & this.NV_register_combiners_glCombinerParameterivNV_pointer != 0L & this.NV_register_combiners_glCombinerInputNV_pointer != 0L & this.NV_register_combiners_glCombinerOutputNV_pointer != 0L & this.NV_register_combiners_glFinalCombinerInputNV_pointer != 0L & this.NV_register_combiners_glGetCombinerInputParameterfvNV_pointer != 0L & this.NV_register_combiners_glGetCombinerInputParameterivNV_pointer != 0L & this.NV_register_combiners_glGetCombinerOutputParameterfvNV_pointer != 0L & this.NV_register_combiners_glGetCombinerOutputParameterivNV_pointer != 0L & this.NV_register_combiners_glGetFinalCombinerInputParameterfvNV_pointer != 0L & this.NV_register_combiners_glGetFinalCombinerInputParameterivNV_pointer != 0L;
    }

    private boolean NV_register_combiners2_initNativeFunctionAddresses() {
        this.NV_register_combiners2_glCombinerStageParameterfvNV_pointer = GLContext.getFunctionAddress("glCombinerStageParameterfvNV");
        boolean bl2 = this.NV_register_combiners2_glCombinerStageParameterfvNV_pointer != 0L;
        this.NV_register_combiners2_glGetCombinerStageParameterfvNV_pointer = GLContext.getFunctionAddress("glGetCombinerStageParameterfvNV");
        return bl2 & this.NV_register_combiners2_glGetCombinerStageParameterfvNV_pointer != 0L;
    }

    private boolean NV_shader_buffer_load_initNativeFunctionAddresses() {
        this.NV_shader_buffer_load_glMakeBufferResidentNV_pointer = GLContext.getFunctionAddress("glMakeBufferResidentNV");
        boolean bl2 = this.NV_shader_buffer_load_glMakeBufferResidentNV_pointer != 0L;
        this.NV_shader_buffer_load_glMakeBufferNonResidentNV_pointer = GLContext.getFunctionAddress("glMakeBufferNonResidentNV");
        this.NV_shader_buffer_load_glIsBufferResidentNV_pointer = GLContext.getFunctionAddress("glIsBufferResidentNV");
        this.NV_shader_buffer_load_glMakeNamedBufferResidentNV_pointer = GLContext.getFunctionAddress("glMakeNamedBufferResidentNV");
        this.NV_shader_buffer_load_glMakeNamedBufferNonResidentNV_pointer = GLContext.getFunctionAddress("glMakeNamedBufferNonResidentNV");
        this.NV_shader_buffer_load_glIsNamedBufferResidentNV_pointer = GLContext.getFunctionAddress("glIsNamedBufferResidentNV");
        this.NV_shader_buffer_load_glGetBufferParameterui64vNV_pointer = GLContext.getFunctionAddress("glGetBufferParameterui64vNV");
        this.NV_shader_buffer_load_glGetNamedBufferParameterui64vNV_pointer = GLContext.getFunctionAddress("glGetNamedBufferParameterui64vNV");
        this.NV_shader_buffer_load_glGetIntegerui64vNV_pointer = GLContext.getFunctionAddress("glGetIntegerui64vNV");
        this.NV_shader_buffer_load_glUniformui64NV_pointer = GLContext.getFunctionAddress("glUniformui64NV");
        this.NV_shader_buffer_load_glUniformui64vNV_pointer = GLContext.getFunctionAddress("glUniformui64vNV");
        this.NV_shader_buffer_load_glGetUniformui64vNV_pointer = GLContext.getFunctionAddress("glGetUniformui64vNV");
        this.NV_shader_buffer_load_glProgramUniformui64NV_pointer = GLContext.getFunctionAddress("glProgramUniformui64NV");
        this.NV_shader_buffer_load_glProgramUniformui64vNV_pointer = GLContext.getFunctionAddress("glProgramUniformui64vNV");
        return bl2 & this.NV_shader_buffer_load_glMakeBufferNonResidentNV_pointer != 0L & this.NV_shader_buffer_load_glIsBufferResidentNV_pointer != 0L & this.NV_shader_buffer_load_glMakeNamedBufferResidentNV_pointer != 0L & this.NV_shader_buffer_load_glMakeNamedBufferNonResidentNV_pointer != 0L & this.NV_shader_buffer_load_glIsNamedBufferResidentNV_pointer != 0L & this.NV_shader_buffer_load_glGetBufferParameterui64vNV_pointer != 0L & this.NV_shader_buffer_load_glGetNamedBufferParameterui64vNV_pointer != 0L & this.NV_shader_buffer_load_glGetIntegerui64vNV_pointer != 0L & this.NV_shader_buffer_load_glUniformui64NV_pointer != 0L & this.NV_shader_buffer_load_glUniformui64vNV_pointer != 0L & this.NV_shader_buffer_load_glGetUniformui64vNV_pointer != 0L & this.NV_shader_buffer_load_glProgramUniformui64NV_pointer != 0L & this.NV_shader_buffer_load_glProgramUniformui64vNV_pointer != 0L;
    }

    private boolean NV_texture_barrier_initNativeFunctionAddresses() {
        this.NV_texture_barrier_glTextureBarrierNV_pointer = GLContext.getFunctionAddress("glTextureBarrierNV");
        return this.NV_texture_barrier_glTextureBarrierNV_pointer != 0L;
    }

    private boolean NV_transform_feedback_initNativeFunctionAddresses() {
        this.NV_transform_feedback_glBindBufferRangeNV_pointer = GLContext.getFunctionAddress("glBindBufferRangeNV");
        boolean bl2 = this.NV_transform_feedback_glBindBufferRangeNV_pointer != 0L;
        this.NV_transform_feedback_glBindBufferOffsetNV_pointer = GLContext.getFunctionAddress("glBindBufferOffsetNV");
        this.NV_transform_feedback_glBindBufferBaseNV_pointer = GLContext.getFunctionAddress("glBindBufferBaseNV");
        this.NV_transform_feedback_glTransformFeedbackAttribsNV_pointer = GLContext.getFunctionAddress("glTransformFeedbackAttribsNV");
        this.NV_transform_feedback_glTransformFeedbackVaryingsNV_pointer = GLContext.getFunctionAddress("glTransformFeedbackVaryingsNV");
        this.NV_transform_feedback_glBeginTransformFeedbackNV_pointer = GLContext.getFunctionAddress("glBeginTransformFeedbackNV");
        this.NV_transform_feedback_glEndTransformFeedbackNV_pointer = GLContext.getFunctionAddress("glEndTransformFeedbackNV");
        this.NV_transform_feedback_glGetVaryingLocationNV_pointer = GLContext.getFunctionAddress("glGetVaryingLocationNV");
        this.NV_transform_feedback_glGetActiveVaryingNV_pointer = GLContext.getFunctionAddress("glGetActiveVaryingNV");
        this.NV_transform_feedback_glActiveVaryingNV_pointer = GLContext.getFunctionAddress("glActiveVaryingNV");
        this.NV_transform_feedback_glGetTransformFeedbackVaryingNV_pointer = GLContext.getFunctionAddress("glGetTransformFeedbackVaryingNV");
        return bl2 & this.NV_transform_feedback_glBindBufferOffsetNV_pointer != 0L & this.NV_transform_feedback_glBindBufferBaseNV_pointer != 0L & this.NV_transform_feedback_glTransformFeedbackAttribsNV_pointer != 0L & this.NV_transform_feedback_glTransformFeedbackVaryingsNV_pointer != 0L & this.NV_transform_feedback_glBeginTransformFeedbackNV_pointer != 0L & this.NV_transform_feedback_glEndTransformFeedbackNV_pointer != 0L & this.NV_transform_feedback_glGetVaryingLocationNV_pointer != 0L & this.NV_transform_feedback_glGetActiveVaryingNV_pointer != 0L & this.NV_transform_feedback_glActiveVaryingNV_pointer != 0L & this.NV_transform_feedback_glGetTransformFeedbackVaryingNV_pointer != 0L;
    }

    private boolean NV_transform_feedback2_initNativeFunctionAddresses() {
        this.NV_transform_feedback2_glBindTransformFeedbackNV_pointer = GLContext.getFunctionAddress("glBindTransformFeedbackNV");
        boolean bl2 = this.NV_transform_feedback2_glBindTransformFeedbackNV_pointer != 0L;
        this.NV_transform_feedback2_glDeleteTransformFeedbacksNV_pointer = GLContext.getFunctionAddress("glDeleteTransformFeedbacksNV");
        this.NV_transform_feedback2_glGenTransformFeedbacksNV_pointer = GLContext.getFunctionAddress("glGenTransformFeedbacksNV");
        this.NV_transform_feedback2_glIsTransformFeedbackNV_pointer = GLContext.getFunctionAddress("glIsTransformFeedbackNV");
        this.NV_transform_feedback2_glPauseTransformFeedbackNV_pointer = GLContext.getFunctionAddress("glPauseTransformFeedbackNV");
        this.NV_transform_feedback2_glResumeTransformFeedbackNV_pointer = GLContext.getFunctionAddress("glResumeTransformFeedbackNV");
        this.NV_transform_feedback2_glDrawTransformFeedbackNV_pointer = GLContext.getFunctionAddress("glDrawTransformFeedbackNV");
        return bl2 & this.NV_transform_feedback2_glDeleteTransformFeedbacksNV_pointer != 0L & this.NV_transform_feedback2_glGenTransformFeedbacksNV_pointer != 0L & this.NV_transform_feedback2_glIsTransformFeedbackNV_pointer != 0L & this.NV_transform_feedback2_glPauseTransformFeedbackNV_pointer != 0L & this.NV_transform_feedback2_glResumeTransformFeedbackNV_pointer != 0L & this.NV_transform_feedback2_glDrawTransformFeedbackNV_pointer != 0L;
    }

    private boolean NV_vertex_array_range_initNativeFunctionAddresses() {
        this.NV_vertex_array_range_glVertexArrayRangeNV_pointer = GLContext.getFunctionAddress("glVertexArrayRangeNV");
        boolean bl2 = this.NV_vertex_array_range_glVertexArrayRangeNV_pointer != 0L;
        this.NV_vertex_array_range_glFlushVertexArrayRangeNV_pointer = GLContext.getFunctionAddress("glFlushVertexArrayRangeNV");
        this.NV_vertex_array_range_glAllocateMemoryNV_pointer = GLContext.getPlatformSpecificFunctionAddress("gl", new String[]{"Windows", "Linux"}, new String[]{"wgl", "glX"}, "glAllocateMemoryNV");
        this.NV_vertex_array_range_glFreeMemoryNV_pointer = GLContext.getPlatformSpecificFunctionAddress("gl", new String[]{"Windows", "Linux"}, new String[]{"wgl", "glX"}, "glFreeMemoryNV");
        return bl2 & this.NV_vertex_array_range_glFlushVertexArrayRangeNV_pointer != 0L & this.NV_vertex_array_range_glAllocateMemoryNV_pointer != 0L & this.NV_vertex_array_range_glFreeMemoryNV_pointer != 0L;
    }

    private boolean NV_vertex_attrib_integer_64bit_initNativeFunctionAddresses(Set supported_extensions) {
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL1i64NV_pointer = GLContext.getFunctionAddress("glVertexAttribL1i64NV");
        boolean bl2 = this.NV_vertex_attrib_integer_64bit_glVertexAttribL1i64NV_pointer != 0L;
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL2i64NV_pointer = GLContext.getFunctionAddress("glVertexAttribL2i64NV");
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL3i64NV_pointer = GLContext.getFunctionAddress("glVertexAttribL3i64NV");
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL4i64NV_pointer = GLContext.getFunctionAddress("glVertexAttribL4i64NV");
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL1i64vNV_pointer = GLContext.getFunctionAddress("glVertexAttribL1i64vNV");
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL2i64vNV_pointer = GLContext.getFunctionAddress("glVertexAttribL2i64vNV");
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL3i64vNV_pointer = GLContext.getFunctionAddress("glVertexAttribL3i64vNV");
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL4i64vNV_pointer = GLContext.getFunctionAddress("glVertexAttribL4i64vNV");
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL1ui64NV_pointer = GLContext.getFunctionAddress("glVertexAttribL1ui64NV");
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL2ui64NV_pointer = GLContext.getFunctionAddress("glVertexAttribL2ui64NV");
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL3ui64NV_pointer = GLContext.getFunctionAddress("glVertexAttribL3ui64NV");
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL4ui64NV_pointer = GLContext.getFunctionAddress("glVertexAttribL4ui64NV");
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL1ui64vNV_pointer = GLContext.getFunctionAddress("glVertexAttribL1ui64vNV");
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL2ui64vNV_pointer = GLContext.getFunctionAddress("glVertexAttribL2ui64vNV");
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL3ui64vNV_pointer = GLContext.getFunctionAddress("glVertexAttribL3ui64vNV");
        this.NV_vertex_attrib_integer_64bit_glVertexAttribL4ui64vNV_pointer = GLContext.getFunctionAddress("glVertexAttribL4ui64vNV");
        this.NV_vertex_attrib_integer_64bit_glGetVertexAttribLi64vNV_pointer = GLContext.getFunctionAddress("glGetVertexAttribLi64vNV");
        this.NV_vertex_attrib_integer_64bit_glGetVertexAttribLui64vNV_pointer = GLContext.getFunctionAddress("glGetVertexAttribLui64vNV");
        return bl2 & this.NV_vertex_attrib_integer_64bit_glVertexAttribL2i64NV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glVertexAttribL3i64NV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glVertexAttribL4i64NV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glVertexAttribL1i64vNV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glVertexAttribL2i64vNV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glVertexAttribL3i64vNV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glVertexAttribL4i64vNV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glVertexAttribL1ui64NV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glVertexAttribL2ui64NV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glVertexAttribL3ui64NV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glVertexAttribL4ui64NV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glVertexAttribL1ui64vNV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glVertexAttribL2ui64vNV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glVertexAttribL3ui64vNV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glVertexAttribL4ui64vNV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glGetVertexAttribLi64vNV_pointer != 0L & this.NV_vertex_attrib_integer_64bit_glGetVertexAttribLui64vNV_pointer != 0L & (!supported_extensions.contains("NV_vertex_buffer_unified_memory") || (this.NV_vertex_attrib_integer_64bit_glVertexAttribLFormatNV_pointer = GLContext.getFunctionAddress("glVertexAttribLFormatNV")) != 0L);
    }

    private boolean NV_vertex_buffer_unified_memory_initNativeFunctionAddresses() {
        this.NV_vertex_buffer_unified_memory_glBufferAddressRangeNV_pointer = GLContext.getFunctionAddress("glBufferAddressRangeNV");
        boolean bl2 = this.NV_vertex_buffer_unified_memory_glBufferAddressRangeNV_pointer != 0L;
        this.NV_vertex_buffer_unified_memory_glVertexFormatNV_pointer = GLContext.getFunctionAddress("glVertexFormatNV");
        this.NV_vertex_buffer_unified_memory_glNormalFormatNV_pointer = GLContext.getFunctionAddress("glNormalFormatNV");
        this.NV_vertex_buffer_unified_memory_glColorFormatNV_pointer = GLContext.getFunctionAddress("glColorFormatNV");
        this.NV_vertex_buffer_unified_memory_glIndexFormatNV_pointer = GLContext.getFunctionAddress("glIndexFormatNV");
        this.NV_vertex_buffer_unified_memory_glTexCoordFormatNV_pointer = GLContext.getFunctionAddress("glTexCoordFormatNV");
        this.NV_vertex_buffer_unified_memory_glEdgeFlagFormatNV_pointer = GLContext.getFunctionAddress("glEdgeFlagFormatNV");
        this.NV_vertex_buffer_unified_memory_glSecondaryColorFormatNV_pointer = GLContext.getFunctionAddress("glSecondaryColorFormatNV");
        this.NV_vertex_buffer_unified_memory_glFogCoordFormatNV_pointer = GLContext.getFunctionAddress("glFogCoordFormatNV");
        this.NV_vertex_buffer_unified_memory_glVertexAttribFormatNV_pointer = GLContext.getFunctionAddress("glVertexAttribFormatNV");
        this.NV_vertex_buffer_unified_memory_glVertexAttribIFormatNV_pointer = GLContext.getFunctionAddress("glVertexAttribIFormatNV");
        this.NV_vertex_buffer_unified_memory_glGetIntegerui64i_vNV_pointer = GLContext.getFunctionAddress("glGetIntegerui64i_vNV");
        return bl2 & this.NV_vertex_buffer_unified_memory_glVertexFormatNV_pointer != 0L & this.NV_vertex_buffer_unified_memory_glNormalFormatNV_pointer != 0L & this.NV_vertex_buffer_unified_memory_glColorFormatNV_pointer != 0L & this.NV_vertex_buffer_unified_memory_glIndexFormatNV_pointer != 0L & this.NV_vertex_buffer_unified_memory_glTexCoordFormatNV_pointer != 0L & this.NV_vertex_buffer_unified_memory_glEdgeFlagFormatNV_pointer != 0L & this.NV_vertex_buffer_unified_memory_glSecondaryColorFormatNV_pointer != 0L & this.NV_vertex_buffer_unified_memory_glFogCoordFormatNV_pointer != 0L & this.NV_vertex_buffer_unified_memory_glVertexAttribFormatNV_pointer != 0L & this.NV_vertex_buffer_unified_memory_glVertexAttribIFormatNV_pointer != 0L & this.NV_vertex_buffer_unified_memory_glGetIntegerui64i_vNV_pointer != 0L;
    }

    private boolean NV_vertex_program_initNativeFunctionAddresses() {
        this.NV_vertex_program_glExecuteProgramNV_pointer = GLContext.getFunctionAddress("glExecuteProgramNV");
        boolean bl2 = this.NV_vertex_program_glExecuteProgramNV_pointer != 0L;
        this.NV_vertex_program_glGetProgramParameterfvNV_pointer = GLContext.getFunctionAddress("glGetProgramParameterfvNV");
        this.NV_vertex_program_glGetProgramParameterdvNV_pointer = GLContext.getFunctionAddress("glGetProgramParameterdvNV");
        this.NV_vertex_program_glGetTrackMatrixivNV_pointer = GLContext.getFunctionAddress("glGetTrackMatrixivNV");
        this.NV_vertex_program_glGetVertexAttribfvNV_pointer = GLContext.getFunctionAddress("glGetVertexAttribfvNV");
        this.NV_vertex_program_glGetVertexAttribdvNV_pointer = GLContext.getFunctionAddress("glGetVertexAttribdvNV");
        this.NV_vertex_program_glGetVertexAttribivNV_pointer = GLContext.getFunctionAddress("glGetVertexAttribivNV");
        this.NV_vertex_program_glGetVertexAttribPointervNV_pointer = GLContext.getFunctionAddress("glGetVertexAttribPointervNV");
        this.NV_vertex_program_glProgramParameter4fNV_pointer = GLContext.getFunctionAddress("glProgramParameter4fNV");
        this.NV_vertex_program_glProgramParameter4dNV_pointer = GLContext.getFunctionAddress("glProgramParameter4dNV");
        this.NV_vertex_program_glProgramParameters4fvNV_pointer = GLContext.getFunctionAddress("glProgramParameters4fvNV");
        this.NV_vertex_program_glProgramParameters4dvNV_pointer = GLContext.getFunctionAddress("glProgramParameters4dvNV");
        this.NV_vertex_program_glTrackMatrixNV_pointer = GLContext.getFunctionAddress("glTrackMatrixNV");
        this.NV_vertex_program_glVertexAttribPointerNV_pointer = GLContext.getFunctionAddress("glVertexAttribPointerNV");
        this.NV_vertex_program_glVertexAttrib1sNV_pointer = GLContext.getFunctionAddress("glVertexAttrib1sNV");
        this.NV_vertex_program_glVertexAttrib1fNV_pointer = GLContext.getFunctionAddress("glVertexAttrib1fNV");
        this.NV_vertex_program_glVertexAttrib1dNV_pointer = GLContext.getFunctionAddress("glVertexAttrib1dNV");
        this.NV_vertex_program_glVertexAttrib2sNV_pointer = GLContext.getFunctionAddress("glVertexAttrib2sNV");
        this.NV_vertex_program_glVertexAttrib2fNV_pointer = GLContext.getFunctionAddress("glVertexAttrib2fNV");
        this.NV_vertex_program_glVertexAttrib2dNV_pointer = GLContext.getFunctionAddress("glVertexAttrib2dNV");
        this.NV_vertex_program_glVertexAttrib3sNV_pointer = GLContext.getFunctionAddress("glVertexAttrib3sNV");
        this.NV_vertex_program_glVertexAttrib3fNV_pointer = GLContext.getFunctionAddress("glVertexAttrib3fNV");
        this.NV_vertex_program_glVertexAttrib3dNV_pointer = GLContext.getFunctionAddress("glVertexAttrib3dNV");
        this.NV_vertex_program_glVertexAttrib4sNV_pointer = GLContext.getFunctionAddress("glVertexAttrib4sNV");
        this.NV_vertex_program_glVertexAttrib4fNV_pointer = GLContext.getFunctionAddress("glVertexAttrib4fNV");
        this.NV_vertex_program_glVertexAttrib4dNV_pointer = GLContext.getFunctionAddress("glVertexAttrib4dNV");
        this.NV_vertex_program_glVertexAttrib4ubNV_pointer = GLContext.getFunctionAddress("glVertexAttrib4ubNV");
        this.NV_vertex_program_glVertexAttribs1svNV_pointer = GLContext.getFunctionAddress("glVertexAttribs1svNV");
        this.NV_vertex_program_glVertexAttribs1fvNV_pointer = GLContext.getFunctionAddress("glVertexAttribs1fvNV");
        this.NV_vertex_program_glVertexAttribs1dvNV_pointer = GLContext.getFunctionAddress("glVertexAttribs1dvNV");
        this.NV_vertex_program_glVertexAttribs2svNV_pointer = GLContext.getFunctionAddress("glVertexAttribs2svNV");
        this.NV_vertex_program_glVertexAttribs2fvNV_pointer = GLContext.getFunctionAddress("glVertexAttribs2fvNV");
        this.NV_vertex_program_glVertexAttribs2dvNV_pointer = GLContext.getFunctionAddress("glVertexAttribs2dvNV");
        this.NV_vertex_program_glVertexAttribs3svNV_pointer = GLContext.getFunctionAddress("glVertexAttribs3svNV");
        this.NV_vertex_program_glVertexAttribs3fvNV_pointer = GLContext.getFunctionAddress("glVertexAttribs3fvNV");
        this.NV_vertex_program_glVertexAttribs3dvNV_pointer = GLContext.getFunctionAddress("glVertexAttribs3dvNV");
        this.NV_vertex_program_glVertexAttribs4svNV_pointer = GLContext.getFunctionAddress("glVertexAttribs4svNV");
        this.NV_vertex_program_glVertexAttribs4fvNV_pointer = GLContext.getFunctionAddress("glVertexAttribs4fvNV");
        this.NV_vertex_program_glVertexAttribs4dvNV_pointer = GLContext.getFunctionAddress("glVertexAttribs4dvNV");
        return bl2 & this.NV_vertex_program_glGetProgramParameterfvNV_pointer != 0L & this.NV_vertex_program_glGetProgramParameterdvNV_pointer != 0L & this.NV_vertex_program_glGetTrackMatrixivNV_pointer != 0L & this.NV_vertex_program_glGetVertexAttribfvNV_pointer != 0L & this.NV_vertex_program_glGetVertexAttribdvNV_pointer != 0L & this.NV_vertex_program_glGetVertexAttribivNV_pointer != 0L & this.NV_vertex_program_glGetVertexAttribPointervNV_pointer != 0L & this.NV_vertex_program_glProgramParameter4fNV_pointer != 0L & this.NV_vertex_program_glProgramParameter4dNV_pointer != 0L & this.NV_vertex_program_glProgramParameters4fvNV_pointer != 0L & this.NV_vertex_program_glProgramParameters4dvNV_pointer != 0L & this.NV_vertex_program_glTrackMatrixNV_pointer != 0L & this.NV_vertex_program_glVertexAttribPointerNV_pointer != 0L & this.NV_vertex_program_glVertexAttrib1sNV_pointer != 0L & this.NV_vertex_program_glVertexAttrib1fNV_pointer != 0L & this.NV_vertex_program_glVertexAttrib1dNV_pointer != 0L & this.NV_vertex_program_glVertexAttrib2sNV_pointer != 0L & this.NV_vertex_program_glVertexAttrib2fNV_pointer != 0L & this.NV_vertex_program_glVertexAttrib2dNV_pointer != 0L & this.NV_vertex_program_glVertexAttrib3sNV_pointer != 0L & this.NV_vertex_program_glVertexAttrib3fNV_pointer != 0L & this.NV_vertex_program_glVertexAttrib3dNV_pointer != 0L & this.NV_vertex_program_glVertexAttrib4sNV_pointer != 0L & this.NV_vertex_program_glVertexAttrib4fNV_pointer != 0L & this.NV_vertex_program_glVertexAttrib4dNV_pointer != 0L & this.NV_vertex_program_glVertexAttrib4ubNV_pointer != 0L & this.NV_vertex_program_glVertexAttribs1svNV_pointer != 0L & this.NV_vertex_program_glVertexAttribs1fvNV_pointer != 0L & this.NV_vertex_program_glVertexAttribs1dvNV_pointer != 0L & this.NV_vertex_program_glVertexAttribs2svNV_pointer != 0L & this.NV_vertex_program_glVertexAttribs2fvNV_pointer != 0L & this.NV_vertex_program_glVertexAttribs2dvNV_pointer != 0L & this.NV_vertex_program_glVertexAttribs3svNV_pointer != 0L & this.NV_vertex_program_glVertexAttribs3fvNV_pointer != 0L & this.NV_vertex_program_glVertexAttribs3dvNV_pointer != 0L & this.NV_vertex_program_glVertexAttribs4svNV_pointer != 0L & this.NV_vertex_program_glVertexAttribs4fvNV_pointer != 0L & this.NV_vertex_program_glVertexAttribs4dvNV_pointer != 0L;
    }

    private static void remove(Set supported_extensions, String extension) {
        LWJGLUtil.log(extension + " was reported as available but an entry point is missing");
        supported_extensions.remove(extension);
    }

    private Set initAllStubs(boolean forwardCompatible) throws LWJGLException {
        this.GL11_glGetError_pointer = GLContext.getFunctionAddress("glGetError");
        this.GL11_glGetString_pointer = GLContext.getFunctionAddress("glGetString");
        this.GL11_glGetIntegerv_pointer = GLContext.getFunctionAddress("glGetIntegerv");
        this.GL30_glGetStringi_pointer = GLContext.getFunctionAddress("glGetStringi");
        GLContext.setCapabilities(this);
        HashSet<String> supported_extensions = new HashSet<String>(256);
        int profileMask = GLContext.getSupportedExtensions(supported_extensions);
        if (supported_extensions.contains("OpenGL31") && !supported_extensions.contains("GL_ARB_compatibility") && (profileMask & 2) == 0) {
            forwardCompatible = true;
        }
        if (!this.GL11_initNativeFunctionAddresses(forwardCompatible)) {
            throw new LWJGLException("GL11 not supported");
        }
        if (supported_extensions.contains("GL_ARB_fragment_program")) {
            supported_extensions.add("GL_ARB_program");
        }
        if (supported_extensions.contains("GL_ARB_pixel_buffer_object")) {
            supported_extensions.add("GL_ARB_buffer_object");
        }
        if (supported_extensions.contains("GL_ARB_vertex_buffer_object")) {
            supported_extensions.add("GL_ARB_buffer_object");
        }
        if (supported_extensions.contains("GL_ARB_vertex_program")) {
            supported_extensions.add("GL_ARB_program");
        }
        if (supported_extensions.contains("GL_EXT_pixel_buffer_object")) {
            supported_extensions.add("GL_ARB_buffer_object");
        }
        if (supported_extensions.contains("GL_NV_fragment_program")) {
            supported_extensions.add("GL_NV_program");
        }
        if (supported_extensions.contains("GL_NV_vertex_program")) {
            supported_extensions.add("GL_NV_program");
        }
        if (supported_extensions.contains("GL_AMD_draw_buffers_blend") && !this.AMD_draw_buffers_blend_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_AMD_draw_buffers_blend");
        }
        if (supported_extensions.contains("GL_AMD_performance_monitor") && !this.AMD_performance_monitor_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_AMD_performance_monitor");
        }
        if (supported_extensions.contains("GL_AMD_vertex_shader_tessellator") && !this.AMD_vertex_shader_tessellator_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_AMD_vertex_shader_tessellator");
        }
        if (supported_extensions.contains("GL_APPLE_element_array") && !this.APPLE_element_array_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_APPLE_element_array");
        }
        if (supported_extensions.contains("GL_APPLE_fence") && !this.APPLE_fence_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_APPLE_fence");
        }
        if (supported_extensions.contains("GL_APPLE_flush_buffer_range") && !this.APPLE_flush_buffer_range_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_APPLE_flush_buffer_range");
        }
        if (supported_extensions.contains("GL_APPLE_object_purgeable") && !this.APPLE_object_purgeable_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_APPLE_object_purgeable");
        }
        if (supported_extensions.contains("GL_APPLE_texture_range") && !this.APPLE_texture_range_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_APPLE_texture_range");
        }
        if (supported_extensions.contains("GL_APPLE_vertex_array_object") && !this.APPLE_vertex_array_object_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_APPLE_vertex_array_object");
        }
        if (supported_extensions.contains("GL_APPLE_vertex_array_range") && !this.APPLE_vertex_array_range_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_APPLE_vertex_array_range");
        }
        if (supported_extensions.contains("GL_APPLE_vertex_program_evaluators") && !this.APPLE_vertex_program_evaluators_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_APPLE_vertex_program_evaluators");
        }
        if (supported_extensions.contains("GL_ARB_blend_func_extended") && !this.ARB_blend_func_extended_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_blend_func_extended");
        }
        if (supported_extensions.contains("GL_ARB_buffer_object") && !this.ARB_buffer_object_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_buffer_object");
        }
        if (supported_extensions.contains("GL_ARB_color_buffer_float") && !this.ARB_color_buffer_float_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_color_buffer_float");
        }
        if (supported_extensions.contains("GL_ARB_copy_buffer") && !this.ARB_copy_buffer_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_copy_buffer");
        }
        if (supported_extensions.contains("GL_ARB_draw_buffers") && !this.ARB_draw_buffers_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_draw_buffers");
        }
        if (supported_extensions.contains("GL_ARB_draw_buffers_blend") && !this.ARB_draw_buffers_blend_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_draw_buffers_blend");
        }
        if (supported_extensions.contains("GL_ARB_draw_elements_base_vertex") && !this.ARB_draw_elements_base_vertex_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_draw_elements_base_vertex");
        }
        if (supported_extensions.contains("GL_ARB_draw_indirect") && !this.ARB_draw_indirect_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_draw_indirect");
        }
        if (supported_extensions.contains("GL_ARB_draw_instanced") && !this.ARB_draw_instanced_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_draw_instanced");
        }
        if (supported_extensions.contains("GL_ARB_framebuffer_object") && !this.ARB_framebuffer_object_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_framebuffer_object");
        }
        if (supported_extensions.contains("GL_ARB_geometry_shader4") && !this.ARB_geometry_shader4_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_geometry_shader4");
        }
        if (supported_extensions.contains("GL_ARB_gpu_shader_fp64") && !this.ARB_gpu_shader_fp64_initNativeFunctionAddresses(supported_extensions)) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_gpu_shader_fp64");
        }
        if (supported_extensions.contains("GL_ARB_imaging") && !this.ARB_imaging_initNativeFunctionAddresses(forwardCompatible)) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_imaging");
        }
        if (supported_extensions.contains("GL_ARB_instanced_arrays") && !this.ARB_instanced_arrays_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_instanced_arrays");
        }
        if (supported_extensions.contains("GL_ARB_map_buffer_range") && !this.ARB_map_buffer_range_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_map_buffer_range");
        }
        if (supported_extensions.contains("GL_ARB_matrix_palette") && !this.ARB_matrix_palette_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_matrix_palette");
        }
        if (supported_extensions.contains("GL_ARB_multisample") && !this.ARB_multisample_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_multisample");
        }
        if (supported_extensions.contains("GL_ARB_multitexture") && !this.ARB_multitexture_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_multitexture");
        }
        if (supported_extensions.contains("GL_ARB_occlusion_query") && !this.ARB_occlusion_query_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_occlusion_query");
        }
        if (supported_extensions.contains("GL_ARB_point_parameters") && !this.ARB_point_parameters_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_point_parameters");
        }
        if (supported_extensions.contains("GL_ARB_program") && !this.ARB_program_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_program");
        }
        if (supported_extensions.contains("GL_ARB_provoking_vertex") && !this.ARB_provoking_vertex_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_provoking_vertex");
        }
        if (supported_extensions.contains("GL_ARB_sample_shading") && !this.ARB_sample_shading_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_sample_shading");
        }
        if (supported_extensions.contains("GL_ARB_sampler_objects") && !this.ARB_sampler_objects_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_sampler_objects");
        }
        if (supported_extensions.contains("GL_ARB_shader_objects") && !this.ARB_shader_objects_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_shader_objects");
        }
        if (supported_extensions.contains("GL_ARB_shader_subroutine") && !this.ARB_shader_subroutine_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_shader_subroutine");
        }
        if (supported_extensions.contains("GL_ARB_shading_language_include") && !this.ARB_shading_language_include_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_shading_language_include");
        }
        if (supported_extensions.contains("GL_ARB_sync") && !this.ARB_sync_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_sync");
        }
        if (supported_extensions.contains("GL_ARB_tessellation_shader") && !this.ARB_tessellation_shader_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_tessellation_shader");
        }
        if (supported_extensions.contains("GL_ARB_texture_buffer_object") && !this.ARB_texture_buffer_object_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_texture_buffer_object");
        }
        if (supported_extensions.contains("GL_ARB_texture_compression") && !this.ARB_texture_compression_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_texture_compression");
        }
        if (supported_extensions.contains("GL_ARB_texture_multisample") && !this.ARB_texture_multisample_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_texture_multisample");
        }
        if (supported_extensions.contains("GL_ARB_timer_query") && !this.ARB_timer_query_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_timer_query");
        }
        if (supported_extensions.contains("GL_ARB_transform_feedback2") && !this.ARB_transform_feedback2_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_transform_feedback2");
        }
        if (supported_extensions.contains("GL_ARB_transform_feedback3") && !this.ARB_transform_feedback3_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_transform_feedback3");
        }
        if (supported_extensions.contains("GL_ARB_transpose_matrix") && !this.ARB_transpose_matrix_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_transpose_matrix");
        }
        if (supported_extensions.contains("GL_ARB_uniform_buffer_object") && !this.ARB_uniform_buffer_object_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_uniform_buffer_object");
        }
        if (supported_extensions.contains("GL_ARB_vertex_array_object") && !this.ARB_vertex_array_object_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_vertex_array_object");
        }
        if (supported_extensions.contains("GL_ARB_vertex_blend") && !this.ARB_vertex_blend_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_vertex_blend");
        }
        if (supported_extensions.contains("GL_ARB_vertex_program") && !this.ARB_vertex_program_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_vertex_program");
        }
        if (supported_extensions.contains("GL_ARB_vertex_shader") && !this.ARB_vertex_shader_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_vertex_shader");
        }
        if (supported_extensions.contains("GL_ARB_vertex_type_2_10_10_10_rev") && !this.ARB_vertex_type_2_10_10_10_rev_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_vertex_type_2_10_10_10_rev");
        }
        if (supported_extensions.contains("GL_ARB_window_pos") && !this.ARB_window_pos_initNativeFunctionAddresses(forwardCompatible)) {
            ContextCapabilities.remove(supported_extensions, "GL_ARB_window_pos");
        }
        if (supported_extensions.contains("GL_ATI_draw_buffers") && !this.ATI_draw_buffers_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ATI_draw_buffers");
        }
        if (supported_extensions.contains("GL_ATI_element_array") && !this.ATI_element_array_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ATI_element_array");
        }
        if (supported_extensions.contains("GL_ATI_envmap_bumpmap") && !this.ATI_envmap_bumpmap_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ATI_envmap_bumpmap");
        }
        if (supported_extensions.contains("GL_ATI_fragment_shader") && !this.ATI_fragment_shader_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ATI_fragment_shader");
        }
        if (supported_extensions.contains("GL_ATI_map_object_buffer") && !this.ATI_map_object_buffer_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ATI_map_object_buffer");
        }
        if (supported_extensions.contains("GL_ATI_pn_triangles") && !this.ATI_pn_triangles_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ATI_pn_triangles");
        }
        if (supported_extensions.contains("GL_ATI_separate_stencil") && !this.ATI_separate_stencil_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ATI_separate_stencil");
        }
        if (supported_extensions.contains("GL_ATI_vertex_array_object") && !this.ATI_vertex_array_object_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ATI_vertex_array_object");
        }
        if (supported_extensions.contains("GL_ATI_vertex_attrib_array_object") && !this.ATI_vertex_attrib_array_object_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ATI_vertex_attrib_array_object");
        }
        if (supported_extensions.contains("GL_ATI_vertex_streams") && !this.ATI_vertex_streams_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_ATI_vertex_streams");
        }
        if (supported_extensions.contains("GL_EXT_bindable_uniform") && !this.EXT_bindable_uniform_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_bindable_uniform");
        }
        if (supported_extensions.contains("GL_EXT_blend_color") && !this.EXT_blend_color_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_blend_color");
        }
        if (supported_extensions.contains("GL_EXT_blend_equation_separate") && !this.EXT_blend_equation_separate_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_blend_equation_separate");
        }
        if (supported_extensions.contains("GL_EXT_blend_func_separate") && !this.EXT_blend_func_separate_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_blend_func_separate");
        }
        if (supported_extensions.contains("GL_EXT_blend_minmax") && !this.EXT_blend_minmax_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_blend_minmax");
        }
        if (supported_extensions.contains("GL_EXT_compiled_vertex_array") && !this.EXT_compiled_vertex_array_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_compiled_vertex_array");
        }
        if (supported_extensions.contains("GL_EXT_depth_bounds_test") && !this.EXT_depth_bounds_test_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_depth_bounds_test");
        }
        supported_extensions.add("GL_EXT_direct_state_access");
        if (supported_extensions.contains("GL_EXT_direct_state_access") && !this.EXT_direct_state_access_initNativeFunctionAddresses(forwardCompatible, supported_extensions)) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_direct_state_access");
        }
        if (supported_extensions.contains("GL_EXT_draw_buffers2") && !this.EXT_draw_buffers2_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_draw_buffers2");
        }
        if (supported_extensions.contains("GL_EXT_draw_instanced") && !this.EXT_draw_instanced_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_draw_instanced");
        }
        if (supported_extensions.contains("GL_EXT_draw_range_elements") && !this.EXT_draw_range_elements_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_draw_range_elements");
        }
        if (supported_extensions.contains("GL_EXT_fog_coord") && !this.EXT_fog_coord_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_fog_coord");
        }
        if (supported_extensions.contains("GL_EXT_framebuffer_blit") && !this.EXT_framebuffer_blit_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_framebuffer_blit");
        }
        if (supported_extensions.contains("GL_EXT_framebuffer_multisample") && !this.EXT_framebuffer_multisample_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_framebuffer_multisample");
        }
        if (supported_extensions.contains("GL_EXT_framebuffer_object") && !this.EXT_framebuffer_object_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_framebuffer_object");
        }
        if (supported_extensions.contains("GL_EXT_geometry_shader4") && !this.EXT_geometry_shader4_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_geometry_shader4");
        }
        if (supported_extensions.contains("GL_EXT_gpu_program_parameters") && !this.EXT_gpu_program_parameters_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_gpu_program_parameters");
        }
        if (supported_extensions.contains("GL_EXT_gpu_shader4") && !this.EXT_gpu_shader4_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_gpu_shader4");
        }
        if (supported_extensions.contains("GL_EXT_multi_draw_arrays") && !this.EXT_multi_draw_arrays_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_multi_draw_arrays");
        }
        if (supported_extensions.contains("GL_EXT_paletted_texture") && !this.EXT_paletted_texture_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_paletted_texture");
        }
        if (supported_extensions.contains("GL_EXT_point_parameters") && !this.EXT_point_parameters_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_point_parameters");
        }
        if (supported_extensions.contains("GL_EXT_provoking_vertex") && !this.EXT_provoking_vertex_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_provoking_vertex");
        }
        if (supported_extensions.contains("GL_EXT_secondary_color") && !this.EXT_secondary_color_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_secondary_color");
        }
        if (supported_extensions.contains("GL_EXT_separate_shader_objects") && !this.EXT_separate_shader_objects_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_separate_shader_objects");
        }
        if (supported_extensions.contains("GL_EXT_shader_image_load_store") && !this.EXT_shader_image_load_store_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_shader_image_load_store");
        }
        if (supported_extensions.contains("GL_EXT_stencil_clear_tag") && !this.EXT_stencil_clear_tag_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_stencil_clear_tag");
        }
        if (supported_extensions.contains("GL_EXT_stencil_two_side") && !this.EXT_stencil_two_side_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_stencil_two_side");
        }
        if (supported_extensions.contains("GL_EXT_texture_array") && !this.EXT_texture_array_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_texture_array");
        }
        if (supported_extensions.contains("GL_EXT_texture_buffer_object") && !this.EXT_texture_buffer_object_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_texture_buffer_object");
        }
        if (supported_extensions.contains("GL_EXT_texture_integer") && !this.EXT_texture_integer_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_texture_integer");
        }
        if (supported_extensions.contains("GL_EXT_timer_query") && !this.EXT_timer_query_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_timer_query");
        }
        if (supported_extensions.contains("GL_EXT_transform_feedback") && !this.EXT_transform_feedback_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_transform_feedback");
        }
        if (supported_extensions.contains("GL_EXT_vertex_attrib_64bit") && !this.EXT_vertex_attrib_64bit_initNativeFunctionAddresses(supported_extensions)) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_vertex_attrib_64bit");
        }
        if (supported_extensions.contains("GL_EXT_vertex_shader") && !this.EXT_vertex_shader_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_vertex_shader");
        }
        if (supported_extensions.contains("GL_EXT_vertex_weighting") && !this.EXT_vertex_weighting_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_EXT_vertex_weighting");
        }
        if (supported_extensions.contains("OpenGL12") && !this.GL12_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "OpenGL12");
        }
        if (supported_extensions.contains("OpenGL13") && !this.GL13_initNativeFunctionAddresses(forwardCompatible)) {
            ContextCapabilities.remove(supported_extensions, "OpenGL13");
        }
        if (supported_extensions.contains("OpenGL14") && !this.GL14_initNativeFunctionAddresses(forwardCompatible)) {
            ContextCapabilities.remove(supported_extensions, "OpenGL14");
        }
        if (supported_extensions.contains("OpenGL15") && !this.GL15_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "OpenGL15");
        }
        if (supported_extensions.contains("OpenGL20") && !this.GL20_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "OpenGL20");
        }
        if (supported_extensions.contains("OpenGL21") && !this.GL21_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "OpenGL21");
        }
        if (supported_extensions.contains("OpenGL30") && !this.GL30_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "OpenGL30");
        }
        if (supported_extensions.contains("OpenGL31") && !this.GL31_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "OpenGL31");
        }
        if (supported_extensions.contains("OpenGL32") && !this.GL32_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "OpenGL32");
        }
        if (supported_extensions.contains("OpenGL33") && !this.GL33_initNativeFunctionAddresses(forwardCompatible)) {
            ContextCapabilities.remove(supported_extensions, "OpenGL33");
        }
        if (supported_extensions.contains("OpenGL40") && !this.GL40_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "OpenGL40");
        }
        if (supported_extensions.contains("GL_GREMEDY_string_marker") && !this.GREMEDY_string_marker_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_GREMEDY_string_marker");
        }
        if (supported_extensions.contains("GL_NV_conditional_render") && !this.NV_conditional_render_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_conditional_render");
        }
        if (supported_extensions.contains("GL_NV_copy_image") && !this.NV_copy_image_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_copy_image");
        }
        if (supported_extensions.contains("GL_NV_depth_buffer_float") && !this.NV_depth_buffer_float_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_depth_buffer_float");
        }
        if (supported_extensions.contains("GL_NV_evaluators") && !this.NV_evaluators_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_evaluators");
        }
        if (supported_extensions.contains("GL_NV_explicit_multisample") && !this.NV_explicit_multisample_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_explicit_multisample");
        }
        if (supported_extensions.contains("GL_NV_fence") && !this.NV_fence_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_fence");
        }
        if (supported_extensions.contains("GL_NV_fragment_program") && !this.NV_fragment_program_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_fragment_program");
        }
        if (supported_extensions.contains("GL_NV_framebuffer_multisample_coverage") && !this.NV_framebuffer_multisample_coverage_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_framebuffer_multisample_coverage");
        }
        if (supported_extensions.contains("GL_NV_geometry_program4") && !this.NV_geometry_program4_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_geometry_program4");
        }
        if (supported_extensions.contains("GL_NV_gpu_program4") && !this.NV_gpu_program4_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_gpu_program4");
        }
        if (supported_extensions.contains("GL_NV_gpu_shader5") && !this.NV_gpu_shader5_initNativeFunctionAddresses(supported_extensions)) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_gpu_shader5");
        }
        if (supported_extensions.contains("GL_NV_half_float") && !this.NV_half_float_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_half_float");
        }
        if (supported_extensions.contains("GL_NV_occlusion_query") && !this.NV_occlusion_query_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_occlusion_query");
        }
        if (supported_extensions.contains("GL_NV_parameter_buffer_object") && !this.NV_parameter_buffer_object_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_parameter_buffer_object");
        }
        if (supported_extensions.contains("GL_NV_pixel_data_range") && !this.NV_pixel_data_range_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_pixel_data_range");
        }
        if (supported_extensions.contains("GL_NV_point_sprite") && !this.NV_point_sprite_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_point_sprite");
        }
        supported_extensions.add("GL_NV_primitive_restart");
        if (supported_extensions.contains("GL_NV_primitive_restart") && !this.NV_primitive_restart_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_primitive_restart");
        }
        if (supported_extensions.contains("GL_NV_program") && !this.NV_program_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_program");
        }
        if (supported_extensions.contains("GL_NV_register_combiners") && !this.NV_register_combiners_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_register_combiners");
        }
        if (supported_extensions.contains("GL_NV_register_combiners2") && !this.NV_register_combiners2_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_register_combiners2");
        }
        if (supported_extensions.contains("GL_NV_shader_buffer_load") && !this.NV_shader_buffer_load_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_shader_buffer_load");
        }
        if (supported_extensions.contains("GL_NV_texture_barrier") && !this.NV_texture_barrier_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_texture_barrier");
        }
        if (supported_extensions.contains("GL_NV_transform_feedback") && !this.NV_transform_feedback_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_transform_feedback");
        }
        if (supported_extensions.contains("GL_NV_transform_feedback2") && !this.NV_transform_feedback2_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_transform_feedback2");
        }
        if (supported_extensions.contains("GL_NV_vertex_array_range") && !this.NV_vertex_array_range_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_vertex_array_range");
        }
        if (supported_extensions.contains("GL_NV_vertex_attrib_integer_64bit") && !this.NV_vertex_attrib_integer_64bit_initNativeFunctionAddresses(supported_extensions)) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_vertex_attrib_integer_64bit");
        }
        if (supported_extensions.contains("GL_NV_vertex_buffer_unified_memory") && !this.NV_vertex_buffer_unified_memory_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_vertex_buffer_unified_memory");
        }
        if (supported_extensions.contains("GL_NV_vertex_program") && !this.NV_vertex_program_initNativeFunctionAddresses()) {
            ContextCapabilities.remove(supported_extensions, "GL_NV_vertex_program");
        }
        return supported_extensions;
    }

    static void unloadAllStubs() {
    }

    ContextCapabilities(boolean forwardCompatible) throws LWJGLException {
        Set supported_extensions = this.initAllStubs(forwardCompatible);
        this.GL_AMD_conservative_depth = supported_extensions.contains("GL_AMD_conservative_depth");
        this.GL_AMD_draw_buffers_blend = supported_extensions.contains("GL_AMD_draw_buffers_blend");
        this.GL_AMD_performance_monitor = supported_extensions.contains("GL_AMD_performance_monitor");
        this.GL_AMD_seamless_cubemap_per_texture = supported_extensions.contains("GL_AMD_seamless_cubemap_per_texture");
        this.GL_AMD_shader_stencil_export = supported_extensions.contains("GL_AMD_shader_stencil_export");
        this.GL_AMD_texture_texture4 = supported_extensions.contains("GL_AMD_texture_texture4");
        this.GL_AMD_vertex_shader_tessellator = supported_extensions.contains("GL_AMD_vertex_shader_tessellator");
        this.GL_APPLE_aux_depth_stencil = supported_extensions.contains("GL_APPLE_aux_depth_stencil");
        this.GL_APPLE_client_storage = supported_extensions.contains("GL_APPLE_client_storage");
        this.GL_APPLE_element_array = supported_extensions.contains("GL_APPLE_element_array");
        this.GL_APPLE_fence = supported_extensions.contains("GL_APPLE_fence");
        this.GL_APPLE_float_pixels = supported_extensions.contains("GL_APPLE_float_pixels");
        this.GL_APPLE_flush_buffer_range = supported_extensions.contains("GL_APPLE_flush_buffer_range");
        this.GL_APPLE_object_purgeable = supported_extensions.contains("GL_APPLE_object_purgeable");
        this.GL_APPLE_packed_pixels = supported_extensions.contains("GL_APPLE_packed_pixels");
        this.GL_APPLE_rgb_422 = supported_extensions.contains("GL_APPLE_rgb_422");
        this.GL_APPLE_row_bytes = supported_extensions.contains("GL_APPLE_row_bytes");
        this.GL_APPLE_texture_range = supported_extensions.contains("GL_APPLE_texture_range");
        this.GL_APPLE_vertex_array_object = supported_extensions.contains("GL_APPLE_vertex_array_object");
        this.GL_APPLE_vertex_array_range = supported_extensions.contains("GL_APPLE_vertex_array_range");
        this.GL_APPLE_vertex_program_evaluators = supported_extensions.contains("GL_APPLE_vertex_program_evaluators");
        this.GL_APPLE_ycbcr_422 = supported_extensions.contains("GL_APPLE_ycbcr_422");
        this.GL_ARB_blend_func_extended = supported_extensions.contains("GL_ARB_blend_func_extended");
        this.GL_ARB_color_buffer_float = supported_extensions.contains("GL_ARB_color_buffer_float");
        this.GL_ARB_compatibility = supported_extensions.contains("GL_ARB_compatibility");
        this.GL_ARB_copy_buffer = supported_extensions.contains("GL_ARB_copy_buffer");
        this.GL_ARB_depth_buffer_float = supported_extensions.contains("GL_ARB_depth_buffer_float");
        this.GL_ARB_depth_clamp = supported_extensions.contains("GL_ARB_depth_clamp");
        this.GL_ARB_depth_texture = supported_extensions.contains("GL_ARB_depth_texture");
        this.GL_ARB_draw_buffers = supported_extensions.contains("GL_ARB_draw_buffers");
        this.GL_ARB_draw_buffers_blend = supported_extensions.contains("GL_ARB_draw_buffers_blend");
        this.GL_ARB_draw_elements_base_vertex = supported_extensions.contains("GL_ARB_draw_elements_base_vertex");
        this.GL_ARB_draw_indirect = supported_extensions.contains("GL_ARB_draw_indirect");
        this.GL_ARB_draw_instanced = supported_extensions.contains("GL_ARB_draw_instanced");
        this.GL_ARB_explicit_attrib_location = supported_extensions.contains("GL_ARB_explicit_attrib_location");
        this.GL_ARB_fragment_coord_conventions = supported_extensions.contains("GL_ARB_fragment_coord_conventions");
        this.GL_ARB_fragment_program = supported_extensions.contains("GL_ARB_fragment_program") && supported_extensions.contains("GL_ARB_program");
        this.GL_ARB_fragment_program_shadow = supported_extensions.contains("GL_ARB_fragment_program_shadow");
        this.GL_ARB_fragment_shader = supported_extensions.contains("GL_ARB_fragment_shader");
        this.GL_ARB_framebuffer_object = supported_extensions.contains("GL_ARB_framebuffer_object");
        this.GL_ARB_framebuffer_sRGB = supported_extensions.contains("GL_ARB_framebuffer_sRGB");
        this.GL_ARB_geometry_shader4 = supported_extensions.contains("GL_ARB_geometry_shader4");
        this.GL_ARB_gpu_shader5 = supported_extensions.contains("GL_ARB_gpu_shader5");
        this.GL_ARB_gpu_shader_fp64 = supported_extensions.contains("GL_ARB_gpu_shader_fp64");
        this.GL_ARB_half_float_pixel = supported_extensions.contains("GL_ARB_half_float_pixel");
        this.GL_ARB_half_float_vertex = supported_extensions.contains("GL_ARB_half_float_vertex");
        this.GL_ARB_imaging = supported_extensions.contains("GL_ARB_imaging");
        this.GL_ARB_instanced_arrays = supported_extensions.contains("GL_ARB_instanced_arrays");
        this.GL_ARB_map_buffer_range = supported_extensions.contains("GL_ARB_map_buffer_range");
        this.GL_ARB_matrix_palette = supported_extensions.contains("GL_ARB_matrix_palette");
        this.GL_ARB_multisample = supported_extensions.contains("GL_ARB_multisample");
        this.GL_ARB_multitexture = supported_extensions.contains("GL_ARB_multitexture");
        this.GL_ARB_occlusion_query = supported_extensions.contains("GL_ARB_occlusion_query");
        this.GL_ARB_occlusion_query2 = supported_extensions.contains("GL_ARB_occlusion_query2");
        this.GL_ARB_pixel_buffer_object = supported_extensions.contains("GL_ARB_pixel_buffer_object") && supported_extensions.contains("GL_ARB_buffer_object");
        this.GL_ARB_point_parameters = supported_extensions.contains("GL_ARB_point_parameters");
        this.GL_ARB_point_sprite = supported_extensions.contains("GL_ARB_point_sprite");
        this.GL_ARB_provoking_vertex = supported_extensions.contains("GL_ARB_provoking_vertex");
        this.GL_ARB_sample_shading = supported_extensions.contains("GL_ARB_sample_shading");
        this.GL_ARB_sampler_objects = supported_extensions.contains("GL_ARB_sampler_objects");
        this.GL_ARB_seamless_cube_map = supported_extensions.contains("GL_ARB_seamless_cube_map");
        this.GL_ARB_shader_bit_encoding = supported_extensions.contains("GL_ARB_shader_bit_encoding");
        this.GL_ARB_shader_objects = supported_extensions.contains("GL_ARB_shader_objects");
        this.GL_ARB_shader_subroutine = supported_extensions.contains("GL_ARB_shader_subroutine");
        this.GL_ARB_shader_texture_lod = supported_extensions.contains("GL_ARB_shader_texture_lod");
        this.GL_ARB_shading_language_100 = supported_extensions.contains("GL_ARB_shading_language_100");
        this.GL_ARB_shading_language_include = supported_extensions.contains("GL_ARB_shading_language_include");
        this.GL_ARB_shadow = supported_extensions.contains("GL_ARB_shadow");
        this.GL_ARB_shadow_ambient = supported_extensions.contains("GL_ARB_shadow_ambient");
        this.GL_ARB_sync = supported_extensions.contains("GL_ARB_sync");
        this.GL_ARB_tessellation_shader = supported_extensions.contains("GL_ARB_tessellation_shader");
        this.GL_ARB_texture_border_clamp = supported_extensions.contains("GL_ARB_texture_border_clamp");
        this.GL_ARB_texture_buffer_object = supported_extensions.contains("GL_ARB_texture_buffer_object");
        this.GL_ARB_texture_buffer_object_rgb32 = supported_extensions.contains("GL_ARB_texture_buffer_object_rgb32");
        this.GL_ARB_texture_compression = supported_extensions.contains("GL_ARB_texture_compression");
        this.GL_ARB_texture_compression_bptc = supported_extensions.contains("GL_ARB_texture_compression_bptc");
        this.GL_ARB_texture_compression_rgtc = supported_extensions.contains("GL_ARB_texture_compression_rgtc");
        this.GL_ARB_texture_cube_map = supported_extensions.contains("GL_ARB_texture_cube_map");
        this.GL_ARB_texture_cube_map_array = supported_extensions.contains("GL_ARB_texture_cube_map_array");
        this.GL_ARB_texture_env_add = supported_extensions.contains("GL_ARB_texture_env_add");
        this.GL_ARB_texture_env_combine = supported_extensions.contains("GL_ARB_texture_env_combine");
        this.GL_ARB_texture_env_crossbar = supported_extensions.contains("GL_ARB_texture_env_crossbar");
        this.GL_ARB_texture_env_dot3 = supported_extensions.contains("GL_ARB_texture_env_dot3");
        this.GL_ARB_texture_float = supported_extensions.contains("GL_ARB_texture_float");
        this.GL_ARB_texture_gather = supported_extensions.contains("GL_ARB_texture_gather");
        this.GL_ARB_texture_mirrored_repeat = supported_extensions.contains("GL_ARB_texture_mirrored_repeat");
        this.GL_ARB_texture_multisample = supported_extensions.contains("GL_ARB_texture_multisample");
        this.GL_ARB_texture_non_power_of_two = supported_extensions.contains("GL_ARB_texture_non_power_of_two");
        this.GL_ARB_texture_query_lod = supported_extensions.contains("GL_ARB_texture_query_lod");
        this.GL_ARB_texture_rectangle = supported_extensions.contains("GL_ARB_texture_rectangle");
        this.GL_ARB_texture_rg = supported_extensions.contains("GL_ARB_texture_rg");
        this.GL_ARB_texture_rgb10_a2ui = supported_extensions.contains("GL_ARB_texture_rgb10_a2ui");
        this.GL_ARB_texture_swizzle = supported_extensions.contains("GL_ARB_texture_swizzle");
        this.GL_ARB_timer_query = supported_extensions.contains("GL_ARB_timer_query");
        this.GL_ARB_transform_feedback2 = supported_extensions.contains("GL_ARB_transform_feedback2");
        this.GL_ARB_transform_feedback3 = supported_extensions.contains("GL_ARB_transform_feedback3");
        this.GL_ARB_transpose_matrix = supported_extensions.contains("GL_ARB_transpose_matrix");
        this.GL_ARB_uniform_buffer_object = supported_extensions.contains("GL_ARB_uniform_buffer_object");
        this.GL_ARB_vertex_array_bgra = supported_extensions.contains("GL_ARB_vertex_array_bgra");
        this.GL_ARB_vertex_array_object = supported_extensions.contains("GL_ARB_vertex_array_object");
        this.GL_ARB_vertex_blend = supported_extensions.contains("GL_ARB_vertex_blend");
        this.GL_ARB_vertex_buffer_object = supported_extensions.contains("GL_ARB_vertex_buffer_object") && supported_extensions.contains("GL_ARB_buffer_object");
        this.GL_ARB_vertex_program = supported_extensions.contains("GL_ARB_vertex_program") && supported_extensions.contains("GL_ARB_program");
        this.GL_ARB_vertex_shader = supported_extensions.contains("GL_ARB_vertex_shader");
        this.GL_ARB_vertex_type_2_10_10_10_rev = supported_extensions.contains("GL_ARB_vertex_type_2_10_10_10_rev");
        this.GL_ARB_window_pos = supported_extensions.contains("GL_ARB_window_pos");
        this.GL_ATI_draw_buffers = supported_extensions.contains("GL_ATI_draw_buffers");
        this.GL_ATI_element_array = supported_extensions.contains("GL_ATI_element_array");
        this.GL_ATI_envmap_bumpmap = supported_extensions.contains("GL_ATI_envmap_bumpmap");
        this.GL_ATI_fragment_shader = supported_extensions.contains("GL_ATI_fragment_shader");
        this.GL_ATI_map_object_buffer = supported_extensions.contains("GL_ATI_map_object_buffer");
        this.GL_ATI_meminfo = supported_extensions.contains("GL_ATI_meminfo");
        this.GL_ATI_pn_triangles = supported_extensions.contains("GL_ATI_pn_triangles");
        this.GL_ATI_separate_stencil = supported_extensions.contains("GL_ATI_separate_stencil");
        this.GL_ATI_shader_texture_lod = supported_extensions.contains("GL_ATI_shader_texture_lod");
        this.GL_ATI_text_fragment_shader = supported_extensions.contains("GL_ATI_text_fragment_shader");
        this.GL_ATI_texture_compression_3dc = supported_extensions.contains("GL_ATI_texture_compression_3dc");
        this.GL_ATI_texture_env_combine3 = supported_extensions.contains("GL_ATI_texture_env_combine3");
        this.GL_ATI_texture_float = supported_extensions.contains("GL_ATI_texture_float");
        this.GL_ATI_texture_mirror_once = supported_extensions.contains("GL_ATI_texture_mirror_once");
        this.GL_ATI_vertex_array_object = supported_extensions.contains("GL_ATI_vertex_array_object");
        this.GL_ATI_vertex_attrib_array_object = supported_extensions.contains("GL_ATI_vertex_attrib_array_object");
        this.GL_ATI_vertex_streams = supported_extensions.contains("GL_ATI_vertex_streams");
        this.GL_EXT_abgr = supported_extensions.contains("GL_EXT_abgr");
        this.GL_EXT_bgra = supported_extensions.contains("GL_EXT_bgra");
        this.GL_EXT_bindable_uniform = supported_extensions.contains("GL_EXT_bindable_uniform");
        this.GL_EXT_blend_color = supported_extensions.contains("GL_EXT_blend_color");
        this.GL_EXT_blend_equation_separate = supported_extensions.contains("GL_EXT_blend_equation_separate");
        this.GL_EXT_blend_func_separate = supported_extensions.contains("GL_EXT_blend_func_separate");
        this.GL_EXT_blend_minmax = supported_extensions.contains("GL_EXT_blend_minmax");
        this.GL_EXT_blend_subtract = supported_extensions.contains("GL_EXT_blend_subtract");
        this.GL_EXT_Cg_shader = supported_extensions.contains("GL_EXT_Cg_shader");
        this.GL_EXT_compiled_vertex_array = supported_extensions.contains("GL_EXT_compiled_vertex_array");
        this.GL_EXT_depth_bounds_test = supported_extensions.contains("GL_EXT_depth_bounds_test");
        this.GL_EXT_direct_state_access = supported_extensions.contains("GL_EXT_direct_state_access");
        this.GL_EXT_draw_buffers2 = supported_extensions.contains("GL_EXT_draw_buffers2");
        this.GL_EXT_draw_instanced = supported_extensions.contains("GL_EXT_draw_instanced");
        this.GL_EXT_draw_range_elements = supported_extensions.contains("GL_EXT_draw_range_elements");
        this.GL_EXT_fog_coord = supported_extensions.contains("GL_EXT_fog_coord");
        this.GL_EXT_framebuffer_blit = supported_extensions.contains("GL_EXT_framebuffer_blit");
        this.GL_EXT_framebuffer_multisample = supported_extensions.contains("GL_EXT_framebuffer_multisample");
        this.GL_EXT_framebuffer_object = supported_extensions.contains("GL_EXT_framebuffer_object");
        this.GL_EXT_framebuffer_sRGB = supported_extensions.contains("GL_EXT_framebuffer_sRGB");
        this.GL_EXT_geometry_shader4 = supported_extensions.contains("GL_EXT_geometry_shader4");
        this.GL_EXT_gpu_program_parameters = supported_extensions.contains("GL_EXT_gpu_program_parameters");
        this.GL_EXT_gpu_shader4 = supported_extensions.contains("GL_EXT_gpu_shader4");
        this.GL_EXT_multi_draw_arrays = supported_extensions.contains("GL_EXT_multi_draw_arrays");
        this.GL_EXT_packed_depth_stencil = supported_extensions.contains("GL_EXT_packed_depth_stencil");
        this.GL_EXT_packed_float = supported_extensions.contains("GL_EXT_packed_float");
        this.GL_EXT_packed_pixels = supported_extensions.contains("GL_EXT_packed_pixels");
        this.GL_EXT_paletted_texture = supported_extensions.contains("GL_EXT_paletted_texture");
        this.GL_EXT_pixel_buffer_object = supported_extensions.contains("GL_EXT_pixel_buffer_object") && supported_extensions.contains("GL_ARB_buffer_object");
        this.GL_EXT_point_parameters = supported_extensions.contains("GL_EXT_point_parameters");
        this.GL_EXT_provoking_vertex = supported_extensions.contains("GL_EXT_provoking_vertex");
        this.GL_EXT_rescale_normal = supported_extensions.contains("GL_EXT_rescale_normal");
        this.GL_EXT_secondary_color = supported_extensions.contains("GL_EXT_secondary_color");
        this.GL_EXT_separate_shader_objects = supported_extensions.contains("GL_EXT_separate_shader_objects");
        this.GL_EXT_separate_specular_color = supported_extensions.contains("GL_EXT_separate_specular_color");
        this.GL_EXT_shader_image_load_store = supported_extensions.contains("GL_EXT_shader_image_load_store");
        this.GL_EXT_shadow_funcs = supported_extensions.contains("GL_EXT_shadow_funcs");
        this.GL_EXT_shared_texture_palette = supported_extensions.contains("GL_EXT_shared_texture_palette");
        this.GL_EXT_stencil_clear_tag = supported_extensions.contains("GL_EXT_stencil_clear_tag");
        this.GL_EXT_stencil_two_side = supported_extensions.contains("GL_EXT_stencil_two_side");
        this.GL_EXT_stencil_wrap = supported_extensions.contains("GL_EXT_stencil_wrap");
        this.GL_EXT_texture_3d = supported_extensions.contains("GL_EXT_texture_3d");
        this.GL_EXT_texture_array = supported_extensions.contains("GL_EXT_texture_array");
        this.GL_EXT_texture_buffer_object = supported_extensions.contains("GL_EXT_texture_buffer_object");
        this.GL_EXT_texture_compression_latc = supported_extensions.contains("GL_EXT_texture_compression_latc");
        this.GL_EXT_texture_compression_rgtc = supported_extensions.contains("GL_EXT_texture_compression_rgtc");
        this.GL_EXT_texture_compression_s3tc = supported_extensions.contains("GL_EXT_texture_compression_s3tc");
        this.GL_EXT_texture_env_combine = supported_extensions.contains("GL_EXT_texture_env_combine");
        this.GL_EXT_texture_env_dot3 = supported_extensions.contains("GL_EXT_texture_env_dot3");
        this.GL_EXT_texture_filter_anisotropic = supported_extensions.contains("GL_EXT_texture_filter_anisotropic");
        this.GL_EXT_texture_integer = supported_extensions.contains("GL_EXT_texture_integer");
        this.GL_EXT_texture_lod_bias = supported_extensions.contains("GL_EXT_texture_lod_bias");
        this.GL_EXT_texture_mirror_clamp = supported_extensions.contains("GL_EXT_texture_mirror_clamp");
        this.GL_EXT_texture_rectangle = supported_extensions.contains("GL_EXT_texture_rectangle");
        this.GL_EXT_texture_sRGB = supported_extensions.contains("GL_EXT_texture_sRGB");
        this.GL_EXT_texture_shared_exponent = supported_extensions.contains("GL_EXT_texture_shared_exponent");
        this.GL_EXT_texture_snorm = supported_extensions.contains("GL_EXT_texture_snorm");
        this.GL_EXT_texture_swizzle = supported_extensions.contains("GL_EXT_texture_swizzle");
        this.GL_EXT_timer_query = supported_extensions.contains("GL_EXT_timer_query");
        this.GL_EXT_transform_feedback = supported_extensions.contains("GL_EXT_transform_feedback");
        this.GL_EXT_vertex_array_bgra = supported_extensions.contains("GL_EXT_vertex_array_bgra");
        this.GL_EXT_vertex_attrib_64bit = supported_extensions.contains("GL_EXT_vertex_attrib_64bit");
        this.GL_EXT_vertex_shader = supported_extensions.contains("GL_EXT_vertex_shader");
        this.GL_EXT_vertex_weighting = supported_extensions.contains("GL_EXT_vertex_weighting");
        this.OpenGL11 = supported_extensions.contains("OpenGL11");
        this.OpenGL12 = supported_extensions.contains("OpenGL12");
        this.OpenGL13 = supported_extensions.contains("OpenGL13");
        this.OpenGL14 = supported_extensions.contains("OpenGL14");
        this.OpenGL15 = supported_extensions.contains("OpenGL15");
        this.OpenGL20 = supported_extensions.contains("OpenGL20");
        this.OpenGL21 = supported_extensions.contains("OpenGL21");
        this.OpenGL30 = supported_extensions.contains("OpenGL30");
        this.OpenGL31 = supported_extensions.contains("OpenGL31");
        this.OpenGL32 = supported_extensions.contains("OpenGL32");
        this.OpenGL33 = supported_extensions.contains("OpenGL33");
        this.OpenGL40 = supported_extensions.contains("OpenGL40");
        this.GL_GREMEDY_string_marker = supported_extensions.contains("GL_GREMEDY_string_marker");
        this.GL_HP_occlusion_test = supported_extensions.contains("GL_HP_occlusion_test");
        this.GL_IBM_rasterpos_clip = supported_extensions.contains("GL_IBM_rasterpos_clip");
        this.GL_NVX_gpu_memory_info = supported_extensions.contains("GL_NVX_gpu_memory_info");
        this.GL_NV_blend_square = supported_extensions.contains("GL_NV_blend_square");
        this.GL_NV_conditional_render = supported_extensions.contains("GL_NV_conditional_render");
        this.GL_NV_copy_depth_to_color = supported_extensions.contains("GL_NV_copy_depth_to_color");
        this.GL_NV_copy_image = supported_extensions.contains("GL_NV_copy_image");
        this.GL_NV_depth_buffer_float = supported_extensions.contains("GL_NV_depth_buffer_float");
        this.GL_NV_depth_clamp = supported_extensions.contains("GL_NV_depth_clamp");
        this.GL_NV_evaluators = supported_extensions.contains("GL_NV_evaluators");
        this.GL_NV_explicit_multisample = supported_extensions.contains("GL_NV_explicit_multisample");
        this.GL_NV_fence = supported_extensions.contains("GL_NV_fence");
        this.GL_NV_float_buffer = supported_extensions.contains("GL_NV_float_buffer");
        this.GL_NV_fog_distance = supported_extensions.contains("GL_NV_fog_distance");
        this.GL_NV_fragment_program = supported_extensions.contains("GL_NV_fragment_program") && supported_extensions.contains("GL_NV_program");
        this.GL_NV_fragment_program2 = supported_extensions.contains("GL_NV_fragment_program2");
        this.GL_NV_fragment_program4 = supported_extensions.contains("GL_NV_fragment_program4");
        this.GL_NV_fragment_program_option = supported_extensions.contains("GL_NV_fragment_program_option");
        this.GL_NV_framebuffer_multisample_coverage = supported_extensions.contains("GL_NV_framebuffer_multisample_coverage");
        this.GL_NV_geometry_program4 = supported_extensions.contains("GL_NV_geometry_program4");
        this.GL_NV_geometry_shader4 = supported_extensions.contains("GL_NV_geometry_shader4");
        this.GL_NV_gpu_program4 = supported_extensions.contains("GL_NV_gpu_program4");
        this.GL_NV_gpu_program5 = supported_extensions.contains("GL_NV_gpu_program5");
        this.GL_NV_gpu_shader5 = supported_extensions.contains("GL_NV_gpu_shader5");
        this.GL_NV_half_float = supported_extensions.contains("GL_NV_half_float");
        this.GL_NV_light_max_exponent = supported_extensions.contains("GL_NV_light_max_exponent");
        this.GL_NV_multisample_filter_hint = supported_extensions.contains("GL_NV_multisample_filter_hint");
        this.GL_NV_occlusion_query = supported_extensions.contains("GL_NV_occlusion_query");
        this.GL_NV_packed_depth_stencil = supported_extensions.contains("GL_NV_packed_depth_stencil");
        this.GL_NV_parameter_buffer_object = supported_extensions.contains("GL_NV_parameter_buffer_object");
        this.GL_NV_parameter_buffer_object2 = supported_extensions.contains("GL_NV_parameter_buffer_object2");
        this.GL_NV_pixel_data_range = supported_extensions.contains("GL_NV_pixel_data_range");
        this.GL_NV_point_sprite = supported_extensions.contains("GL_NV_point_sprite");
        this.GL_NV_primitive_restart = supported_extensions.contains("GL_NV_primitive_restart");
        this.GL_NV_register_combiners = supported_extensions.contains("GL_NV_register_combiners");
        this.GL_NV_register_combiners2 = supported_extensions.contains("GL_NV_register_combiners2");
        this.GL_NV_shader_buffer_load = supported_extensions.contains("GL_NV_shader_buffer_load");
        this.GL_NV_shader_buffer_store = supported_extensions.contains("GL_NV_shader_buffer_store");
        this.GL_NV_tessellation_program5 = supported_extensions.contains("GL_NV_tessellation_program5");
        this.GL_NV_texgen_reflection = supported_extensions.contains("GL_NV_texgen_reflection");
        this.GL_NV_texture_barrier = supported_extensions.contains("GL_NV_texture_barrier");
        this.GL_NV_texture_compression_vtc = supported_extensions.contains("GL_NV_texture_compression_vtc");
        this.GL_NV_texture_env_combine4 = supported_extensions.contains("GL_NV_texture_env_combine4");
        this.GL_NV_texture_expand_normal = supported_extensions.contains("GL_NV_texture_expand_normal");
        this.GL_NV_texture_rectangle = supported_extensions.contains("GL_NV_texture_rectangle");
        this.GL_NV_texture_shader = supported_extensions.contains("GL_NV_texture_shader");
        this.GL_NV_texture_shader2 = supported_extensions.contains("GL_NV_texture_shader2");
        this.GL_NV_texture_shader3 = supported_extensions.contains("GL_NV_texture_shader3");
        this.GL_NV_transform_feedback = supported_extensions.contains("GL_NV_transform_feedback");
        this.GL_NV_transform_feedback2 = supported_extensions.contains("GL_NV_transform_feedback2");
        this.GL_NV_vertex_array_range = supported_extensions.contains("GL_NV_vertex_array_range");
        this.GL_NV_vertex_array_range2 = supported_extensions.contains("GL_NV_vertex_array_range2");
        this.GL_NV_vertex_attrib_integer_64bit = supported_extensions.contains("GL_NV_vertex_attrib_integer_64bit");
        this.GL_NV_vertex_buffer_unified_memory = supported_extensions.contains("GL_NV_vertex_buffer_unified_memory");
        this.GL_NV_vertex_program = supported_extensions.contains("GL_NV_vertex_program") && supported_extensions.contains("GL_NV_program");
        this.GL_NV_vertex_program1_1 = supported_extensions.contains("GL_NV_vertex_program1_1");
        this.GL_NV_vertex_program2 = supported_extensions.contains("GL_NV_vertex_program2");
        this.GL_NV_vertex_program2_option = supported_extensions.contains("GL_NV_vertex_program2_option");
        this.GL_NV_vertex_program3 = supported_extensions.contains("GL_NV_vertex_program3");
        this.GL_NV_vertex_program4 = supported_extensions.contains("GL_NV_vertex_program4");
        this.GL_SGIS_generate_mipmap = supported_extensions.contains("GL_SGIS_generate_mipmap");
        this.GL_SGIS_texture_lod = supported_extensions.contains("GL_SGIS_texture_lod");
        this.GL_SUN_slice_accum = supported_extensions.contains("GL_SUN_slice_accum");
        this.tracker.init();
    }
}

